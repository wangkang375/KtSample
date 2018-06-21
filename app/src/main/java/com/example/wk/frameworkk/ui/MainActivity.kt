package com.example.wk.frameworkk.ui

import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.wk.frameworkk.R
import com.example.wk.frameworkk.TestAdapter
import com.example.wk.frameworkk.base.BaseActivity


class MainActivity : BaseActivity() {
    private lateinit var testAdapter: TestAdapter
    private lateinit var list:ArrayList<String>
    companion object {
        val handler: Handler = Handler()
    }

    override fun initView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recycle_view1)
        recyclerView.layoutManager = LinearLayoutManager(this)
        testAdapter = TestAdapter()
        recyclerView.adapter = testAdapter
        handler.postDelayed({
            runOnUiThread {
                list=ArrayList()
                testAdapter.loadData(list)
            }
        }, 2000)
    }

    override fun layout(): Int {
        return R.layout.activity_main2
    }


}
