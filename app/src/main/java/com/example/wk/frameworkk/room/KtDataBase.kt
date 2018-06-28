package com.example.wk.frameworkk.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.wk.frameworkk.bean.User

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/28 <P>
 * Description:
 * <p>
 * E-mail:wangkang@huolicai.com
 */
@Database(entities = [(User::class)], version = 1)
abstract class KtDataBase : RoomDatabase() {
    abstract fun paoDao(): KtDaoImp

    companion object {
        @Volatile
        private var INSTANCE: KtDataBase? = null

        fun getInstance(context: Context): KtDataBase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        KtDataBase::class.java, "ktSample.db")
                        .build()
    }
}