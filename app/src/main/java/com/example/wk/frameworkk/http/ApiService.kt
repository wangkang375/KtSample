package com.example.wk.frameworkk.http

import com.example.wk.frameworkk.Request
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/22 <P>
 * Description:
 * <p>
 * E-mail:wangkang@huolicai.com
 */
interface ApiService {
    @GET("/api/hp/idlist/0?")
    fun getServerInfo(): Observable<Request>

}