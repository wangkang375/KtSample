package com.example.wk.frameworkk.app

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import com.example.wk.frameworkk.http.HttpManager
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
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
//        initRetrofit()
    }

    /**
     * 初始化retrofit
     */
    private fun initRetrofit() {
        HttpManager.init()
    }


}