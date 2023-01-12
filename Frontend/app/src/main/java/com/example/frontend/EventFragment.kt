package com.example.frontend

import android.annotation.SuppressLint
import android.content.ContentValues
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
import com.example.frontend.databinding.FragmentEventBinding
import com.example.frontend.databinding.FragmentFeedBinding
import com.example.frontend.databinding.FragmentProfileBinding
import com.example.frontend.retrofit.ApiClient
import retrofit2.HttpException
import java.io.IOException

@SuppressLint("StaticFieldLeak")
private var _binding: FragmentEventBinding? = null
private val binding get() = _binding!!

class EventFragment : Fragment() {

    lateinit var adapter: RecyclerView.Adapter<EventAdapter.ViewHolder>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentEventBinding.inflate(inflater,container,false)
        val view = binding.root



        lifecycleScope.launchWhenCreated {
            val response = try {
                ApiClient.userService.getEvents()
            }catch (e: IOException){
                Log.e(ContentValues.TAG,"IOException, you might not have Internet Connection")
                Toast.makeText(activity,"IOException, you might not have Internet Connection", Toast.LENGTH_LONG).show()
                return@launchWhenCreated
            }catch (e: HttpException){
                Log.e(ContentValues.TAG,"HttpException,unexpected response")
                Toast.makeText(activity,"HttpException,unexpected response", Toast.LENGTH_LONG).show()
                return@launchWhenCreated
            }
            if(response.isSuccessful && response.body()!=null){
                Log.d("Response_List",response.body()!![0].name)

                binding.recyclev.apply {
                    adapter = EventAdapter(response.body()!!)
                    binding.recyclev.adapter = adapter
                    //layoutManager = LinearLayoutManager(context)
                }
            }
            else{
                Log.e(ContentValues.TAG,"Response Not Successful")
            }
        }





        binding.back3.setOnClickListener {
            findNavController().navigate(R.id.action_eventFragment_to_feedFragment)
        }

        return view
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.recyclev.layoutManager = LinearLayoutManager(activity)
    }

}