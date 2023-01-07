package com.example.frontend

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.frontend.databinding.FragmentFeedBinding
import com.example.frontend.databinding.FragmentProfileBinding

private var _binding: FragmentProfileBinding? =null
private val binding get() = _binding!!

class ProfileFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentProfileBinding.inflate(inflater,container,false)
        val view = binding.root

        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_feedFragment)
        }

        return view
    }

}