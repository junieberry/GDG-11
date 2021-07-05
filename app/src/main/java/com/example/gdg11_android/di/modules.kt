package com.example.gdg11_android.di

import com.example.gdg11_android.base.BaseApi
import org.koin.dsl.module

val modules = module {
    single{ BaseApi() }
}