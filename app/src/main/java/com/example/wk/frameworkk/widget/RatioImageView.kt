package com.example.wk.frameworkk.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/25 <P>
 * Description:
 * <p> 一定比例的ImageView
 * E-mail:wangkang@huolicai.com
 */
class RatioImageView(context: Context?, attrs: AttributeSet?) : ImageView(context, attrs) {

    init {

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val measuredHeight = measuredWidth / 2
        setMeasuredDimension(measuredWidth, measuredHeight)
    }

}