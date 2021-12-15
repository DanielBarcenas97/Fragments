package com.dan.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.dan.fragments.databinding.FragmentPhotoBinding


class PhotoFragment: Fragment() {

    private lateinit var  mBinding : FragmentPhotoBinding

    private var photo: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentPhotoBinding.inflate(LayoutInflater.from(inflater.context))
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.takeIf { it.containsKey(PHOTO_URL) }?.apply {
            photo = getString(PHOTO_URL).toString()
        }


        Glide.with(requireContext()).load(photo).into(mBinding.ivPhoto)
    }

    companion object {
        private const val PHOTO_URL = "photo"
        fun newInstance(url : String) : PhotoFragment{
            val fragment = PhotoFragment()
            val arg = Bundle()
            arg.putString(PHOTO_URL,url)
            fragment.arguments = arg
            return fragment
        }
    }
}