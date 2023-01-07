package com.example.frontend

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.frontend.databinding.FragmentEventBinding
import com.example.frontend.databinding.FragmentFeedBinding
import com.example.frontend.databinding.FragmentProfileBinding

private var _binding: FragmentEventBinding? = null
private val binding get() = _binding!!

class EventFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentEventBinding.inflate(inflater,container,false)
        val view = binding.root

        binding.back3.setOnClickListener {
            findNavController().navigate(R.id.action_eventFragment_to_feedFragment)
        }

        return view
    }

}