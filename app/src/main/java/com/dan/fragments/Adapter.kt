package com.dan.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dan.fragments.databinding.ItemBinding
import com.dan.fragments.model.User

class Adapter( private val  items : MutableList<User>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = ItemBinding.inflate(LayoutInflater.from(parent.context))
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = items[position]
        val v = holder as ListViewHolder
        v.mBinding.tvName.text = user.name

        Glide
            .with(v.mBinding.root)
            .load(user.image)
            .into(v.mBinding.ivPhoto)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ListViewHolder(val mBinding :ItemBinding) : RecyclerView.ViewHolder(mBinding.root)

}