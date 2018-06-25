package com.example.wk.frameworkk.ui.collect

import android.os.Bundle
import android.view.View
import com.example.wk.frameworkk.R
import com.example.wk.frameworkk.base.BaseFragment

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/22 <P>
 * Description:
 * <p>
 * E-mail:wangkang@huolicai.com
 */
class CollectFragment : BaseFragment() {
    override fun initData() {


    }

    var title: String? = null

    companion object {
        fun getInstance(title: String): CollectFragment {
            val collectFragment = CollectFragment()
            val bundle = Bundle()
            collectFragment.arguments = bundle
            collectFragment.title = title
            return collectFragment
        }
    }


    override fun initView(inflate: View?) {

    }

    override fun fragmentLayout(): Int {
        return R.layout.fragment_collect
    }
}