package com.dan.fragments.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dan.fragments.databinding.FooterBinding

class FooterAdapter(private val footer: String) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FooterViewHolder(FooterBinding.inflate(LayoutInflater.from(parent.context)))
    }

    class FooterViewHolder(val mBinding: FooterBinding) : RecyclerView.ViewHolder(mBinding.root)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val v = holder as FooterViewHolder

        v.mBinding.footerText.text = footer
    }

    override fun getItemCount(): Int = 1

}
