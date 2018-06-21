package com.example.wk.frameworkk.adapter.vh

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.wk.frameworkk.R


/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/20 <P>
 * Description:
 * <p>
 * E-mail:wangkang@huolicai.com
 */
class DefultVH(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    public var textView: TextView = itemView?.findViewById<TextView>(R.id.tv)!!
}