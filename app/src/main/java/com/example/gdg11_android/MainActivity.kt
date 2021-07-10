package com.example.gdg11_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gdg11_android.exchange.ExchangeActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ex= Intent(this, ExchangeActivity::class.java)
        startActivity(ex)
    }
}