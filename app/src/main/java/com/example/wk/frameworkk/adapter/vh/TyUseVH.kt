package com.example.wk.frameworkk.adapter.vh

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.wk.frameworkk.R
import com.example.wk.frameworkk.bean.TYHomeItem
import com.example.wk.frameworkk.gilde.GlideApp

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/7/2 <P>
 * Description:
 * <p>
 * E-mail:wangkang@huolicai.com
 */
class TyUseVH(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    private var ivTy: ImageView? = null
    private var ivIcon: ImageView? = null
    private var tvTitle: TextView? = null
    private var tvSub: TextView? = null
    private var tvTags: TextView? = null

    init {
        itemView?.let {
            ivTy = it.findViewById(R.id.iv_ty)
            ivIcon = it.findViewById(R.id.iv_user_icon)
            tvTitle = it.findViewById(R.id.tv_title)
            tvSub = it.findViewById(R.id.tv_sub_title)
            tvTags = it.findViewById(R.id.tv_tag)
        }

    }


    @SuppressLint("SetTextI18n")
    fun bindData(item: TYHomeItem, context: Context) {
        ivTy?.let { GlideApp.with(context).load(item.item?.data?.cover?.feed).centerCrop().into(it) }
        ivIcon?.let { GlideApp.with(context).load(item.item?.data?.author?.icon).circleCrop().into(it) }
        tvTitle?.text = item.item?.data?.title
        tvTags?.text = "#" + item.item?.data?.category
        val tags = StringBuilder()
        item.item?.data?.tags?.filter { !TextUtils.isEmpty(it.name) }?.forEach { tags.append("/").append(it.name) }
        tvSub?.text = "#$tags"
    }
}