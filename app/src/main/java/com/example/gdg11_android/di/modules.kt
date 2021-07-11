package com.example.gdg11_android.di

import com.example.gdg11_android.activity.MainActivity
import com.example.gdg11_android.adapter.MainFeedAdapter
import com.example.gdg11_android.base.BaseApi
import com.example.gdg11_android.fragment.MainFeedFragment
import com.example.gdg11_android.pref.LocalStorage
import com.example.gdg11_android.pref.SharedPrefStorage
import com.example.gdg11_android.viewmodel.MainFeedViewModel
import com.example.gdg11_android.viewmodel.MainViewModel
import com.example.gdg11_android.viewmodel.MyPageViewModel
import com.example.gdg11_android.viewmodel.TradeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val modules = module {
    single{ BaseApi() }


    single { MainActivity() }
    single{}
    single { MainFeedAdapter(get(),get()) }

    single { MainFeedFragment() }

    single <LocalStorage>{ SharedPrefStorage(get()) }

    viewModel { MainViewModel(get(),get()) }
    viewModel { MainFeedViewModel(get(),get(),get()) }
    viewModel { TradeViewModel() }
    viewModel { MyPageViewModel() }
}