package com.example.wk.frameworkk.adapter.vh

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.example.wk.frameworkk.R
import com.example.wk.frameworkk.bean.TYHomeItem
import com.example.wk.frameworkk.gilde.GlideApp
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import com.youth.banner.loader.ImageLoaderInterface

/**
 * <p>
 * Author : WangKang <p>
 * Created: 2018/7/2 <P>
 * Description:
 * <p>
 * E-mail:wangkang@huolicai.com
 */
class TyHeadVH(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    private var banners: Banner? = null

    init {
        banners = itemView?.findViewById(R.id.banner)
    }

    fun bindData(item: TYHomeItem, context: Context) {
        val images: ArrayList<String> = ArrayList()
        val titles: ArrayList<String> = ArrayList()
        item.banners?.forEach {
            images.add(it.data.cover.feed)
            titles.add(it.data.title)
        }
        banners?.setImageLoader(object : ImageLoaderInterface<ImageView> {
            override fun createImageView(context: Context?): ImageView {
                return ImageView(context)
            }

            @SuppressLint("CheckResult")
            override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
                context?.let { imageView?.let { it1 -> GlideApp.with(it).load(path).into(it1) } }
            }

        })
        banners?.setDelayTime(2000)
        banners?.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
        banners?.setImages(images)
        banners?.setBannerTitles(titles)
        banners?.start()
    }


}