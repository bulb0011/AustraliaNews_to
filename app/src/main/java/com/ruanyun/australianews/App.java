package com.ruanyun.australianews;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.iflytek.cloud.SpeechUtility;
import com.meiqia.core.callback.OnInitCallback;
import com.meiqia.meiqiasdk.util.MQConfig;
import com.mob.MobSDK;
import com.ruanyun.australianews.di.component.DaggerApplicationComponent;
import com.ruanyun.australianews.model.UserInfo;
import com.ruanyun.australianews.util.CacheHelper;
import com.ruanyun.australianews.util.CommonUtil;
import com.ruanyun.imagepicker.Util;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;

import java.util.Vector;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasBroadcastReceiverInjector;
import dagger.android.HasContentProviderInjector;
import dagger.android.HasFragmentInjector;
import dagger.android.HasServiceInjector;
import dagger.android.support.HasSupportFragmentInjector;
import jiguang.chat.application.JGApplication;

/**
 * Description:
 * author: zhangsan on 2017/12/5 上午9:01.
 */

public class App extends JGApplication implements HasActivityInjector, HasFragmentInjector, HasServiceInjector,
        HasBroadcastReceiverInjector, HasContentProviderInjector, HasSupportFragmentInjector {
    private UserInfo user;
    private String cityName = "";
    public String longitude;//经度
    public String latitude;//纬度

    public static App app;
    private Vector<Activity> activityStacks = new Vector<Activity>();
    @Inject
    CacheHelper cacheHelper;
    public String iso;
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        TelephonyManager telManager=  (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        iso = telManager.getSimCountryIso();
        app = this;

        injectIfNecessary();
        CommonUtil.setAppContext(this);
        Util.setUriAuthority(this);
        Beta.initDelay = 8000;
        Bugly.init(app, "c403c42348", true);
        SDKInitializer.initialize(this);
        SDKInitializer.setCoordType(CoordType.BD09LL);
//        initWebView();
        MobSDK.init(this);

        SpeechUtility.createUtility(App.this, "appid=" + getString(R.string.iflytek));

        MQConfig.init(this, "4bd2a25e767a4728c81e31a04491d106", new OnInitCallback() {
            @Override
            public void onSuccess(String s) {



            }

            @Override
            public void onFailure(int i, String s) {

            }
        });

    }

    public Boolean isLogin() {
        return user!=null;
    }

    public void setUser(UserInfo user) {
        this.user = user;
        cacheHelper.saveUser(user);
    }

    public UserInfo getUser() {
        if (user == null)
            user = cacheHelper.getLastLoginUser();
        return user;
    }

    public String getUserOid() {
        if (getUser() != null)
            return user.oid;
        return "";
    }

    public String getCityName() {
        if(TextUtils.isEmpty(cityName)){
            return cacheHelper.getCityName();
        }
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
        cacheHelper.setCityName(cityName);
    }

    public static App getInstance() {
        return app;
    }

    public void pushActivity(Activity activity) {
        if (!activityStacks.contains(activity)) {
            activityStacks.add(activity);
        }
    }

    public void popActivity(Activity activity) {
        activityStacks.remove(activity);
    }

    public void exitApp() {
        for (Activity activity : activityStacks) {
            activity.finish();
        }
        activityStacks.clear();
    }

    public void exitApp(String exceptActivity) {
        for (Activity activity : activityStacks) {
            if (!activity.getLocalClassName().equals(exceptActivity)) {
                activity.finish();
            }
        }
        activityStacks.clear();
    }

    /**
     * 判断activity是否在运行
     *
     * @param cls
     * @return
     */
    public boolean containsActivity(Class<?> cls) {
        for (Activity activityStack : activityStacks) {
            if (activityStack.getClass().getName().equals(cls.getName())) {
                return true;
            }
        }
        return false;
    }

//    private void initWebView() {
//        QbSdk.initX5Environment(this, new QbSdk.PreInitCallback() {
//            @Override
//            public void onCoreInitFinished() {
//                LogX.e("retrofit", "onCoreInitFinished() called");
//            }
//
//            @Override
//            public void onViewInitFinished(boolean b) {
//                LogX.e("retrofit", "onViewInitFinished() called with: b = [" + b + "]");
//            }
//        });
//
//    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////

    protected AndroidInjector<? extends Application> applicationInjector() {
        return DaggerApplicationComponent.builder().application(this).build();
    }


    @Inject DispatchingAndroidInjector<android.support.v4.app.Fragment> supportFragmentInjector;

    @Override
    public DispatchingAndroidInjector<android.support.v4.app.Fragment> supportFragmentInjector() {
        return supportFragmentInjector;
    }


    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;
    @Inject DispatchingAndroidInjector<BroadcastReceiver> broadcastReceiverInjector;
    @Inject DispatchingAndroidInjector<Fragment> fragmentInjector;
    @Inject DispatchingAndroidInjector<Service> serviceInjector;
    @Inject DispatchingAndroidInjector<ContentProvider> contentProviderInjector;
    private volatile boolean needToInject = true;

    /**
     * Lazily injects the {@link dagger.android.DaggerApplication}'s members. Injection cannot be performed in {@link
     * Application#onCreate()} since {@link android.content.ContentProvider}s' {@link
     * android.content.ContentProvider#onCreate() onCreate()} method will be called first and might
     * need injected members on the application. Injection is not performed in the constructor, as
     * that may datas in members-injection methods being called before the constructor has completed,
     * allowing for a partially-constructed instance to escape.
     */
    private void injectIfNecessary() {
        if (needToInject) {
            synchronized (this) {
                if (needToInject) {
                    @SuppressWarnings("unchecked")
                    AndroidInjector<Application> applicationInjector =
                            (AndroidInjector<Application>) applicationInjector();
                    applicationInjector.inject(this);
                    if (needToInject) {
                        throw new IllegalStateException(
                                "The AndroidInjector returned from applicationInjector() did not inject the "
                                        + "DaggerApplication");
                    }
                }
            }
        }
    }

    @Inject
    void setInjected() {
        needToInject = false;
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }

    @Override
    public DispatchingAndroidInjector<Fragment> fragmentInjector() {
        return fragmentInjector;
    }

    @Override
    public DispatchingAndroidInjector<BroadcastReceiver> broadcastReceiverInjector() {
        return broadcastReceiverInjector;
    }

    @Override
    public DispatchingAndroidInjector<Service> serviceInjector() {
        return serviceInjector;
    }

    // injectIfNecessary is called here but not on the other *Injector() methods because it is the
    // only one that should be called (in AndroidInjection.inject(ContentProvider)) before
    // Application.onCreate()
    @Override
    public AndroidInjector<ContentProvider> contentProviderInjector() {
        injectIfNecessary();
        return contentProviderInjector;
    }
}
