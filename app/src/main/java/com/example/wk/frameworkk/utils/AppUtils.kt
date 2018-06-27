package com.example.wk.frameworkk.utils

import android.content.Context
import android.content.pm.PackageManager

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/26 <P>
 * Description: 获取APP 信息
 * <p>
 * E-mail:wangkang@huolicai.com
 */
class AppUtils {

    companion object {
        fun getAppInfo(context: Context): Int {
            return context.packageManager.getPackageInfo(context.packageName, PackageManager.GET_CONFIGURATIONS)
                    .versionCode
        }
    }


}