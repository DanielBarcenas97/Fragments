package com.dan.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dan.fragments.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var mBinding: FragmentSecondBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mBinding = FragmentSecondBinding.inflate(inflater, container, false)
        return mBinding.root
    }

}