package com.example.wk.frameworkk.http

import com.example.wk.frameworkk.constant.AppConstant
import com.safframework.http.interceptor.LoggingInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * <p>单列
 * Author : WangKang <p>
 * Created: 2018/6/22 <P>
 * Description: 网络请求
 * <p>
 * E-mail:wangkang@huolicai.com
 */
object HttpManager {

    private fun init(baseUrl: String): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getOkHttp())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    private fun getOkHttp(): OkHttpClient {
        val loggingInterceptor = LoggingInterceptor.Builder()
                .loggable(true) // TODO: 发布到生产环境需要改成false
                .request()
                .requestTag("KtRequest")
                .response()
                .responseTag("KtResponse")
                //.hideVerticalLine()// 隐藏竖线边框
                .build()
        return OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(AppInterceptor())
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build()
    }

    fun androidApi(): WanAndroidService = init(AppConstant.URL.WANANDROID.url).create(WanAndroidService::class.java)


    fun tianYanApi(): TianYanService = init(AppConstant.URL.TIANYAN.url).create(TianYanService::class.java)


}