package com.example.wk.frameworkk.ui

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import com.example.wk.frameworkk.R
import com.example.wk.frameworkk.TestAdapter
import com.example.wk.frameworkk.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main2.*



class MainActivity : BaseActivity() {
    override fun initInstanceState(savedInstanceState: Bundle?) {

    }

    private lateinit var testAdapter: TestAdapter
    private lateinit var list: ArrayList<String>

    companion object {
        val handler: Handler = Handler()
    }

    override fun initView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recycle_view1)
        setAdapter(recyclerView)
        setupNav()
    }


    override fun layout(): Int {
        return R.layout.activity_main2
    }

    /**
     * test
     */
    private fun setAdapter(recyclerView: RecyclerView) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        testAdapter = TestAdapter()
        recyclerView.adapter = testAdapter
        handler.postDelayed({
            runOnUiThread {
                list = ArrayList()
                testAdapter.loadData(list)
            }
        }, 2000)
    }

    /**
     * 配置底部导航栏
     */
    private fun setupNav() {
        val home = AHBottomNavigationItem("首页", R.drawable.ic_launcher_background)
        val find = AHBottomNavigationItem("发现", R.drawable.ic_launcher_background)
        val mine = AHBottomNavigationItem("我的", R.drawable.ic_launcher_background)
        val news = AHBottomNavigationItem("消息", R.drawable.ic_launcher_background)
        bottom_navigation_.addItem(home)
        bottom_navigation_.addItem(news)
        bottom_navigation_.addItem(find)
        bottom_navigation_.addItem(mine)
        bottom_navigation_.titleState = AHBottomNavigation.TitleState.ALWAYS_SHOW
        bottom_navigation_.setOnTabSelectedListener { position, _ ->
            selectFragment(position)
            true
        }
    }

    /**
     * 选择Fragment
     */
    private fun selectFragment(position: Int) {

    }
}
