package com.example.wk.frameworkk.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import cn.jpush.android.api.JPushInterface
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import com.example.wk.frameworkk.R

import com.example.wk.frameworkk.base.BaseActivity
import com.example.wk.frameworkk.ui.collect.CollectFragment
import com.example.wk.frameworkk.ui.find.FindFragment
import com.example.wk.frameworkk.ui.home.HomeFragment
import com.example.wk.frameworkk.ui.mine.MineFragment
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity : BaseActivity() {
    var fragmentTags: Array<String> = arrayOf("首页", "消息", "发现", "我的")
    var fragments: ArrayList<Fragment> = ArrayList()
    var homeFragment: HomeFragment? = null
    var collectFragment: CollectFragment? = null
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
        collectFragment = CollectFragment.getInstance(fragmentTags[1])
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

    /**
     * test
     */

    /**
     * 配置底部导航栏
     */
    private fun setupNav() {
        val home = AHBottomNavigationItem("首页", R.drawable.ic_home_black_24dp)
        val find = AHBottomNavigationItem("发现", R.drawable.ic_find_in_page_black_24dp)
        val mine = AHBottomNavigationItem("我的", R.drawable.ic_assignment_ind_black_24dp)
        val news = AHBottomNavigationItem("消息", R.drawable.ic_message_black_24dp)
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
