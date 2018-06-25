package com.example.wk.frameworkk.adapter.vh

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.wk.frameworkk.R
import com.example.wk.frameworkk.widget.RatioImageView

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/25 <P>
 * Description:
 * <p>
 * E-mail:wangkang@huolicai.com
 */
class BannerVH(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    var imageView: RatioImageView? = null
    init {
        imageView = itemView?.findViewById(R.id.radio_image_view)
    }
}