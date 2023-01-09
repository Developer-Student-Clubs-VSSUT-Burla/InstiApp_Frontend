package com.example.frontend

import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.view.ViewParent
import androidx.activity.OnBackPressedCallback
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2

import com.example.frontend.databinding.FragmentFeedBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


private var _binding: FragmentFeedBinding? =null
private val binding get() = _binding!!

class FeedFragment : Fragment() {
    private lateinit var tlayout:TabLayout
    private lateinit var viewPager:ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {





        _binding = FragmentFeedBinding.inflate(inflater,container,false)
        val view = binding.root

        tlayout= binding.tabLayout
        viewPager= binding.viewPager

        viewPager.adapter = FeedViewPagerAdapter(requireActivity())
        TabLayoutMediator(tlayout,viewPager){
            tab,index->
            tab.text = when(index){
                0 -> {"All"}
                1 -> {"Liked"}
                else -> {
                    throw Resources.NotFoundException("Position Not Found")
                }
            }

        }.attach()


        binding.toolbar.setNavigationOnClickListener {
            binding.feedDrawer.openDrawer(GravityCompat.START)
        }

        binding!!.navView.setNavigationItemSelectedListener {
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