package com.example.wk.frameworkk.bean

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/26 <P>
 * Description: denglu
 * <p>
 * E-mail:wangkang@huolicai.com
 */
data class LoginResponse(
        var id: Int,
        var username: String,
        var password: String,
        var icon: String?,
        var type: Int,
        var collectIds: List<Int>?
)