package com.ruanyun.australianews.util;

public class getTime {

//    00:00:00
   public static String stM(int second){
       if (second < 10) {
           return second+"秒";
       }
       if (second < 60) {
           return second+"分";
       }
       if (second < 3600) {
           int minute = second / 60;
           second = second - minute * 60;
           if (minute < 10) {
               if (second < 10) {
                   return minute + "分" + second+"秒";
               }
               return minute + "分" + second+"秒";
           }
           if (second < 10) {
               return minute + "分" + second+"秒";
           }
           return minute + "分" + second+"秒";
       }
       int hour = second / 3600;
       int minute = (second - hour * 3600) / 60;
       second = second - hour * 3600 - minute * 60;
       if (hour < 10) {
           if (minute < 10) {
               if (second < 10) {
                   return  hour + "时" + minute + "分" + second+"秒";
               }
               return hour + "时" + minute + "分" + second+"秒";
           }
           if (second < 10) {
               return  hour +"时"+ minute + "分" + second+"秒";
           }
           return  hour+"时" + minute + "分" + second+"秒";
       }
       if (minute < 10) {
           if (second < 10) {
               return hour + "时" + minute + "分" + second+"秒";
           }
           return hour + "时" + minute + "分" + second+"秒";
       }
       if (second < 10) {
           return hour +"时"+ minute + "分" + second+"秒";
       }
       return hour+"时" + minute + "分" + second+"秒";
   }
}
