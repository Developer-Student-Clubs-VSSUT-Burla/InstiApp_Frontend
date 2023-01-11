package com.example.frontend

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.frontend.databinding.FragmentProjectBinding
import com.example.frontend.databinding.FragmentProjectDetailBinding

private var _binding: FragmentProjectDetailBinding? =null
private val binding get() = _binding!!

class ProjectDetailFragment : Fragment() {

    private val args: ProjectDetailFragmentArgs by navArgs()
    lateinit var adapter: RecyclerView.Adapter<ContributorAdapter.ViewHolder>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentProjectDetailBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.detailsapi.text = args.pdesc
        binding.projectname.text = args.pname
        binding.tagsapi.text = args.ptags

        binding.recycle.apply {
            adapter = ContributorAdapter()
            binding.recycle.adapter = adapter
        }

        binding.back4.setOnClickListener {
            findNavController().navigate(R.id.action_projectDetailFragment_to_projectFragment)
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.recycle.layoutManager = LinearLayoutManager(activity)
    }


}