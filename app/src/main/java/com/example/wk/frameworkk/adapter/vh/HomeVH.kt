package com.example.wk.frameworkk.adapter.vh

import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.wk.frameworkk.R

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/25 <P>
 * Description:
 * <p>
 * E-mail:wangkang@huolicai.com
 */
class HomeVH(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    public val tvAuthor: AppCompatTextView? = itemView?.findViewById(R.id.tv_author)
    public val tvTime: TextView? = itemView?.findViewById(R.id.tv_time)
    public val tvTitle: TextView? = itemView?.findViewById(R.id.tv_title)
    public val tvSub: TextView? = itemView?.findViewById(R.id.tv_sub)
}