package com.example.wk.frameworkk.ui.collect

import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.wk.frameworkk.R
import com.example.wk.frameworkk.adapter.TyHomeAdapter
import com.example.wk.frameworkk.base.BaseFragment
import com.example.wk.frameworkk.bean.Issue
import com.example.wk.frameworkk.bean.Item
import com.example.wk.frameworkk.bean.TYHomeItem
import com.example.wk.frameworkk.bean.TYhomeBean
import com.example.wk.frameworkk.http.HttpManager
import com.example.wk.frameworkk.http.ThreadTransformer
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import io.reactivex.functions.Consumer

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/22 <P>
 * Description:
 * <p>
 * E-mail:wangkang@huolicai.com
 */
class TYFragment : BaseFragment() {

    private var homeBeans: ArrayList<TYHomeItem> = ArrayList()
    private var banners: ArrayList<Item> = ArrayList()
    var title: String? = null
    val mAdapter: TyHomeAdapter by lazy {
        TyHomeAdapter(homeBeans)
    }

    companion object {
        fun getInstance(title: String): TYFragment {
            val collectFragment = TYFragment()
            val bundle = Bundle()
            collectFragment.arguments = bundle
            collectFragment.title = title
            return collectFragment
        }
    }

    override fun initView(inflate: View?) {
        val recyclerView = inflate?.findViewById<RecyclerView>(R.id.recycle_view_ty)
        val smartRefreshLayout = inflate?.findViewById<SmartRefreshLayout>(R.id.smartRefresh)
        smartRefreshLayout?.setPrimaryColorsId(R.color.colorPrimary)
        recyclerView?.layoutManager = LinearLayoutManager(activity)
        recyclerView?.adapter = mAdapter
    }

    override fun fragmentLayout(): Int {
        return R.layout.fragment_collect
    }

    override fun initData() {

        HttpManager.tianYanApi().getTYHome(1)
                .flatMap { t: TYhomeBean ->
                    val itemList: ArrayList<Item> = t.issueList[0].itemList
                    for (item in itemList) {
                        if (item.type != "banner2") {
                            banners.add(item)
                        }
                    }
                    homeBeans.add(TYHomeItem(banners, null))
                    HttpManager.tianYanApi().getMoreHomeData(t.nextPageUrl)
                }
                .compose(ThreadTransformer<TYhomeBean>())
                .subscribe(consumer(), Consumer<Throwable> {
                    println(it.message)
                })

    }

    private fun consumer(): Consumer<TYhomeBean> {
        return Consumer { t ->
            t.issueList[0].itemList.filter { item -> item.type != "banner2" }
                    .forEach { homeBeans.add(TYHomeItem(null, it)) }
            setData(homeBeans)
        }
    }

    private fun setData(homeBeans: ArrayList<TYHomeItem>) {
        mAdapter.notifyDataSetChanged()
    }

    private fun doit(issue: Issue) {


    }
}