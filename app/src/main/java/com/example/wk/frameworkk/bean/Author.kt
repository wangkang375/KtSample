package com.example.wk.frameworkk.bean

data class Author(
        val id: Int,
        val icon: String,
        val name: String,
        val description: String,
        val link: String,
        val latestReleaseTime: Long,
        val videoNum: Int,
        val adTrack: Any,
        val follow: Follow,
        val shield: Shield,
        val approvedNotReadyVideoCount: Int,
        val ifPgc: Boolean
)