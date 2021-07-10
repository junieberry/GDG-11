package com.example.gdg11_android.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.gdg11_android.R
import com.example.gdg11_android.databinding.ActivityMainBinding
import com.example.gdg11_android.fragment.MainFeedFragment
import com.example.gdg11_android.fragment.MyPageFragment
import com.example.gdg11_android.fragment.TradeFragment
import com.example.gdg11_android.viewmodel.MainFeedViewModel
import com.example.gdg11_android.viewmodel.MainViewModel
import com.example.gdg11_android.viewmodel.MyPageViewModel
import com.example.gdg11_android.viewmodel.TradeViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {


    lateinit var binding : ActivityMainBinding
    private val viewModel : MainViewModel by viewModel()

    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.vm = viewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)
        bottomNavigationView = findViewById(R.id.bottom_navi)
        changeFragment(MainFeedFragment())

        bottomNavigateBar()
    }
    fun bottomNavigateBar(){
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> changeFragment(MainFeedFragment())
                R.id.nav_deal ->changeFragment(TradeFragment())
                else -> changeFragment(MyPageFragment())
            }
        }
    }


    private fun changeFragment(fragment: Fragment): Boolean {
        supportFragmentManager .beginTransaction()
            .replace(R.id.main_viewpager, fragment)
            .commit()
        return true
    }
}