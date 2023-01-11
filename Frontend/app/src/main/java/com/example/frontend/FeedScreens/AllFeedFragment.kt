package com.example.frontend.FeedScreens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.frontend.R
import com.example.frontend.databinding.FragmentAllFeedBinding
import com.example.frontend.databinding.FragmentFeedBinding
import com.example.frontend.retrofit.ApiClient
import kotlinx.android.synthetic.main.fragment_all_feed.*
import java.io.IOException
import retrofit2.HttpException


const val TAG = "feedBinding"

private lateinit var feedBinding: FragmentAllFeedBinding
private val binding get() = feedBinding!!


class AllFeedFragment : Fragment() {

    private lateinit var FeedAdapter: FeedAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        feedBinding = FragmentAllFeedBinding.inflate(inflater, container, false)
        val view = binding.root

        lifecycleScope.launchWhenCreated {
            val response = try {
                ApiClient.userService.getFeeds()
            } catch (e: IOException) {
                Log.e(TAG, "IOException, you might not have Internet Connection")
                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.e(TAG, "HttpException,unexpected response")
                return@launchWhenCreated
            }
            if (response.isSuccessful && response.body() != null) {
                FeedAdapter.feeds = response.body()!!
                Log.d(TAG, response.body().toString())
            } else {
                Log.e(TAG, "Response Not Successful")
            }
        }


        setUpRecyclerView()
        return view
    }

    private fun setUpRecyclerView() = binding.allFeedRecyclerView.apply {
        FeedAdapter = FeedAdapter()
        adapter = FeedAdapter
        layoutManager = LinearLayoutManager(context)

    }

}