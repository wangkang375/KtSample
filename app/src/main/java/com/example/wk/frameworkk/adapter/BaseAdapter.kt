package com.example.wk.frameworkk.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wk.frameworkk.R
import com.example.wk.frameworkk.adapter.BaseAdapter.Companion.DEFAULT_ITEM
import com.example.wk.frameworkk.adapter.BaseAdapter.Companion.EMP_ITEM
import com.example.wk.frameworkk.adapter.BaseAdapter.Companion.EXC_ITEM
import com.example.wk.frameworkk.adapter.BaseAdapter.Companion.USE_ITEM

import com.example.wk.frameworkk.adapter.vh.DefultVH
import com.example.wk.frameworkk.imp.OnclickItem
import java.util.*

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/20 <P>
 * Description: baseAdapter
 * <p>
 * E-mail:wangkang@huolicai.com
 */
@Suppress("UNCHECKED_CAST")
abstract class BaseAdapter<T, UVH : RecyclerView.ViewHolder> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    public var data: ArrayList<T> = ArrayList()
    private var status: Status = Status.DEFAULT
    private var onclickItem: OnclickItem<T, UVH>? = null

    companion object {
        const val USE_ITEM = 1000//用户条目
        const val EXC_ITEM = 2000//出错
        const val EMP_ITEM = 3000//空条目
        const val DEFAULT_ITEM = 4000//默认
    }

    enum class Status {
        DEFAULT, REFRESH, LOAD, ERROR
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            DEFAULT_ITEM -> DefultVH(inflater.inflate(defaultLayout(), parent, false))
            EXC_ITEM -> DefultVH(inflater.inflate(defaultLayout(), parent, false))
            EMP_ITEM -> DefultVH(inflater.inflate(defaultLayout(), parent, false))
            else -> this.useVH(inflater.inflate(this.useLayout(), parent, false))
        }
    }

    /**
     * 用户VH
     */
    abstract fun useVH(inflate: View): UVH


    /**
     * 用户数据条目
     */
    abstract fun useLayout(): Int

    /**
     * 默认布局
     */
    private fun defaultLayout(): Int {
        return R.layout.layout_defult
    }

    override fun getItemCount(): Int {
        return if (data.size == 0) 1 else data.size

    }

    /**
     * 加载数据
     */
    fun loadData(x: ArrayList<T>) {
        if (status == Status.REFRESH || status == Status.DEFAULT) {
            setStatus(Status.LOAD)
            data.clear()
            data.addAll(x)
            notifyDataSetChanged()
        } else if (status == Status.LOAD) {
            data.addAll(x)
            notifyItemRangeInserted(data.size, x.size)
        }
    }

    private fun setStatus(refresh: Status) {
        status = refresh
    }

    private fun loadError() {
        setStatus(Status.ERROR)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            DEFAULT_ITEM -> {
                val defultVH = holder as DefultVH
                defultVH.textView.text = "默认页面"
            }
            EMP_ITEM -> {
                val defultVH = holder as DefultVH
                defultVH.textView.text = "暂无数据-"
            }
            EXC_ITEM -> {
                val defaultVH = holder as DefultVH
                defaultVH.textView.text = "错误页面"
            }
            else -> {
                val uvh = holder as UVH
                bindUseVH(uvh, data[position], position)
                uvh.itemView.setOnClickListener {
                    onclickItem?.clickItemListener(data[position], position, uvh)
                }
            }
        }
    }

    open fun setOnclickItemLis(x: OnclickItem<T, UVH>) {
        onclickItem = x
    }

    /**
     * 绑定用户数据
     */
    abstract fun bindUseVH(uvh: RecyclerView.ViewHolder, any: T, position: Int)

    override fun getItemViewType(position: Int): Int {
        return when (status) {
            Status.DEFAULT -> {
                DEFAULT_ITEM
            }
            Status.ERROR -> {
                EXC_ITEM
            }
            else -> {
                if (data.size == 0) {
                    EMP_ITEM
                } else {
                    USE_ITEM
                }
            }
        }
    }
}