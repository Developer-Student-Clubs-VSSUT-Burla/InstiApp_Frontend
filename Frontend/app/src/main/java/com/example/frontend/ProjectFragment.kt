package com.example.frontend

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.frontend.databinding.FragmentFeedBinding
import com.example.frontend.databinding.FragmentProfileBinding
import com.example.frontend.databinding.FragmentProjectBinding
import kotlinx.android.synthetic.main.fragment_project.*

private var _binding: FragmentProjectBinding? =null
private val binding get() = _binding!!

class ProjectFragment : Fragment() {

    var currentUrl: String = "https://github.com/Developer-Student-Clubs-VSSUT-Burla/InstiApp_Frontend.git"
    lateinit var adapter: RecyclerView.Adapter<ProjectAdapter.ViewHolder>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentProjectBinding.inflate(inflater,container,false)
        val view = binding.root

        adapter = ProjectAdapter()
        binding.recycleviewproject.adapter = adapter


        binding.back2.setOnClickListener {
            findNavController().navigate(R.id.action_projectFragment_to_feedFragment)
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.recycleviewproject.layoutManager = LinearLayoutManager(activity)
    }

    fun sfn(view: View) {
        val i = Intent(Intent.ACTION_SEND)
        i.type = "text/plain"
        i.putExtra(Intent.EXTRA_TEXT, "Read latest news on $currentUrl")
        val chooser = Intent.createChooser(i, "Share the news link with")
        startActivity(chooser)
    }

}