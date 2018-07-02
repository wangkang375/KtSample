package com.example.wk.frameworkk.adapter

import android.graphics.Typeface
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.wk.frameworkk.R
import com.example.wk.frameworkk.adapter.vh.TyHeadVH
import com.example.wk.frameworkk.adapter.vh.TyTimeVH
import com.example.wk.frameworkk.adapter.vh.TyUseVH
import com.example.wk.frameworkk.app.App.Companion.context
import com.example.wk.frameworkk.bean.TYHomeItem

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/7/2 <P>
 * Description: 视频adapter
 * <p>
 * E-mail:wangkang@huolicai.com
 */
class TyHomeAdapter(private var mData: ArrayList<TYHomeItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var typeface: Typeface? = null

    init {
        typeface = Typeface.createFromAsset(context.assets, "fonts/Lobster-1.4.otf")
    }

    companion object {
        const val HEAD_ITEM: Int = 1000
        const val USE_ITEM: Int = 2000
        const val TIME_ITEM: Int = 3000
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        with(LayoutInflater.from(context)) {
            return when (viewType) {
                HEAD_ITEM -> {
                    TyHeadVH(inflate(R.layout.item_ty_head, parent, false))
                }
                TIME_ITEM -> {
                    TyTimeVH(inflate(R.layout.item_ty_date, parent, false))
                }
                else -> {
                    TyUseVH(inflate(R.layout.item_ty_use, parent, false))
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        with(getItemViewType(position)) {
            when (this) {
                USE_ITEM -> {
                    val tyUseVH = holder as TyUseVH
                    tyUseVH.bindData(mData[position], context)
                }
                HEAD_ITEM -> {
                    val tyHeadVH = holder as TyHeadVH
                    tyHeadVH.bindData(mData[position], context)
                }
                else -> {
                    val tyTimeVH = holder as TyTimeVH
                    tyTimeVH.bindData(mData[position], context,typeface)
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            position == 0 -> HEAD_ITEM
            mData[position].item?.type == "textHeader" -> TIME_ITEM
            else -> USE_ITEM
        }
    }

    fun addData(homeBeans: ArrayList<TYHomeItem>) {
        mData.clear()
        mData.addAll(homeBeans)
        notifyDataSetChanged()
    }
}