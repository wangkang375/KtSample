package com.example.wk.frameworkk.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity


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

    abstract fun initInstanceState(savedInstanceState: Bundle?)

    private fun initData() {

    }

    abstract fun initView()

    abstract fun layout(): Int



}