package com.example.gdg11_android.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.gdg11_android.R
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
        return binding.root
    }
}