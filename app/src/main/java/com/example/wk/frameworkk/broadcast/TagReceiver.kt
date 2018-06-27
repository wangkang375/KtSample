package com.example.wk.frameworkk.broadcast

import android.content.Context
import cn.jpush.android.api.JPushMessage
import cn.jpush.android.service.JPushMessageReceiver

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/27 <P>
 * Description: 指定用户
 * <p>
 * E-mail:wangkang@huolicai.com
 */
class TagReceiver : JPushMessageReceiver() {

    override fun onTagOperatorResult(var1: Context?, p1: JPushMessage?) {

    }

    override fun onCheckTagOperatorResult(p0: Context?, p1: JPushMessage?) {
        super.onCheckTagOperatorResult(p0, p1)
    }

    override fun onAliasOperatorResult(p0: Context?, p1: JPushMessage?) {
        super.onAliasOperatorResult(p0, p1)
    }

    override fun onMobileNumberOperatorResult(p0: Context?, p1: JPushMessage?) {
        super.onMobileNumberOperatorResult(p0, p1)
    }
}