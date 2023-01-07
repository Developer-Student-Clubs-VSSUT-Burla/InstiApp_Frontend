package com.example.frontend

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.findNavController

import com.example.frontend.databinding.FragmentFeedBinding


private var _binding: FragmentFeedBinding? =null
private val binding get() = _binding!!

class FeedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFeedBinding.inflate(inflater,container,false)
        val view = binding.root

        binding.toolbar.setNavigationOnClickListener {
            binding.feedDrawer.openDrawer(GravityCompat.START)
        }

        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.projectFragment ->
                    findNavController().navigate(R.id.action_feedFragment_to_projectFragment2)
                R.id.profileFragment ->
                    findNavController().navigate(R.id.action_feedFragment_to_profileFragment2)
                R.id.eventFragment ->
                    findNavController().navigate(R.id.action_feedFragment_to_eventFragment2)
                R.id.feedFragment ->
                    findNavController().navigate(R.id.action_feedFragment_self)
            }
            true
        }

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (binding.feedDrawer.isDrawerVisible(GravityCompat.START)) {
                        binding.feedDrawer.close()
                    } else {
                        isEnabled = false
                        requireActivity().onBackPressed()
                    }
                }
            })




        return view



    }

}