package com.example.wk.frameworkk

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/20 <P>
 * Description:
 * <p>
 * E-mail:wangkang@huolicai.com
 */
class TestVH(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    public val textView: TextView = itemView!!.findViewById(R.id.tv_test)
}