package com.example.wk.frameworkk.ui.home

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.*
import android.view.View
import com.example.wk.frameworkk.R
import com.example.wk.frameworkk.adapter.BannerAdapter
import com.example.wk.frameworkk.adapter.HomeAdapter
import com.example.wk.frameworkk.adapter.vh.BannerVH
import com.example.wk.frameworkk.adapter.vh.HomeVH
import com.example.wk.frameworkk.base.BaseFragment
import com.example.wk.frameworkk.bean.BannerRe
import com.example.wk.frameworkk.bean.HomeItem
import com.example.wk.frameworkk.bean.HomeResponse
import com.example.wk.frameworkk.bean.Response
import com.example.wk.frameworkk.constant.AppConstant
import com.example.wk.frameworkk.gilde.GlideApp
import com.example.wk.frameworkk.http.HttpManager
import com.example.wk.frameworkk.imp.OnclickItem
import com.example.wk.frameworkk.ui.activity.WebActivity
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
class HomeFragment : BaseFragment(), OnclickItem<BannerRe, BannerVH> {


    var title: String? = null
    private var token: String by SPProxy("token", "")
    private val list: ArrayList<BannerRe> = ArrayList()
    private val bannerAdapter: BannerAdapter by lazy { BannerAdapter(list, GlideApp.with(this), this) }
    private val homeAdapter: HomeAdapter by lazy { HomeAdapter() }

    companion object {
        fun getInstance(title: String): HomeFragment {
            val homeFragment = HomeFragment()
            val bundle = Bundle()
            homeFragment.arguments = bundle
            homeFragment.title = title
            return homeFragment
        }
    }

    override fun initData() {
        getHomeBanner()
        request()
    }

    override fun initView(inflate: View?) {
        val banner = inflate!!.findViewById<RecyclerView>(R.id.recycle_banner)
        banner.layoutManager = LinearLayoutManager(activity, OrientationHelper.HORIZONTAL, false)
        banner.adapter = bannerAdapter
        val pagerSnapHelper = PagerSnapHelper()
        pagerSnapHelper.attachToRecyclerView(banner)
        val content = inflate.findViewById<RecyclerView>(R.id.recycle_content)
        homeAdapter.setOnclickItemLis(object : OnclickItem<HomeItem, HomeVH> {
            override fun clickItemListener(data: HomeItem, position: Int, vh: HomeVH) {
                startWebView(data.link, data.chapterName)
            }

        })
        content.layoutManager = LinearLayoutManager(activity)
        content.adapter = homeAdapter
    }


    override fun clickItemListener(data: BannerRe, position: Int, vh: BannerVH) {
        startWebView(data.url, data.title)

    }

    private fun startWebView(url: String, title: String) {
        Intent(activity, WebActivity::class.java).let {
            it.putExtra(AppConstant.WEB_URL, url)
            it.putExtra(AppConstant.TITLE, title)
            startActivity(it)
        }
    }

    private fun request() {


        val serverInfo = HttpManager.api().getHomeInfo(0)
        serverInfo.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { t: Response<HomeResponse>? -> showHomeAdapter(t?.data?.datas) }

    }

    private fun showHomeAdapter(datas: ArrayList<HomeItem>?) {
        if (datas != null) {
            homeAdapter.loadData(datas)
        }
    }

    private fun getHomeBanner() {
        HttpManager.api().getHomeBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { t: Response<ArrayList<BannerRe>>? -> t?.data?.let { setAdapter(it) } }
    }

    private fun setAdapter(data: ArrayList<BannerRe>) {
        bannerAdapter.addData(data)
    }

    private fun toast(t: Response<HomeResponse>?) {
        println(t.toString())
        token = "1000000"
        print("================$token")
    }

    override fun fragmentLayout(): Int {
        return R.layout.fragment_home
    }
}