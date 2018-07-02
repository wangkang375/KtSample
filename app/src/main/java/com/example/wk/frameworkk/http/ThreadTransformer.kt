package com.example.wk.frameworkk.http

import com.example.wk.frameworkk.R
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/7/2 <P>
 * Description:统一 线程切换
 * <p>
 * E-mail:wangkang@huolicai.com
 */
class ThreadTransformer<T> : ObservableTransformer<T, T> {
    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}