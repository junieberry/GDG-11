package com.example.gdg11_android.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.gdg11_android.R
import com.example.gdg11_android.databinding.MyPageBinding
import com.example.gdg11_android.viewmodel.MyPageViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyPageFragment : Fragment() {
    lateinit var binding : MyPageBinding
    private val viewModel : MyPageViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding  = DataBindingUtil.inflate(inflater, R.layout.my_page, container, false)
        binding.vm = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }
}