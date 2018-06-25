package com.example.wk.frameworkk.ui.find

import android.os.Bundle
import android.view.View
import com.example.wk.frameworkk.R
import com.example.wk.frameworkk.base.BaseFragment

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/22 <P>
 * Description: 发现
 * <p>
 * E-mail:wangkang@huolicai.com
 */
class FindFragment : BaseFragment() {
    override fun initData() {


    }

    var title: String? = null
    companion object {
        fun getInstance(title: String): FindFragment {
            val findFragment = FindFragment()
            val bundle = Bundle()
            findFragment.arguments = bundle
            findFragment.title = title
            return findFragment
        }
    }

    override fun initView(inflate: View?) {

    }

    override fun fragmentLayout(): Int {
        return R.layout.fragment_find
    }
}