package com.example.wk.frameworkk.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem

import com.example.wk.frameworkk.R


/**
 * <p> 基类
 * Author : WangKang <p>
 * Created: 2018/6/20 <P>
 * Description:
 * <p>
 * E-mail:wangkang@huolicai.com
 */
abstract class BaseActivity : AppCompatActivity() {
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
}