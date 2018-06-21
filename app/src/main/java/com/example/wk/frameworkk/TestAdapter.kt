package com.example.wk.frameworkk

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.wk.frameworkk.adapter.BaseAdapter

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/20 <P>
 * Description:
 * <p>
 * E-mail:wangkang@huolicai.com
 */
class TestAdapter : BaseAdapter<String, TestVH>() {
    override fun useVH(inflate: View): TestVH {
        return TestVH(inflate)
    }

    override fun useLayout(): Int {
        return R.layout.item_test
    }

    override fun bindUseVH(uvh: RecyclerView.ViewHolder, any: String, position: Int) {
        val testVH = uvh as TestVH
        testVH.textView.text = "用户数据"
    }
}