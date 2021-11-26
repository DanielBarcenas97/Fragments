package com.dan.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dan.fragments.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {


    private var mCallback: FragmentToActivity? = null
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


    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            mCallback =  context as FragmentToActivity
        }catch (e:Exception){
            e.printStackTrace()
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
            sendData()
        }
    }


    private fun sendData(){
        mCallback?.communicate("Hola desde el fragmento 2")
    }


    interface FragmentToActivity {
        fun communicate(comm: String?)
    }

}