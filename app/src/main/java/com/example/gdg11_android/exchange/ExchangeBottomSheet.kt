package com.example.gdg11_android.exchange

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gdg11_android.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ExchangeBottomSheet : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v:View=inflater.inflate(R.layout.exchange_bottom_sheet,container,false)
        return v
    }



}