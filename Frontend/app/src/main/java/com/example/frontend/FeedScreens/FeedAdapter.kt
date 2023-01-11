package com.example.frontend.FeedScreens

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.frontend.FeedFragmentDirections
import com.example.frontend.databinding.FeedItemBinding
import com.example.frontend.retrofit.Feed
import com.example.frontend.retrofit.TeamMembers
import kotlin.reflect.typeOf

class FeedAdapter : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {


    inner class FeedViewHolder(val binding: FeedItemBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<Feed>() {
        override fun areItemsTheSame(oldItem: Feed, newItem: Feed): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Feed, newItem: Feed): Boolean {
            return oldItem.id == newItem.id
        }

    }
    private val differ = AsyncListDiffer(this, diffCallback)

    var feeds: List<Feed>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        return FeedViewHolder(
            FeedItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.binding.apply {
            val feed = feeds[position]
//            Glide.with(context).load(feed.feed_image).into(feedImage)
            feedTitle.text = feed.title
            feedContributor.text = feed.contributor.name
            feedType.text = feed.category
            val members=TeamMembers()

            Log.d(TAG,members::class.java.typeName)

            holder.itemView.setOnClickListener {
                val action = FeedFragmentDirections.actionFeedFragmentToFeedDescriptionFragment(
                    feed.title, feed.contributor.name, feed.description, feed.category,
                    feed.team_members.toTypedArray()
                )
                Navigation.createNavigateOnClickListener(action).onClick(holder.itemView)
            }

        }
    }

    override fun getItemCount() = feeds.size


}