package com.example.frontend

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.frontend.databinding.ContributorItemBinding


class ContributorAdapter(var postlist : List<TeamMember>): RecyclerView.Adapter<ContributorAdapter.ViewHolder>() {

//    private val postlist = arrayOf("Suraj Mahapatra", "Suraj Mahapatra","Suraj Mahapatra", "Suraj Mahapatra")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ContributorItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            holder.Namee.text = postlist[position].name
            holder.regdd.text = postlist[position].regno
        }
    }

    override fun getItemCount(): Int {
        return postlist.size
    }

    inner class ViewHolder(val binding: ContributorItemBinding) : RecyclerView.ViewHolder(binding.root) {

        val Namee: TextView =itemView.findViewById(R.id.ContributorName)
        val regdd : TextView = itemView.findViewById(R.id.Regd)

    }

}


