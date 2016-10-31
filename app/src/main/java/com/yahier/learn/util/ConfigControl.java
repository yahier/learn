package com.yahier.learn.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;


/**
 * 控制运行环境的域名
 * Created by lenovo on 2016/5/2.
 */
public class ConfigControl {

    //开发环境
    private static String devhostUploadWeiboImg = "https://dev-img.shifugroup.net/";
    private static String devhostMain = "https://dev-api.shifugroup.net/";
    private static String devhostWap = "https://dev-wap.shifugroup.net/";


    public static String publishChannel = "0000";//发布渠道号 0000官网，0002tencent
    public static boolean logable = true;  //log开关
    public static boolean switchLang = false; //切换app语言，不上英文版就false

    public static String packageName = "com.stbl.stbl";


    public static String getAboutVersionTime(Context mContext) {
        try {
            PackageManager manager = mContext.getPackageManager();
            PackageInfo info = manager.getPackageInfo(mContext.getPackageName(), 0);
            String version = info.versionName;
            return "V " + version;
        } catch(Exception e) {
            e.printStackTrace();
            return "版本未知";
        }
    }


}
