package com.example.wk.frameworkk.adapter.vh

import android.content.Context
import android.graphics.Typeface
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.wk.frameworkk.R
import com.example.wk.frameworkk.bean.TYHomeItem

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/7/2 <P>
 * Description:
 * <p>
 * E-mail:wangkang@huolicai.com
 */
class TyTimeVH(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    private var tvTime: TextView? = null

    init {
        tvTime = itemView?.findViewById(R.id.tv_time)
    }

    fun bindData(item: TYHomeItem, context: Context, typeface: Typeface?) {
        tvTime?.typeface = typeface
        tvTime?.text = item.item?.data?.text ?: "无数据"
    }
}