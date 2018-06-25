package com.example.wk.frameworkk.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.wk.frameworkk.R
import com.example.wk.frameworkk.adapter.vh.BannerVH
import com.example.wk.frameworkk.bean.BannerRe
import com.example.wk.frameworkk.gilde.GlideRequests
import com.example.wk.frameworkk.imp.OnclickItem

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/25 <P>
 * Description: 轮播图
 * <p>
 * E-mail:wangkang@huolicai.com
 */
class BannerAdapter(banners: ArrayList<BannerRe>, with: GlideRequests, onclickItem: OnclickItem<BannerRe, BannerVH>) : RecyclerView.Adapter<BannerVH>() {
    private val datas: ArrayList<BannerRe> by lazy { banners }
    private val imageRequest: GlideRequests by lazy { with }
    var onclick = onclickItem

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BannerVH {
        val inflate = LayoutInflater.from(parent?.context).inflate(R.layout.item_banner, parent, false)
        return BannerVH(inflate)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: BannerVH?, position: Int) {
        val bannerRe = datas[position]
        holder?.imageView?.let {
            imageRequest.load(bannerRe.imagePath)
                    .centerCrop()
                    .into(it)
        }
        holder?.itemView?.setOnClickListener { onclick.clickItemListener(bannerRe, position, holder) }
    }

    fun addData(data: ArrayList<BannerRe>) {
        datas.clear()
        datas.addAll(data)
        notifyDataSetChanged()
    }

}