package com.example.wk.frameworkk.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.example.wk.frameworkk.app.App
import com.example.wk.frameworkk.constant.AppConstant
import com.example.wk.frameworkk.ui.home.HomeFragment
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

@Suppress("UNCHECKED_CAST")
/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/22 <P>
 * Description: SP相关操作
 * <p>
 * E-mail:wangkang@huolicai.com
 */
class SPProxy<T>(private val name: String, private val default: T) {

    private val sp: SharedPreferences by lazy { App.context.getSharedPreferences(AppConstant.SP_NAME, Context.MODE_PRIVATE) }


    /**
     * 获取sp
     */
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        var value: Any = when (default) {
            is String -> sp.getString(name, default)
            is Boolean -> sp.getBoolean(name, default)
            is Int -> sp.getInt(name, default)
            is Float -> sp.getFloat(name, default)
            is Long -> sp.getLong(name, default)
            else -> {
            }
        }
        return value as T
    }

    /**
     * set
     */
    @SuppressLint("CommitPrefEdits")
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        val edit = sp.edit()
        when (value) {
            is Long -> edit.putLong(name, value)
            is String -> edit.putString(name, value)
            is Int -> edit.putInt(name, value)
            is Boolean -> edit.putBoolean(name, value)
            is Float -> edit.putFloat(name, value)
            else -> edit.putString(name, "")
        }.apply()
    }
}