package com.example.wk.frameworkk.app

import android.app.Activity
import android.app.Application
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


    override fun onCreate() {
        super.onCreate()


        initRetrofit()

    }

    /**
     * 初始化retrofit
     */
    private fun initRetrofit() {
        HttpManager.init()
    }


}