package com.example.wk.frameworkk.bean

data class Issue(
        val releaseTime: Long,
        val type: String,
        val date: Long,
        val publishTime: Long,
        val itemList: ArrayList<Item>,
        val count: Int
)