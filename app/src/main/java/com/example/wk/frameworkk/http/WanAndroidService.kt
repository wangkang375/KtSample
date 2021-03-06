package com.example.wk.frameworkk.http

import com.example.wk.frameworkk.bean.BannerRe
import com.example.wk.frameworkk.bean.HomeResponse
import com.example.wk.frameworkk.bean.User
import com.example.wk.frameworkk.bean.Response
import io.reactivex.Observable
import retrofit2.http.*

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/22 <P>
 * Description:wanAndroid的 接口服务
 * <p>
 * E-mail:wangkang@huolicai.com
 */
interface WanAndroidService {
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


    /**
     * 登陆
     */

    /**
     * 登录
     * @param username username
     * @param password password
     * @return Deferred<User>
     */
    @POST("/user/login")
    @FormUrlEncoded
    fun loginWanAndroid(
            @Field("username") username: String,
            @Field("password") password: String
    ): Observable<Response<User>>

    /**
     * 注册
     */

    @POST("/user/register")
    @FormUrlEncoded
    fun registerWanAndroid(
            @Field("username") username: String,
            @Field("password") password: String,
            @Field("repassword") repassowrd: String
    ): Observable<Response<User>>
}