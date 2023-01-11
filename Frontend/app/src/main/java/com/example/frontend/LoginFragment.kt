package com.example.frontend

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.frontend.databinding.FragmentLoginBinding
import com.example.frontend.databinding.FragmentProjectBinding


private var _binding: FragmentLoginBinding? =null
private val binding get() = _binding!!

class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater,container,false)
        val view = binding.root

        binding.createAccount.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }

        binding.upload.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_feedFragment)
        }
        return view
    }


}