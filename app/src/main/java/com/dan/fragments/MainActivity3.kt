package com.dan.fragments

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.dan.fragments.databinding.ActivityMain3Binding
import com.dan.fragments.datasource.DataSourceImg
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity3 : FragmentActivity() {

    private lateinit var binding: ActivityMain3Binding

    private lateinit var mAdapter : ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPhotos = DataSourceImg.generatedList

        mAdapter = ViewPagerAdapter(this)

        for(photo in listPhotos){
            mAdapter.addFragment(PhotoFragment.newInstance(photo))
        }


        binding.vpPhotos.adapter = mAdapter


        val tabLayoutMediator = TabLayoutMediator(binding.tabs, binding.vpPhotos) { _, _ -> }
        tabLayoutMediator.attach()

    }
}