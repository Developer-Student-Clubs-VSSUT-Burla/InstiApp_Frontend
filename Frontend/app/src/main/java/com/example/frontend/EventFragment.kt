package com.example.frontend

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.frontend.databinding.FragmentEventBinding
import com.example.frontend.databinding.FragmentFeedBinding
import com.example.frontend.databinding.FragmentProfileBinding

@SuppressLint("StaticFieldLeak")
private var _binding: FragmentEventBinding? = null
private val binding get() = _binding!!

class EventFragment : Fragment() {

    lateinit var adapter: RecyclerView.Adapter<EventAdapter.ViewHolder>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentEventBinding.inflate(inflater,container,false)
        val view = binding.root

        adapter = EventAdapter()
        binding.recyclev.adapter = adapter

        binding.back3.setOnClickListener {
            findNavController().navigate(R.id.action_eventFragment_to_feedFragment)
        }

        return view
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.recyclev.layoutManager = LinearLayoutManager(activity)
    }

}