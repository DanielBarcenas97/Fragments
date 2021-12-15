package com.dan.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    private val mFragmentList : MutableList<Fragment> = ArrayList()

    fun addFragment(fragment: Fragment){
        mFragmentList.add(fragment)
    }

    override fun getItemCount(): Int {
        return  mFragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return mFragmentList[position]
    }

}