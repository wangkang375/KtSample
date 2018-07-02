package com.example.wk.frameworkk.http

import com.example.wk.frameworkk.bean.TYhomeBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/29 <P>
 * Description:天眼service
 * <p>
 * E-mail:wangkang@huolicai.com
 */
interface TianYanService {
    @GET("v2/feed?")
    fun getTYHome(@Query("num") num: Int): Observable<TYhomeBean>


    @GET
    fun getMoreHomeData(@Url url: String): Observable<TYhomeBean>
}