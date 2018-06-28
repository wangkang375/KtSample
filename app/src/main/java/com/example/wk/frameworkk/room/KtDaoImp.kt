package com.example.wk.frameworkk.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.wk.frameworkk.bean.User

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/28 <P>
 * Description:
 * <p>
 * E-mail:wangkang@huolicai.com
 */
@Dao
interface KtDaoImp {
    @Query("SELECT * FROM table_user")
    fun getUser(): List<User>

    @Insert
    fun saveUser(user: User)
}