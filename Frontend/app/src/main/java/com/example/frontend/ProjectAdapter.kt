package com.example.frontend

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class ProjectAdapter : RecyclerView.Adapter<ProjectAdapter.ViewHolder>() {

    private val fname = arrayOf("Swapnil Kumar Sahu", "Suraj Mahapatra", "Rajat Kumar Nayak")
    private val fdate = arrayOf("December 06,2000", "March 04,2002", "August 15,2002")
    private val fdetails = arrayOf("Lorem ipsum dolor sit amet consectetur. Ut tellus aenean mi amet. Sit nhfjhjhchjv gkjb unc molestie in diam fermentum.",
                                    "Lorem ipsum dolor sit amet consectetur. Ut tellus aenean mi amet. Sit nhfjhjhchjv gkjb unc molestie in diam fermentum.",
                                    "Lorem ipsum dolor sit amet consectetur. Ut tellus aenean mi amet. Sit nhfjhjhchjv gkjb unc molestie in diam fermentum." )
    private val fhastags = arrayOf("#happy #sad #love #hate #confuse", "#happy #sad #love #hate #confuse", "#happy #sad #love #hate #confuse")
    private val furls = arrayOf("https://images.unsplash.com/photo-1527219525722-f9767a7f2884?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nnx8cHJvamVjdHN8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60",
                                "https://images.unsplash.com/photo-1523289333742-be1143f6b766?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTd8fHByb2plY3RzfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
                                "https://images.unsplash.com/photo-1531403009284-440f080d1e12?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8cHJvamVjdHN8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60"
        )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.project_item,parent,false)

        val viewHolder=ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.Name.text = fname[position]
        holder.Date.text = fdate[position]
        holder.Details.text = fdetails[position]
        holder.Hastags.text = fhastags[position]
        Glide.with(holder.itemView.context).load(furls[position]).into(holder.image)
    }

    override fun getItemCount(): Int {
        return fname.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val Name: TextView =itemView.findViewById(R.id.Name)
        val image: ImageView = itemView.findViewById(R.id.image)
        val Date: TextView = itemView.findViewById(R.id.Date)
        val Hastags: TextView = itemView.findViewById(R.id.Hastags)
        val Details: TextView = itemView.findViewById(R.id.Details)

    }

}


