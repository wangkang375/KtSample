package com.example.wk.frameworkk.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/22 <P>
 * Description: Fragment基类
 * <p>
 * E-mail:wangkang@huolicai.com
 */
abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflate = inflater.inflate(fragmentLayout(), container, false)
        initView(inflate)
        return inflate
    }

    abstract fun initView(inflate: View?)

    abstract fun fragmentLayout(): Int

}