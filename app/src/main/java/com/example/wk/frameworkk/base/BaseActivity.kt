package com.example.wk.frameworkk.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.Toast
import cn.sharesdk.framework.Platform
import cn.sharesdk.framework.PlatformActionListener

import com.example.wk.frameworkk.R
import java.util.HashMap


/**
 * <p> 基类
 * Author : WangKang <p>
 * Created: 2018/6/20 <P>
 * Description:
 * <p>
 * E-mail:wangkang@huolicai.com
 */
abstract class BaseActivity : AppCompatActivity(), PlatformActionListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout())
        initInstanceState(savedInstanceState)
        initView()
        initData()
    }

    public fun initToolbar(title: String) {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = title
    }

    abstract fun initInstanceState(savedInstanceState: Bundle?)

    protected open fun initData() {

    }

    abstract fun initView()

    abstract fun layout(): Int

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                finish()
            }
            else -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * 以下分享回调
     */
    override fun onComplete(p0: Platform?, p1: Int, p2: HashMap<String, Any>?) {
        toast(p0?.name)
    }

    override fun onCancel(p0: Platform?, p1: Int) {
        toast("取消分享")
    }

    override fun onError(p0: Platform?, p1: Int, p2: Throwable?) {
        toast(p2?.message!!)
    }

    fun toast(x: String?) {
        Toast.makeText(this, x, Toast.LENGTH_SHORT).show()
    }
}