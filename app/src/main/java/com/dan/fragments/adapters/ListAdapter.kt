package com.dan.fragments.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dan.fragments.constants.Constants.VIEW_TYPE_AD
import com.dan.fragments.constants.Constants.VIEW_TYPE_ITEM
import com.dan.fragments.databinding.AdsBinding
import com.dan.fragments.databinding.ItemBinding
import com.dan.fragments.model.User

class ListAdapter(private val  items : MutableList<Any>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_AD ->{
                val view = AdsBinding.inflate(LayoutInflater.from(parent.context))
                AdsViewHolder(view)
            }
            VIEW_TYPE_ITEM -> {
                val view = ItemBinding.inflate(LayoutInflater.from(parent.context))
                ListViewHolder(view)
            }
            else -> {
                val view = ItemBinding.inflate(LayoutInflater.from(parent.context))
                ListViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(getItemViewType(position)){
            VIEW_TYPE_AD ->{
                val user = items[position]
                val v = holder as AdsViewHolder
            }

            VIEW_TYPE_ITEM ->{

                val user = items[position] as User
                val v = holder as ListViewHolder
                v.mBinding.tvName.text = user.name

                Glide
                    .with(v.mBinding.root)
                    .load(user.image)
                    .into(v.mBinding.ivPhoto)
            }
        }




    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ListViewHolder(val mBinding :ItemBinding) : RecyclerView.ViewHolder(mBinding.root)

    class AdsViewHolder(val mBinding : AdsBinding) : RecyclerView.ViewHolder(mBinding.root)

    override fun getItemViewType(position: Int): Int {
        return if(position % 2 == 0){
            VIEW_TYPE_AD
        }else{
            VIEW_TYPE_ITEM
        }
    }

}