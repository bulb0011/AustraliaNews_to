package com.ruanyun.australianews.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import com.ruanyun.australianews.R;

public class TextUtil {

    public static SpannableString  TextImage(Context context, String string){

//        ImageSpan isp =new  ImageSpan(BitmapFactory.decodeResource( context.getResources(), R.drawable.yaoshi));
//        int strLength = string.length();
//        SpannableString ss = new SpannableString(string);
//        ss .setSpan(isp,strLength-1, strLength, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
//        sss.subSequence(0,len).toString();

        //注意此处showText后+ " "主要是为了占位
        SpannableString sss = new SpannableString(string + " ");
        int len = sss.length();
        //图片
        Drawable d = ContextCompat.getDrawable(context, (R.drawable.yaoshi));
        d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
        //构建ImageSpan
        ImageSpan span = new ImageSpan(d, ImageSpan.ALIGN_BASELINE);
        sss.setSpan(span, len - 1, len, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

        return sss;
    }
}
