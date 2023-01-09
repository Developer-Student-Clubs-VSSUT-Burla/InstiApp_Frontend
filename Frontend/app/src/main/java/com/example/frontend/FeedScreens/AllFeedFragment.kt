package com.example.frontend.FeedScreens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.frontend.R
import com.example.frontend.databinding.FragmentAllFeedBinding
import com.example.frontend.databinding.FragmentFeedBinding
import kotlinx.android.synthetic.main.fragment_all_feed.*


private var _binding: FragmentAllFeedBinding? = null
private val binding get() = _binding!!

class AllFeedFragment : Fragment() {

    private lateinit var feedRecyclerView: RecyclerView
    private lateinit var feedArraylist: ArrayList<Feed>
    lateinit var feedImageId: Array<String>
    lateinit var feedTitle: Array<String>
    lateinit var feedContributor: Array<String>
    lateinit var feedCategory: Array<String>

    private lateinit var adapter: FeedAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAllFeedBinding.inflate(inflater, container, false)
        val view = binding.root

        feedImageId = arrayOf(
            "https://cdn.pixabay.com/photo/2015/01/09/11/08/startup-594090__340.jpg",
            "https://cdn.pixabay.com/photo/2015/07/17/22/43/student-849825__340.jpg",
            "https://cdn.pixabay.com/photo/2016/12/02/02/10/idea-1876659__340.jpg"
        )

        feedTitle = arrayOf("Institution App", "Web Application", "Robotics Project")
        feedContributor = arrayOf("GDSC-VSSUT", "Enigma VSSUT", "Robotics VSSUT")
        feedCategory = arrayOf("Software", "Software", "Hardware")
        feedArraylist= arrayListOf<Feed>()

        feedRecyclerView = binding.allFeedRecyclerView
        feedRecyclerView.layoutManager=LinearLayoutManager(this.context)
        feedRecyclerView.setHasFixedSize(true)

        adapter=FeedAdapter(this.requireContext(),feedArraylist)
        feedRecyclerView.adapter=adapter


        getUserdata()
        return view
    }

    private fun getUserdata(){
        for(i in feedImageId.indices){
            val feeds = Feed(feedImageId[i],feedTitle[i],feedContributor[i],feedCategory[i])
            feedArraylist.add(feeds)
        }
    }

}