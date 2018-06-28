package com.example.wk.frameworkk.ui.activity

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import cn.sharesdk.tencent.qq.QQ
import com.example.wk.frameworkk.R
import com.example.wk.frameworkk.base.BaseActivity
import com.example.wk.frameworkk.constant.AppConstant
import com.example.wk.frameworkk.utils.ShareUtils
import com.jaeger.library.StatusBarUtil

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/25 <P>
 * Description: webView
 * <p>  具体设置参考 https://mp.weixin.qq.com/s?__biz=MzI3NDM3Mjg5NQ==&mid=2247483682&idx=1&sn=b1e03bfb789f75467c351a8ed7dfc156&scene=0#rd
 * E-mail:wangkang@huolicai.com
 */
class WebActivity : BaseActivity() {
    var progressBar: ProgressBar? = null
    var webview: WebView? = null
    var url: String? = null
    var mTitle: String? = null
    override fun initInstanceState(savedInstanceState: Bundle?) {
        url = intent.getStringExtra(AppConstant.WEB_URL)
        mTitle = intent.getStringExtra(AppConstant.TITLE)
    }

    override fun initView() {
        StatusBarUtil.setColor(this, resources.getColor(R.color.colorPrimary), 0)
        mTitle?.let { initToolbar(it) }
        progressBar = findViewById(R.id.progress)
        webview = findViewById(R.id.webView)
        setUpWebSetting()
        setupWebViewClient()
        setupWebViewChromeClient()
        webview?.loadUrl(url)
    }

    private fun setupWebViewChromeClient() {
        webview?.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                progressBar?.progress = newProgress
                super.onProgressChanged(view, newProgress)
            }

            override fun onReceivedTitle(view: WebView?, title: String?) {
                if (title != null) {
                    title.let { initToolbar(it) }
                } else {
                    mTitle?.let { initToolbar(it) }
                }
                super.onReceivedTitle(view, title)
            }
        }

    }

    private fun setupWebViewClient() {
        webview?.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                view?.loadUrl(request.toString())
                return super.shouldOverrideUrlLoading(view, request)
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                progressBar?.visibility = VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progressBar?.visibility = GONE
            }
        }
    }

    /**
     * 配置webView Setting
     *
     */
    @SuppressLint("SetJavaScriptEnabled")
    private fun setUpWebSetting() {
        val settings = webview?.settings
        //设置WebView是否可以运行JavaScript。
        settings?.javaScriptEnabled = true
        //启用或禁用WebView访问文件数据。
        settings?.allowFileAccess = true
        //设置是否支持缩放
        settings?.setSupportZoom(true)
        //
        settings?.defaultTextEncodingName = "UTF-8"
    }

    override fun layout(): Int {
        return R.layout.activity_webview
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && webview?.canGoBack()!!) {
            webview?.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_share, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_share -> {
                val shareUtils = ShareUtils(QQ.NAME)
                shareUtils.build(this)
                        .title("title")
                        .text("text")
                        .share()
            }
            else -> {
            }
        }


        return super.onOptionsItemSelected(item)
    }
}