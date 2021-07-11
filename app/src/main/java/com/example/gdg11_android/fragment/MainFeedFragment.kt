package com.example.gdg11_android.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gdg11_android.R
import com.example.gdg11_android.activity.MainActivity
import com.example.gdg11_android.adapter.MainFeedAdapter
import com.example.gdg11_android.databinding.MainFeedBinding
import com.example.gdg11_android.dto.GetFeedData
import com.example.gdg11_android.exchange.ExchangeActivity
import com.example.gdg11_android.viewmodel.MainFeedViewModel
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFeedFragment : Fragment(){
    lateinit var binding : MainFeedBinding
    private val viewModel : MainFeedViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater,R.layout.main_feed,container,false)
        binding.vm = viewModel
        binding.lifecycleOwner = this

        val feedRecyclerView = binding.recyclerView
        val feedAdapter = MainFeedAdapter(viewModel, 10)
        val layoutManager = LinearLayoutManager(feedRecyclerView.context)
        layoutManager.orientation = RecyclerView.VERTICAL
        feedRecyclerView.layoutManager
        feedRecyclerView.adapter = feedAdapter

        viewModel.getFeed()

        return binding.root
    }

}