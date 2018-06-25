package com.example.wk.frameworkk.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.wk.frameworkk.R
import com.example.wk.frameworkk.adapter.vh.HomeVH
import com.example.wk.frameworkk.bean.HomeItem
import com.example.wk.frameworkk.bean.HomeResponse

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/25 <P>
 * Description:
 * <p>
 * E-mail:wangkang@huolicai.com
 */
class HomeAdapter : BaseAdapter<HomeItem, HomeVH>() {
    override fun bindUseVH(uvh: RecyclerView.ViewHolder, any: HomeItem, position: Int) {
        val homeVH = uvh as HomeVH
        homeVH.tvAuthor?.text = any.author
        homeVH.tvTime?.text = any.niceDate
        homeVH.tvSub?.text = any.chapterName
        homeVH.tvTitle?.text = any.title
    }

    override fun useVH(inflate: View): HomeVH {
        return HomeVH(inflate)
    }

    override fun useLayout(): Int {
        return R.layout.item_home
    }

}