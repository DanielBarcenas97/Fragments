package com.dan.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dan.fragments.databinding.FragmentOneBinding

class OneFragment : Fragment() {

    private lateinit var mBinding: FragmentOneBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mBinding = FragmentOneBinding.inflate(inflater, container, false)
        return mBinding.root
    }

}