package com.example.frontend

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.frontend.databinding.ProjectItemBinding
import com.example.frontend.ProjectModelItem


class ProjectAdapter(var postlist : List<ProjectModelItem>) : RecyclerView.Adapter<ProjectAdapter.ViewHolder>() {


    var urlss = "https://images.unsplash.com/photo-1527219525722-f9767a7f2884?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nnx8cHJvamVjdHN8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ProjectItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.apply {
            var current = postlist[position]
            holder.Name.text = current.name
            holder.Date.text = "March 04, 2002"
            holder.Details.text = current.description
            holder.Hastags.text = current.tags
            Glide.with(holder.itemView.context).load(urlss).into(holder.image)

            holder.itemView.setOnClickListener {
                val action = ProjectFragmentDirections.actionProjectFragmentToProjectDetailFragment(current.name,
                    current.description,current.tags)
                Navigation.createNavigateOnClickListener(action).onClick(holder.itemView)
                
            }
        }
    }

    override fun getItemCount(): Int {
        return postlist.size
    }

    inner class ViewHolder(val binding : ProjectItemBinding) : RecyclerView.ViewHolder(binding.root) {

        val Name: TextView =itemView.findViewById(R.id.Name)
        val image: ImageView = itemView.findViewById(R.id.image)
        val Date: TextView = itemView.findViewById(R.id.Date)
        val Hastags: TextView = itemView.findViewById(R.id.Hastags)
        val Details: TextView = itemView.findViewById(R.id.Details)

    }

}


