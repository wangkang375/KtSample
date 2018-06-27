package com.example.wk.frameworkk.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import cn.jpush.android.api.JPushInterface
import com.example.wk.frameworkk.ui.MainActivity
import java.util.logging.Logger

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/27 <P>
 * Description: 极光推送
 * <p>
 * E-mail:wangkang@huolicai.com
 */
class MyReceiver : BroadcastReceiver() {
    private val TAG: String = "MyReceiver"

    override fun onReceive(context: Context?, intent: Intent?) = try {
        val bundle = intent!!.extras
//            println(TAG+)
        if (JPushInterface.ACTION_REGISTRATION_ID == intent!!.action) {

        } else if (JPushInterface.ACTION_MESSAGE_RECEIVED == intent!!.action) {
            val string = bundle!!.getString(JPushInterface.EXTRA_MESSAGE)!!
            println("$TAG[MyReceiver] 接收到推送下来的自定义消息:$string")

        } else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED == intent!!.action) {
            println("$TAG[MyReceiver] 接收到推送下来的通知:")

        } else if (JPushInterface.ACTION_NOTIFICATION_OPENED == intent.getAction()) {
            println("$TAG[MyReceiver] 用户点击打开了通知:")
            //打开自定义的Activity
            val i = Intent(context, MainActivity::class.java)
            i.putExtras(bundle!!)

            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            context!!.startActivity(i)

        } else if (JPushInterface.ACTION_RICHPUSH_CALLBACK == intent.action) {
            val string = bundle!!.getString(JPushInterface.EXTRA_EXTRA)
            println("$TAG[MyReceiver] 用户收到到RICH PUSH CALLBACK:$string")
            //在这里根据 JPushInterface.EXTRA_EXTRA 的内容处理代码，比如打开新的Activity， 打开一个网页等..

        } else if (JPushInterface.ACTION_CONNECTION_CHANGE == intent.action) {
            val connected = intent.getBooleanExtra(JPushInterface.EXTRA_CONNECTION_CHANGE, false)
        } else {
        }
    } catch (e: Exception) {

    }
}