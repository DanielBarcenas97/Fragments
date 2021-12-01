package com.dan.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dan.fragments.databinding.FragmentSecondBinding
import com.dan.fragments.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private lateinit var mBinding: FragmentThirdBinding
    private var message:String? = null

    companion object {
        private const val MESSAGE = "message"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mBinding = FragmentThirdBinding.inflate(inflater, container, false)

        if(arguments != null){
            message = arguments?.get(MESSAGE).toString()
        }

        arguments?.takeIf { it.containsKey(MESSAGE) }?.apply {
            message = getString(MESSAGE).toString()
        }

        return mBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.tvMessage.text = message

    }



}