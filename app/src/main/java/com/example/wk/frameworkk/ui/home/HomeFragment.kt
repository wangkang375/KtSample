package com.example.wk.frameworkk.ui.home

import android.os.Bundle
import android.view.View
import com.example.wk.frameworkk.R
import com.example.wk.frameworkk.Request
import com.example.wk.frameworkk.base.BaseFragment
import com.example.wk.frameworkk.http.HttpManager
import com.example.wk.frameworkk.utils.SPProxy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/22 <P>
 * Description:
 * <p>
 * E-mail:wangkang@huolicai.com
 */
class HomeFragment : BaseFragment() {

    var title: String? = null
    private var token: String by SPProxy("token", "")

    companion object {
        fun getInstance(title: String): HomeFragment {
            val homeFragment = HomeFragment()
            val bundle = Bundle()
            homeFragment.arguments = bundle
            homeFragment.title = title
            return homeFragment
        }
    }

    override fun initView(inflate: View?) {
        val findViewById = inflate!!.findViewById<View>(R.id.tv_request)
        findViewById.setOnClickListener {
            request()
        }
    }

    private fun request() {
        val serverInfo = HttpManager.api()?.getServerInfo()
        if (serverInfo != null) {
            serverInfo.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe { t: Request? -> toast(t) }
        }
    }

    private fun toast(t: Request?) {
        println(t.toString())
        token="1000000"
        print("================$token")
    }

    override fun fragmentLayout(): Int {
        return R.layout.fragment_home
    }
}