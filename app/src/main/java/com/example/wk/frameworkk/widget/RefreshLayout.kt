package com.example.wk.frameworkk.widget

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.wk.frameworkk.R
import com.scwang.smartrefresh.layout.SmartRefreshLayout

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/20 <P>
 * Description: 下拉刷新控件
 * <p>
 * E-mail:wangkang@huolicai.com
 */
class RefreshLayout(context: Context?, attrs: AttributeSet?) : FrameLayout(context, attrs) {
    private var mInflater: LayoutInflater? = LayoutInflater.from(context)

    init {
        mInflater!!.inflate(R.layout.layout_refresh, this)
        val recyclerView = findViewById<RecyclerView>(R.id.recycle_view)
        val refreshLayout = findViewById<SmartRefreshLayout>(R.id.smartRefresh)

    }
}