package com.example.wk.frameworkk.bean

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/23 <P>
 * Description: 响应
 * <p>
 * E-mail:wangkang@huolicai.com
 */

data class Response<T>(
        val data: T,
        val errorCode: Int,
        val errorMsg: String
)