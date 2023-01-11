package com.example.frontend.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.frontend.databinding.FeedmemberitemBinding
import com.example.frontend.retrofit.TeamMember

class FeedMemberAdapter : RecyclerView.Adapter<FeedMemberAdapter.FeedMemberViewHolder>() {

    inner class FeedMemberViewHolder(val binding: FeedmemberitemBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<TeamMember>() {
        override fun areItemsTheSame(oldItem: TeamMember, newItem: TeamMember): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(oldItem: TeamMember, newItem: TeamMember): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var teammembers: List<TeamMember>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedMemberViewHolder {
        return FeedMemberViewHolder(
            FeedmemberitemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FeedMemberViewHolder, position: Int) {
        holder.binding.apply {
            val teammember = teammembers[position]
            memberName.text = teammember.name
            memberBranch.text = teammember.branch
            memberRegno.text = teammember.regno
        }
    }

    override fun getItemCount() = teammembers.size


}