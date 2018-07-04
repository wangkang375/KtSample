package com.example.wk.frameworkk.constant

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/22 <P>
 * Description: 常量管理
 * <p>
 * E-mail:wangkang@huolicai.com
 */
class AppConstant {

    companion object {
        var SP_NAME = "ktsample"
        val WEB_URL = "WEB_URL"
        val TITLE = "TITLE"
    }

    enum class URL(val url: String) {
        //wanandroid
        WANANDROID("http://www.wanandroid.com"),
        //天眼
        TIANYAN("http://baobab.kaiyanapp.com/api/")
    }
}