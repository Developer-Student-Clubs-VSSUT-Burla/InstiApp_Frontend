package com.example.frontend

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.frontend.databinding.FragmentFeedBinding
import com.example.frontend.databinding.FragmentProfileBinding
import com.example.frontend.databinding.FragmentProjectBinding

private var _binding: FragmentProjectBinding? =null
private val binding get() = _binding!!

class ProjectFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentProjectBinding.inflate(inflater,container,false)
        val view = binding.root

        binding.back2.setOnClickListener {
            findNavController().navigate(R.id.action_projectFragment_to_feedFragment)
        }

        return view
    }

}