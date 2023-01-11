package com.example.frontend

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.frontend.FeedDescriptionFragmentArgs
import com.example.frontend.adapter.FeedMemberAdapter
import com.example.frontend.databinding.FragmentFeedDescriptionBinding

private var _binding: FragmentFeedDescriptionBinding? = null
private val binding get() = _binding!!
private lateinit var FeedMemberAdapter: FeedMemberAdapter

class FeedDescriptionFragment : Fragment() {
    private val args: FeedDescriptionFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFeedDescriptionBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.feedTitle.text = args.feedTitle
        binding.feedDescription.text = args.feedDescription
        binding.feedCategory.text = args.feedCategory
        binding.feedContributor.text = args.feedContributor

        setupRecyclerView()
        FeedMemberAdapter.teammembers = args.feedMembers.toList()

        return view
    }

    private fun setupRecyclerView() = binding.contributorRecyclerView.apply {
        FeedMemberAdapter = FeedMemberAdapter()
        adapter = FeedMemberAdapter
        layoutManager = LinearLayoutManager(context)

    }


}