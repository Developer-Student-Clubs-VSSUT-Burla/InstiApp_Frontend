package com.example.frontend

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.frontend.databinding.FragmentProjectBinding
import com.example.frontend.databinding.FragmentSignupBinding

private var _binding: FragmentSignupBinding? =null
private val binding get() = _binding!!

class signupFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignupBinding.inflate(inflater,container,false)
        val view = binding.root


        binding.upload2.setOnClickListener {
            if (binding.EmailInput2.text.toString().isNotEmpty() && binding.PasswordInput2.text.toString().isNotEmpty() &&
                binding.NameInput.text.toString().isNotEmpty())
            {
                findNavController().navigate(R.id.action_signupFragment_to_feedFragment)
            }
            else {
                Toast.makeText(activity, "Enter all the fields", Toast.LENGTH_SHORT).show()
            }
        }


        binding.createAccount2.setOnClickListener {
            findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
        }

        return view
    }

}