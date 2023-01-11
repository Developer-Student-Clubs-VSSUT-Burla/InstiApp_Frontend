package com.example.frontend

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class EventAdapter :RecyclerView.Adapter<EventAdapter.ViewHolder>(){
    private val ename = arrayOf("Info Session cum Orientation","Flutter Festival","Android Study Jams","Android Study Jams","Android Study Jams","Flutter Festival","Flutter Festival","Android Study Jams")
    private val eorg = arrayOf("GDSC VSSUT","GDG Cloud BBSR","GDSC VSSUT","GDSC VSSUT","GDSC VSSUT","GDSC VSSUT","GDSC VSSUT","GDSC VSSUT")
    private val edate = arrayOf("December 17, 2022 . Burla,India","May 06, 2023 . Bhubaneswar,India","August 17, 2023 . Sambalpur,India","August 17, 2023 . Sambalpur,India","August 17, 2023 . Sambalpur,India","August 17, 2023 . Sambalpur,India","August 17, 2023 . Sambalpur,India","August 17, 2023 . Sambalpur,India")

    private val eurls = arrayOf("https://images.unsplash.com/photo-1485872299829-c673f5194813?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=560&q=80",
        "https://images.unsplash.com/photo-1525268771113-32d9e9021a97?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=580&q=80",
        "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
        "https://images.unsplash.com/photo-1621600411688-4be93cd68504?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=580&q=80",
        "https://images.unsplash.com/photo-1621600411688-4be93cd68504?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=580&q=80",
        "https://images.unsplash.com/photo-1621600411688-4be93cd68504?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=580&q=80",
        "https://images.unsplash.com/photo-1621600411688-4be93cd68504?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=580&q=80",
        "https://images.unsplash.com/photo-1621600411688-4be93cd68504?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=580&q=80"
    )




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.event_item,parent,false)

        val viewHolder=ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.Name.text = ename[position]
        holder.Org.text = eorg[position]
        holder.Date.text = edate[position]
        Glide.with(holder.itemView.context).load(eurls[position]).into(holder.image)
    }

    override fun getItemCount(): Int {
        return ename.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val Name: TextView =itemView.findViewById(R.id.ename)
        val image: ImageView = itemView.findViewById(R.id.eurls)
        val Date: TextView = itemView.findViewById(R.id.edate)
        val Org: TextView = itemView.findViewById(R.id.eorg)

    }
}


