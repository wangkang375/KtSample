package com.example.wk.frameworkk.http

import android.util.Log
import okhttp3.logging.HttpLoggingInterceptor

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/22 <P>
 * Description:
 * <p>
 * E-mail:wangkang@huolicai.com
 */
class HttpLogger : HttpLoggingInterceptor.Logger {
    override fun log(message: String?) {
        Log.d("HttpLogInfo", message)
    }
}