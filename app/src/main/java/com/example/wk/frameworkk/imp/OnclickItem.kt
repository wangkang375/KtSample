package com.example.wk.frameworkk.imp

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/20 <P>
 * Description: 点击条目
 * <p>
 * E-mail:wangkang@huolicai.com
 */
interface OnclickItem<T,UVH> {

    fun clickItemListener(data: T, position: Int,vh: UVH)

}