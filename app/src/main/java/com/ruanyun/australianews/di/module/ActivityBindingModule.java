package com.ruanyun.australianews.di.module;

import com.ruanyun.australianews.di.ActivityScoped;
import com.ruanyun.australianews.di.FragmentScoped;
import com.ruanyun.australianews.ui.CityListActivity;
import com.ruanyun.australianews.ui.GuideActivity;
import com.ruanyun.australianews.ui.MainActivity;
import com.ruanyun.australianews.ui.MultipleSelectionActivity;
import com.ruanyun.australianews.ui.SplashActivity;
import com.ruanyun.australianews.ui.TextActivi;
import com.ruanyun.australianews.ui.WebViewActivity;
import com.ruanyun.australianews.ui.im.MessageListActivity;
import com.ruanyun.australianews.ui.im.P2pChatActivity;
import com.ruanyun.australianews.ui.life.BusinessTransferListActivity;
import com.ruanyun.australianews.ui.life.CarSaleListActivity;
import com.ruanyun.australianews.ui.life.HouseDemandListActivity;
import com.ruanyun.australianews.ui.life.HouseRentListActivity;
import com.ruanyun.australianews.ui.life.PetTransactionListActivity;
import com.ruanyun.australianews.ui.life.RecruitmentListActivity;
import com.ruanyun.australianews.ui.life.ShopListActivity;
import com.ruanyun.australianews.ui.life.TextbookListActivity;
import com.ruanyun.australianews.ui.life.TransactionMarketListActivity;
import com.ruanyun.australianews.ui.life.YellowPageListActivity;
import com.ruanyun.australianews.ui.life.main.LifeHomeFragment;
import com.ruanyun.australianews.ui.life.main.LifeMainActivity;
import com.ruanyun.australianews.ui.life.main.LifeMyFragment;
import com.ruanyun.australianews.ui.life.main.SelectReleaseLifeTypeActivity;
import com.ruanyun.australianews.ui.life.main.SelectReleaseTypeActivity;
import com.ruanyun.australianews.ui.life.main.YellowPageFragment;
import com.ruanyun.australianews.ui.life.release.MapPointActivity;
import com.ruanyun.australianews.ui.life.release.ReleaseBusinessTransferActivity;
import com.ruanyun.australianews.ui.life.release.ReleaseCarSaleActivity;
import com.ruanyun.australianews.ui.life.release.ReleaseHouseDemandActivity;
import com.ruanyun.australianews.ui.life.release.ReleaseHouseRentActivity;
import com.ruanyun.australianews.ui.life.release.ReleasePetTransactionActivity;
import com.ruanyun.australianews.ui.life.release.ReleasePetTransactionSelectTypeActivity;
import com.ruanyun.australianews.ui.life.release.ReleaseRecruitmentActivity;
import com.ruanyun.australianews.ui.life.release.ReleaseShopActivity;
import com.ruanyun.australianews.ui.life.release.ReleaseShopGoodsActivity;
import com.ruanyun.australianews.ui.life.release.ReleaseTextbookActivity;
import com.ruanyun.australianews.ui.life.release.ReleaseTransactionMarketActivity;
import com.ruanyun.australianews.ui.life.release.ReleaseYellowPageActivity;
import com.ruanyun.australianews.ui.login.CountryAreaCodeSelectActivity;
import com.ruanyun.australianews.ui.login.ForgetPasswordActivity;
import com.ruanyun.australianews.ui.login.LoginActivity;
import com.ruanyun.australianews.ui.login.ModifyPasswordActivity;
import com.ruanyun.australianews.ui.login.RegisteredActivity;
import com.ruanyun.australianews.ui.login.RegisteredBindActivity;
import com.ruanyun.australianews.ui.main.ActivitysListActivity;
import com.ruanyun.australianews.ui.main.ActivitysListFragment;
import com.ruanyun.australianews.ui.main.MyFragment;
import com.ruanyun.australianews.ui.main.NewsFragment;
import com.ruanyun.australianews.ui.main.NewsListChildFragment;
import com.ruanyun.australianews.ui.main.ReleaseActivitysActivity;
import com.ruanyun.australianews.ui.main.SearchActivity;
import com.ruanyun.australianews.ui.main.SearchLifeListFragment;
import com.ruanyun.australianews.ui.main.SearchNewsListFragment;
import com.ruanyun.australianews.ui.main.VipFragment;
import com.ruanyun.australianews.ui.main.WebviewFragment;
import com.ruanyun.australianews.ui.my.AboutUsListActivity;
import com.ruanyun.australianews.ui.my.CurriculumFragment;
import com.ruanyun.australianews.ui.my.FeedbackActivity;
import com.ruanyun.australianews.ui.my.HomePageEvaluationListFragment;
import com.ruanyun.australianews.ui.my.HomePageReleaseLifeListFragment;
import com.ruanyun.australianews.ui.my.HomePageReleaseWealthListFragment;
import com.ruanyun.australianews.ui.my.MemberFragment;
import com.ruanyun.australianews.ui.my.MyBrowseRecordActivity;
import com.ruanyun.australianews.ui.my.MyBrowseRecordLifeListFragment;
import com.ruanyun.australianews.ui.my.MyBrowseRecordNewListFragment;
import com.ruanyun.australianews.ui.my.MyCollectionActivity;
import com.ruanyun.australianews.ui.my.MyCollectionLifeListFragment;
import com.ruanyun.australianews.ui.my.MyCollectionNewsListFragment;
import com.ruanyun.australianews.ui.my.MyEvaluationListActivity;
import com.ruanyun.australianews.ui.my.MyMessageListActivity;
import com.ruanyun.australianews.ui.my.MyMessageNotificationDetailsActivity;
import com.ruanyun.australianews.ui.my.MyPushRecordNewListActivity;
import com.ruanyun.australianews.ui.my.MyReleaseActivity;
import com.ruanyun.australianews.ui.my.MyReleaseLifeListFragment;
import com.ruanyun.australianews.ui.my.MySubscibeActivity;
import com.ruanyun.australianews.ui.my.PersonalInformationActivity;
import com.ruanyun.australianews.ui.my.SetLanguageActivity;
import com.ruanyun.australianews.ui.my.SpecialColumnFragment;
import com.ruanyun.australianews.ui.my.UpdateBindMailboxActivity;
import com.ruanyun.australianews.ui.my.UpdateBindPhoneActivity;
import com.ruanyun.australianews.ui.my.UserHomePageActivity;
import com.ruanyun.australianews.ui.news.ChannelManagerActivity;
import com.ruanyun.australianews.ui.news.NewsCommentActivity;
import com.ruanyun.australianews.ui.news.NewsDetailsActivity;
import com.ruanyun.australianews.ui.news.NewsDetailsActivityTo;
import com.ruanyun.australianews.ui.news.SecondaryCommentActivity;
import com.ruanyun.australianews.ui.news.VideoNewsDetailsActivity;
import com.ruanyun.australianews.ui.vip.AddVipActivity;
import com.ruanyun.australianews.ui.vip.FinishActivity;
import com.ruanyun.australianews.ui.vip.FrequencyPlayActivity;
import com.ruanyun.australianews.ui.vip.MoerPayFragment;
import com.ruanyun.australianews.ui.vip.MoreActivity;
import com.ruanyun.australianews.ui.vip.MoreCourseFragment;
import com.ruanyun.australianews.ui.vip.MoreSpecialColumnFragment;
import com.ruanyun.australianews.ui.vip.PDFActivity;
import com.ruanyun.australianews.ui.vip.SelectPayActivity;
import com.ruanyun.australianews.ui.vip.SpecialColumnActivity;
import com.ruanyun.australianews.ui.vip.VideoActivity;
import com.ruanyun.australianews.ui.vip.VipDetailsActivity;
import com.ruanyun.australianews.ui.vip.VipListActivity;
import com.ruanyun.australianews.ui.vip.VipNewsDetailsActivity;
import com.ruanyun.australianews.ui.wealth.CivilEstateListActivity;
import com.ruanyun.australianews.ui.wealth.CivilEstateListActivityTo;
import com.ruanyun.australianews.ui.wealth.CivilEstateListFragment;
import com.ruanyun.australianews.ui.wealth.HousingMarketListActivity;
import com.ruanyun.australianews.ui.wealth.HousingMarketListFragment;
import com.ruanyun.australianews.ui.wealth.ReleaseCivilEstateActivity;
import com.ruanyun.australianews.ui.wealth.ReleaseHousingMarketActivity;
import com.ruanyun.australianews.ui.wealth.WealthActivity;
import com.ruanyun.australianews.ui.wealth.WealthFundListActivity;
import com.ruanyun.australianews.ui.wealth.WealthFundListFragment;
import com.ruanyun.australianews.ui.wealth.WealthMyActivity;
import com.ruanyun.australianews.ui.wealth.WealthMyBrowseListActivity;
import com.ruanyun.australianews.ui.wealth.WealthMyBrowseListFragment;
import com.ruanyun.australianews.ui.wealth.WealthMyCollectListActivity;
import com.ruanyun.australianews.ui.wealth.WealthMyCollectListFragment;
import com.ruanyun.australianews.ui.wealth.WealthMyFragment;
import com.ruanyun.australianews.ui.wealth.WealthMyReleaseListActivity;
import com.ruanyun.australianews.ui.wealth.WealthMyReleaseListFragment;
import com.ruanyun.australianews.ui.wealth.YongHuXieYiActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * We want Dagger.Android to create a Subcomponent which has a parent Component of whichever module
 * ActivityBindingModule is on, in our case that will be AppComponent. The beautiful part about this
 * setup is that you never need to tell AppComponent that it is going to have all these
 * subcomponents nor do you need to tell these subcomponents that AppComponent exists. We are also
 * telling Dagger.Android that this generated SubComponent needs to include the specified modules
 * and be aware of a scope annotation @ActivityScoped When Dagger.Android annotation processor runs
 * it will create 4 subcomponents for us.
 */
@Module
public abstract class ActivityBindingModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract MyFragment myFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract NewsFragment newsFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract NewsListChildFragment newsListChildFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract WebviewFragment webviewFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract VipFragment vipFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract LifeMyFragment lifeMyFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract YellowPageFragment lifYellowPageFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract LifeHomeFragment lifeHomeFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract SearchNewsListFragment newsSearchListFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract SearchLifeListFragment lifeSearchListFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract MyCollectionNewsListFragment myCollectionNewsListFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract MyCollectionLifeListFragment myCollectionLifeListFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract MyBrowseRecordNewListFragment myBrowseRecordListFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract MyBrowseRecordLifeListFragment myBrowseRecordLifeListFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract MyReleaseLifeListFragment myReleaseLifeListFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract CurriculumFragment curriculumFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract SpecialColumnFragment specialColumnFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract MemberFragment memberFragment();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract SelectReleaseLifeTypeActivity selectReleaseLifeTypeActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract SplashActivity splashActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract GuideActivity guideActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract WebViewActivity webViewActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract MainActivity mainActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract LifeMainActivity lifeMainActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract LoginActivity loginActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract RegisteredActivity registeredActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract CountryAreaCodeSelectActivity countryAreaCodeSelectActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract ForgetPasswordActivity forgetPasswordActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract ModifyPasswordActivity modifyPasswordActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract CityListActivity cityListActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract MessageListActivity messageListActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract P2pChatActivity p2pChatActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract ChannelManagerActivity channelManagerActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract SearchActivity searchActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract FeedbackActivity feedbackActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract PersonalInformationActivity personalInformationActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract YellowPageListActivity yellowPageListActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract SelectReleaseTypeActivity selectReleaseTypeActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract MyMessageListActivity myMessageListActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract SetLanguageActivity setLanguageActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract MyMessageNotificationDetailsActivity myMessageNotificationDetailsActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract VideoNewsDetailsActivity videoNewsDetailsActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract MyEvaluationListActivity myEvaluationListActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract MyCollectionActivity myCollectionActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract MyBrowseRecordActivity myBrowseRecordActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract MapPointActivity mapPointActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract ReleaseYellowPageActivity releaseYellowPageActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract HouseRentListActivity houseRentListActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract HouseDemandListActivity houseDemandListActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract BusinessTransferListActivity businessTransferListActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract RecruitmentListActivity recruitmentListActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract CarSaleListActivity carSaleListActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract PetTransactionListActivity petTransactionListActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract TransactionMarketListActivity transactionMarketListActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract TextbookListActivity textbookListActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract MultipleSelectionActivity multipleSelectionActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract ReleaseBusinessTransferActivity releaseBusinessTransferActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract ReleaseCarSaleActivity releaseCarSaleActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract ReleaseHouseDemandActivity releaseHouseDemandActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract ReleaseHouseRentActivity releaseHouseRentActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract ReleasePetTransactionActivity releasePetTransactionActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract ReleaseRecruitmentActivity releaseRecruitmentActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract ReleaseTransactionMarketActivity releaseTransactionMarketActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract ReleaseTextbookActivity releaseTextbookActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract ReleasePetTransactionSelectTypeActivity releasePetTransactionSelectTypeActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract MyReleaseActivity myReleaseActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract MyPushRecordNewListActivity myPushRecordNewListActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract ShopListActivity shopListActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract ReleaseShopActivity releaseShopActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract ReleaseShopGoodsActivity releaseShopGoodsActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract AboutUsListActivity aboutUsListActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract UpdateBindPhoneActivity updateBindPhoneActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract UpdateBindMailboxActivity updateBindMailboxActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract NewsDetailsActivity newsDetailsActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract NewsDetailsActivityTo newsDetailsActivityTo();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract VipListActivity vipListActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract VipDetailsActivity vipDetailsActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract SelectPayActivity selectPayActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract VideoActivity videoActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract PDFActivity pdfActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract FinishActivity finishActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract AddVipActivity addVipActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract FrequencyPlayActivity frequencyPlayActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract NewsCommentActivity newsCommentActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract SecondaryCommentActivity secondaryCommentActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract UserHomePageActivity userHomePageActivity();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract HomePageReleaseLifeListFragment homePageReleaseLifeListFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract HomePageEvaluationListFragment homePageEvaluationListFragment();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract WealthActivity wealthActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract WealthMyActivity wealthMyActivity();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract WealthMyFragment wealthMyFragment();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract WealthFundListActivity wealthFundListActivity();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract WealthFundListFragment wealthFundListFragment();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract WealthMyBrowseListActivity wealthMyBrowseListActivity();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract WealthMyBrowseListFragment wealthMyBrowseListFragment();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract ActivitysListActivity activitysListActivity();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract ActivitysListFragment activitysListFragment();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract ReleaseActivitysActivity releaseActivitysActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract HousingMarketListActivity housingMarketListActivity();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract HousingMarketListFragment housingMarketListFragment();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract ReleaseHousingMarketActivity releaseHousingMarketActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract CivilEstateListActivity civilEstateListActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract CivilEstateListActivityTo civilEstateListActivityTo();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract TextActivi textActivi();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract CivilEstateListFragment civilEstateListFragment();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract ReleaseCivilEstateActivity releaseCivilEstateActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract WealthMyCollectListActivity wealthMyCollectListActivity();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract WealthMyCollectListFragment wealthMyCollecListFragment();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract WealthMyReleaseListActivity wealthMyReleaseListActivity();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract WealthMyReleaseListFragment wealthMyReleaseListFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract HomePageReleaseWealthListFragment homePageReleaseWealthListFragment();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract RegisteredBindActivity RegisteredBindActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract YongHuXieYiActivity yongHuXieYiActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract MySubscibeActivity mySubscibeActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract SpecialColumnActivity specialColumnActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract MoreActivity moreActivity();


    @FragmentScoped
    @ContributesAndroidInjector
    abstract MoerPayFragment moerPayFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract MoreSpecialColumnFragment moreSpecialColumnFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract MoreCourseFragment moreCourseFragment();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract VipNewsDetailsActivity vipNewsDetailsActivity();




}
