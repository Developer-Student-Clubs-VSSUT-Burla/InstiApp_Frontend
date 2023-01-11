package com.example.frontend

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.frontend.databinding.FragmentFeedBinding
import com.example.frontend.databinding.FragmentProfileBinding
import com.example.frontend.databinding.FragmentProjectBinding
import com.example.frontend.retrofit.ApiClient
import kotlinx.android.synthetic.main.fragment_project.*
import retrofit2.HttpException
import java.io.IOException

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


        lifecycleScope.launchWhenCreated {
            val response = try {
                ApiClient.userService.getPosts()
            }catch (e: IOException){
                Log.e(TAG,"IOException, you might not have Internet Connection")
                Toast.makeText(activity,"IOException, you might not have Internet Connection", Toast.LENGTH_LONG).show()
                return@launchWhenCreated
            }catch (e: HttpException){
                Log.e(TAG,"HttpException,unexpected response")
                Toast.makeText(activity,"HttpException,unexpected response", Toast.LENGTH_LONG).show()
                return@launchWhenCreated
            }
            if(response.isSuccessful && response.body()!=null){
                Log.d("Response_List",response.body()!![0].name)

                binding.recycleviewproject.apply {
                    adapter = ProjectAdapter(response.body()!!)
                    binding.recycleviewproject.adapter = adapter
                    //layoutManager = LinearLayoutManager(context)
                }
            }
            else{
                Log.e(TAG,"Response Not Successful")
            }
        }





        binding.back2.setOnClickListener {
            findNavController().navigate(R.id.action_projectFragment_to_feedFragment)
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.recycleviewproject.layoutManager = LinearLayoutManager(activity)
    }


}