package com.example.frontend.FeedScreens

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.frontend.R

class FeedAdapter(private val context: Context, private val feedList: ArrayList<Feed>) :
    RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var feedImage: ImageView = itemView.findViewById(R.id.feed_image)
        var feedtitle: TextView = itemView.findViewById(R.id.feed_title)
        var feedcontributor: TextView = itemView.findViewById(R.id.feed_contributor)
        var feedtype: TextView = itemView.findViewById(R.id.feed_type)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.feed_item, parent, false
        )
        return FeedViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val currentItem = feedList[position]
        holder.feedtitle.text = currentItem.feed_title
        holder.feedcontributor.text = currentItem.contributor
        holder.feedtype.text = currentItem.feed_type

        Glide.with(context).load(currentItem.feedImage).into(holder.feedImage)

    }

    override fun getItemCount(): Int {
        return feedList.size
    }

}