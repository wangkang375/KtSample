package com.example.wk.frameworkk.bean

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/26 <P>
 * Description: denglu
 * <p>
 * E-mail:wangkang@huolicai.com
 */
@Entity(tableName = "table_user")
data class User(
        @PrimaryKey
        var id: Int,
        var username: String,
        var password: String,
        var icon: String?,
        var type: Int,
        var collectIds: List<Int>?
)