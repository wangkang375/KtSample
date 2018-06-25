package com.example.wk.frameworkk.ui.mine

import android.os.Bundle
import android.view.View
import com.example.wk.frameworkk.R
import com.example.wk.frameworkk.base.BaseFragment
import com.example.wk.frameworkk.ui.home.HomeFragment

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/22 <P>
 * Description:
 * <p>
 * E-mail:wangkang@huolicai.com
 */
class MineFragment : BaseFragment() {
    override fun initData() {


    }

    var title: String? = null

    companion object {
        fun getInstance(title: String): MineFragment {
            val mineFragment = MineFragment()
            val bundle = Bundle()
            mineFragment.arguments = bundle
            mineFragment.title = title
            return mineFragment
        }
    }


    override fun initView(inflate: View?) {

    }

    override fun fragmentLayout(): Int {
        return R.layout.fragment_mine
    }
}