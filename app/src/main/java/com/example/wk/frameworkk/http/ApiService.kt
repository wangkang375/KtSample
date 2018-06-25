package com.example.wk.frameworkk.http

import com.example.wk.frameworkk.bean.BannerRe
import com.example.wk.frameworkk.bean.HomeResponse
import com.example.wk.frameworkk.bean.Response
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/22 <P>
 * Description: 接口服务
 * <p>
 * E-mail:wangkang@huolicai.com
 */
interface ApiService {
    /**
     * 获得首页数据
     */
    @GET("/article/list/{page}/json")
    fun getHomeInfo(@Path("page") page: Int): Observable<Response<HomeResponse>>


    /**
     * 获得首页Banner
     */
    @GET("/banner/json")
    fun getHomeBanner(): Observable<Response<ArrayList<BannerRe>>>
}