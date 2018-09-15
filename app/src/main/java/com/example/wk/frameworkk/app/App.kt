package com.example.wk.frameworkk.app

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import cn.jpush.android.api.JPushInterface
import com.example.wk.frameworkk.http.HttpManager
import com.mob.MobSDK
import com.tencent.bugly.Bugly
import okhttp3.logging.HttpLoggingInterceptor

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/22 <P>
 * Description: MyApp
 * <p>
 * E-mail:wangkang@huolicai.com
 */
class App : Application() {
    val AppID: String = "629aa92ed6"

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()

        context = applicationContext
        initSDK()

    }

    private fun initSDK() {
        Bugly.init(applicationContext, AppID, true)
        MobSDK.init(this)
        JPushInterface.setDebugMode(true)
        JPushInterface.init(this)

    }

}