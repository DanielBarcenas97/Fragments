package com.dan.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.dan.fragments.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private var message : String? = null

    companion object{
        private const val MESSAGE = "message"

        fun newInstance(message:String):SecondFragment{
            val fragment = SecondFragment()
            val args = Bundle()
            args.putString(MESSAGE,message)
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var mBinding: FragmentSecondBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mBinding = FragmentSecondBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.takeIf { it.containsKey(MESSAGE) }?.apply {
            message = getString(MESSAGE).toString()
        }


        mBinding.tvSecondText.text = message

        mBinding.btnSecondFragment.setOnClickListener {
            sendMessage()
        }
    }

    private fun sendMessage() {

        if(!mBinding.etMessage.text.isNullOrEmpty()){
            val bundle = Bundle()
            bundle.putString(MESSAGE,mBinding.etMessage.text.toString())

            val fragment = ThirdFragment()
            fragment.arguments = bundle

            fragmentManager?.beginTransaction()?.apply {
                setCustomAnimations(R.anim.top_animation,0)
                replace(R.id.fragment,fragment)
                commit()
            }


        }else{
            Toast.makeText(requireContext(),"Escribe algo",Toast.LENGTH_SHORT).show()
        }

    }


}