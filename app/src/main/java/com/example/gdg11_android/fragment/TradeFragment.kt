package com.example.gdg11_android.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gdg11_android.R
import com.example.gdg11_android.adapter.MainFeedAdapter
import com.example.gdg11_android.adapter.TradeIngAdapter
import com.example.gdg11_android.adapter.TradeRequestAdapter
import com.example.gdg11_android.adapter.TradeResponseAdapter
import com.example.gdg11_android.databinding.TradeListBinding
import com.example.gdg11_android.viewmodel.TradeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TradeFragment : Fragment(){
    lateinit var binding : TradeListBinding
    private val viewModel : TradeViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater,R.layout.trade_list,container,false)
        binding.vm = viewModel
        binding.lifecycleOwner = this

        val responseRecyclerView = binding.responseRecycler
        val tradeResponseAdapter = TradeResponseAdapter(viewModel)
        val responseLayoutManager = LinearLayoutManager(responseRecyclerView.context)
        responseLayoutManager.orientation = RecyclerView.VERTICAL
        responseRecyclerView.layoutManager
        responseRecyclerView.adapter = tradeResponseAdapter

        val requestRecyclerView = binding.requestRecycler
        val tradeRequestAdapter = TradeRequestAdapter(viewModel)
        val requestLayoutManager = LinearLayoutManager(requestRecyclerView.context)
        requestLayoutManager.orientation = RecyclerView.VERTICAL
        requestRecyclerView.layoutManager
        requestRecyclerView.adapter = tradeRequestAdapter

        val requestIngRecyclerView = binding.ingRecycler
        val tradeIngAdapter = TradeIngAdapter(viewModel)
        val layoutManager = LinearLayoutManager(requestIngRecyclerView.context)
        layoutManager.orientation = RecyclerView.VERTICAL
        requestIngRecyclerView.layoutManager
        requestIngRecyclerView.adapter = tradeIngAdapter

        return binding.root
    }
}