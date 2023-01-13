package com.example.frontend

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.frontend.databinding.FragmentEventDetailsBinding
import com.example.frontend.databinding.FragmentProjectBinding
import com.example.frontend.databinding.FragmentProjectDetailBinding

private var _binding: FragmentEventDetailsBinding? =null
private val binding get() = _binding!!

class Fragment_event_details : Fragment() {

    private val args: Fragment_event_detailsArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentEventDetailsBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.ename.text = args.eventname
        binding.edesc.text = args.eventdesc
        binding.evenue.text=args.eventvenue
        binding.edate.text=args.eventdate
        binding.epart.text = args.eventpart

        binding.imageView4.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_event_details3_to_eventFragment)
        }

        return view
    }


}