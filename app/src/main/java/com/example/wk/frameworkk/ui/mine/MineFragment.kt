package com.example.wk.frameworkk.ui.mine

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.widget.AppCompatEditText
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.wk.frameworkk.R
import com.example.wk.frameworkk.app.App
import com.example.wk.frameworkk.base.BaseFragment
import com.example.wk.frameworkk.bean.Response
import com.example.wk.frameworkk.bean.User
import com.example.wk.frameworkk.http.HttpManager
import com.example.wk.frameworkk.utils.AppUtils
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
class MineFragment : BaseFragment() {

    var name: AppCompatEditText? = null
    private var password: AppCompatEditText? = null
    private var ll_reg: LinearLayout? = null
    private var username: TextView? = null
    private var usename: String by SPProxy("usename", "")
    override fun initData() {
        if (TextUtils.isEmpty(usename)) {
            ll_reg?.visibility = View.VISIBLE
            username?.visibility = View.GONE
        } else {
            ll_reg?.visibility = View.GONE
            username?.visibility = View.VISIBLE
            username?.text = usename
        }
    }

    var title: String? = null

    companion object {
        fun getInstance(title: String): MineFragment {
            val mineFragment = MineFragment()
            val bundle = Bundle()
            mineFragment.arguments = bundle
            mineFragment.title = title
            return mineFragment
        }
    }


    @SuppressLint("SetTextI18n")
    override fun initView(inflate: View?) {
        name = inflate?.findViewById(R.id.ed_name)
        password = inflate?.findViewById(R.id.ed_password)
        ll_reg = inflate?.findViewById(R.id.ll_reg)
        username = inflate?.findViewById(R.id.use_name)
        val bt = inflate?.findViewById<Button>(R.id.bt)
        inflate?.findViewById<TextView>(R.id.tv_version_code)?.text = "版本号：${AppUtils.getAppInfo(App.context)}"
        bt?.setOnClickListener { registerA() }
        val login = inflate?.findViewById<Button>(R.id.bt_login)
        login?.setOnClickListener { loginA() }
    }

    private fun loginA() {
        HttpManager.androidApi().loginWanAndroid(name?.text.toString(), password?.text.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { t: Response<User>? ->
                    toast(t)
                }

    }

    private fun registerA() {
        HttpManager.androidApi().registerWanAndroid(name?.text.toString(), password?.text.toString(), password?.text.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ t -> toast(t) })

    }

    private fun toast(t: Response<User>?) {
        usename = t?.data?.username!!
        ll_reg?.visibility = View.GONE
        username?.visibility = View.VISIBLE
        username?.text = usename
    }

    override fun fragmentLayout(): Int {
        return R.layout.fragment_mine
    }
}