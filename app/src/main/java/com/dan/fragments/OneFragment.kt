package com.dan.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dan.fragments.databinding.FragmentOneBinding

class OneFragment : Fragment() {

    private var mCallback: FragmentToActivity? = null

    companion object{
        private const val MESSAGE = "message"
        fun newInstance(message:String):OneFragment{
            val fragment = OneFragment()
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

    private var message : String? = null

    private lateinit var mBinding: FragmentOneBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mBinding = FragmentOneBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.takeIf { it.containsKey(MESSAGE) }?.apply {
            message = getString(MESSAGE).toString()
        }

        mBinding.tvFirstText.text = message


        mBinding.btnFirstFragment.setOnClickListener {
            mCallback?.communicate("Hola desde el fragmento 1")
        }

    }

}