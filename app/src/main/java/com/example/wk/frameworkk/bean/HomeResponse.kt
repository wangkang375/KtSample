package com.example.wk.frameworkk.bean

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/6/23 <P>
 * Description: 首页Home
 * <p>
 * E-mail:wangkang@huolicai.com
 */

data class HomeResponse(
        val curPage: Int,
        val datas: ArrayList<HomeItem>,
        val offset: Int,
        val over: Boolean,
        val pageCount: Int,
        val size: Int,
        val total: Int
)

data class HomeItem(
        val apkLink: String,
        val author: String,
        val chapterId: Int,
        val chapterName: String,
        val collect: Boolean,
        val courseId: Int,
        val desc: String,
        val envelopePic: String,
        val fresh: Boolean,
        val id: Int,
        val link: String,
        val niceDate: String,
        val origin: String,
        val projectLink: String,
        val publishTime: Long,
        val superChapterId: Int,
        val superChapterName: String,
        val tags: List<HomeTag>,
        val title: String,
        val type: Int,
        val userId: Int,
        val visible: Int,
        val zan: Int
)

data class HomeTag(
        val name: String,
        val url: String
)