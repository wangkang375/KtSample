package com.example.wk.frameworkk.http

import okhttp3.Interceptor
import okhttp3.Response

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/22 <P>
 * Description: 自定义拦截器
 * <p>
 * E-mail:wangkang@huolicai.com
 */
class AppInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response? {
        val request = chain?.request()
        val proceed = chain?.proceed(request)
        return proceed
    }
}