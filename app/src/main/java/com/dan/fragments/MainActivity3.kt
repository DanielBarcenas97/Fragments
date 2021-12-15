package com.dan.fragments

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.dan.fragments.databinding.ActivityMain3Binding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity3 : FragmentActivity() {

    private lateinit var binding: ActivityMain3Binding

    private lateinit var mAdapter : ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        mAdapter = ViewPagerAdapter(this)

        binding.vpPhotos.adapter = mAdapter


        val tabLayoutMediator = TabLayoutMediator(binding.tabs, binding.vpPhotos,TabLayoutMediator.TabConfigurationStrategy{ tab,position ->
            when(position){
                0 -> {
                    tab.text = "VP 1"
                }
                1 ->{
                    tab.text = "VP 2"
                }
            }
        })

        tabLayoutMediator.attach()

    }
}