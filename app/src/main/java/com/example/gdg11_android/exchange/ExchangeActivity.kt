package com.example.gdg11_android.exchange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.gdg11_android.databinding.ActivityExchangeBinding

class ExchangeActivity : AppCompatActivity() {
    lateinit var binding:ActivityExchangeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityExchangeBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


    fun plus_clicked(v:View){
        val plus_view= ExchangeBottomSheet()
        plus_view.show(supportFragmentManager,"plus_view")
    }
    fun o_clicked(v:View){
        success_dialog()
    }
    fun x_clicked(v:View){
        fail_dialog()

    }

    fun success_dialog(){
        SuccessDialog(context = this).start()
    }

    fun fail_dialog(){
        FailDialog(context = this).start()
    }
}