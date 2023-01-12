package com.example.frontend

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.frontend.databinding.EventItemBinding
import com.example.frontend.databinding.ProjectItemBinding

class EventAdapter(var eventList : List<EventModelItem>) :RecyclerView.Adapter<EventAdapter.ViewHolder>(){
    private val ename = arrayOf("Info Session cum Orientation","Flutter Festival","Android Study Jams","Android Study Jams","Android Study Jams","Flutter Festival","Flutter Festival","Android Study Jams")
    private val eorg = arrayOf("GDSC VSSUT","GDG Cloud BBSR","GDSC VSSUT","GDSC VSSUT","GDSC VSSUT","GDSC VSSUT","GDSC VSSUT","GDSC VSSUT")
    private val edate = arrayOf("December 17, 2022 . Burla,India","May 06, 2023 . Bhubaneswar,India","August 17, 2023 . Sambalpur,India","August 17, 2023 . Sambalpur,India","August 17, 2023 . Sambalpur,India","August 17, 2023 . Sambalpur,India","August 17, 2023 . Sambalpur,India","August 17, 2023 . Sambalpur,India")

    private val eurls = "https://images.unsplash.com/photo-1485872299829-c673f5194813?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=560&q=80"




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            EventItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.apply{
            var current = eventList[position]
            holder.Name.text = current.name
            holder.Org.text = current.club_name
            holder.Date.text = current.date
            Glide.with(holder.itemView.context).load(eurls).into(holder.image)
            holder.itemView.setOnClickListener {
                val action = EventFragmentDirections.actionEventFragmentToFragmentEventDetails3(
                    current.name,
                    current.description,
                    current.date,
                    current.venue,
                    current.expected_no_of_participants.toString()
                )
                Navigation.createNavigateOnClickListener(action).onClick(holder.itemView)

            }

        }

    }

    override fun getItemCount(): Int {
        return eventList.size
    }

    inner class ViewHolder(val binding : EventItemBinding) : RecyclerView.ViewHolder(binding.root) {

        val Name: TextView =itemView.findViewById(R.id.ename)
        val image: ImageView = itemView.findViewById(R.id.eurls)
        val Date: TextView = itemView.findViewById(R.id.edate)
        val Org: TextView = itemView.findViewById(R.id.eorg)

    }
}


