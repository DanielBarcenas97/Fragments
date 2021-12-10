package com.dan.fragments.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dan.fragments.databinding.HeaderBinding

class HeaderAdapter(private val header : String) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HeaderViewHolder(HeaderBinding.inflate(LayoutInflater.from(parent.context)))
    }

    class HeaderViewHolder(val mBinding: HeaderBinding) : RecyclerView.ViewHolder(mBinding.root)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = holder as HeaderViewHolder
        view.mBinding.headerText.text = header
    }

    override fun getItemCount(): Int = 1

}

