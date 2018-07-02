package com.example.wk.frameworkk.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.MenuItem
import cn.jpush.android.api.JPushInterface
import com.example.wk.frameworkk.R
import com.example.wk.frameworkk.base.BaseActivity
import com.example.wk.frameworkk.ui.collect.TYFragment
import com.example.wk.frameworkk.ui.find.FindFragment
import com.example.wk.frameworkk.ui.home.HomeFragment
import com.example.wk.frameworkk.ui.mine.MineFragment
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity : BaseActivity(), BottomNavigationView.OnNavigationItemSelectedListener {


    var fragmentTags: Array<String> = arrayOf("首页", "消息", "发现", "我的")
    var fragments: ArrayList<Fragment> = ArrayList()
    var homeFragment: HomeFragment? = null
    var collectFragment: TYFragment? = null
    var findFragment: FindFragment? = null
    var mineFragment: MineFragment? = null
    override fun initInstanceState(savedInstanceState: Bundle?) {

    }

    private lateinit var list: ArrayList<String>

    companion object {
        val handler: Handler = Handler()
    }

    override fun initView() {
        setupNav()
        initFragments()
        selectFragment(0)
        list = ArrayList()
        list.add("A")
        list.add("b")
        list.add("c")
        list.add("d")
        val size = list.filter { it == "A" || it == "b" }
                .map { it.toUpperCase() }
                .size
        println("==========长度：$size")
    }

    private fun initFragments() {
        homeFragment = HomeFragment.getInstance(fragmentTags[0])
        collectFragment = TYFragment.getInstance(fragmentTags[1])
        findFragment = FindFragment.getInstance(fragmentTags[2])
        mineFragment = MineFragment.getInstance(fragmentTags[3])
        fragments.add(homeFragment!!)
        fragments.add(collectFragment!!)
        fragments.add(findFragment!!)
        fragments.add(mineFragment!!)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        if (null != intent) {
            val bundle = intent.extras
            var title: String? = null
            var content: String? = null
            if (bundle != null) {
                title = bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE)
                content = bundle.getString(JPushInterface.EXTRA_ALERT)
            }
            toast("收到通知信息==Title : $title  Content : $content")
        }
    }

    override fun initData() {

    }

    override fun layout(): Int {
        return R.layout.activity_main2
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_home -> {
                selectFragment(0)
                return true
            }
            R.id.item_find -> {
                selectFragment(1)
                return true
            }
            R.id.item_collect -> {
                selectFragment(2)
                return true
            }
            R.id.item_mine -> {
                selectFragment(3)
                return true
            }
            else -> {
            }
        }
        return false
    }

    /**
     * 配置底部导航栏
     */
    private fun setupNav() {
        bottom_navigation_.setOnNavigationItemSelectedListener(this)
    }

    /**
     * 选择Fragment
     */
    private fun selectFragment(position: Int) {
        val beginTransaction = supportFragmentManager.beginTransaction()
        val fragmentByTag = supportFragmentManager.findFragmentByTag(fragmentTags[position])
        hindFragment(beginTransaction)
        if (fragmentByTag == null) {
            beginTransaction.add(R.id.fragment_container, fragments[position], fragmentTags[position])
        } else {
            beginTransaction.show(fragmentByTag)
        }
        beginTransaction.commit()
    }

    private fun hindFragment(beginTransaction: FragmentTransaction) {
        for (fragment in fragments) {
            if (!fragment.isHidden && fragment.isAdded) {
                beginTransaction.hide(fragment)
            }
        }
    }


}
