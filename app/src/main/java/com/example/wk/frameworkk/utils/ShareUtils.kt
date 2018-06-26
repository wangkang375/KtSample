package com.example.wk.frameworkk.utils

import cn.sharesdk.framework.Platform
import cn.sharesdk.framework.PlatformActionListener
import cn.sharesdk.framework.ShareSDK
import cn.sharesdk.tencent.qq.QQ
import cn.sharesdk.wechat.friends.Wechat

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/26 <P>
 * Description: 分享工具
 * <p>
 * E-mail:wangkang@huolicai.com
 */
class ShareUtils(name: String) {
    private val shareParams: Platform.ShareParams by lazy { Platform.ShareParams() }
    var platform: Platform = ShareSDK.getPlatform(name)
    fun build(actionListener: PlatformActionListener): ShareUtils {
        platform.platformActionListener = actionListener
        return this
    }

    fun title(title: String): ShareUtils {
        shareParams.title = title
        return this
    }


    fun text(text: String): ShareUtils {
        shareParams.text = text
        return this
    }

    fun share(): Unit {
        platform.share(shareParams)
    }
}