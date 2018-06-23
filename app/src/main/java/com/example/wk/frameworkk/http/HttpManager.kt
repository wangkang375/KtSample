package com.example.wk.frameworkk.http

import com.example.wk.frameworkk.constant.AppConstant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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
    private var service: ApiService? = null
    private var retrofit: Retrofit? = null

    fun init() {
        retrofit = Retrofit.Builder()
                .baseUrl(AppConstant.BASE_URL)
                .client(getOkHttp())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    private fun getOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor(HttpLogger()).setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(AppInterceptor())
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build()
    }

    fun api(): ApiService? {
        service = retrofit?.create(ApiService::class.java)
        return service
    }
}