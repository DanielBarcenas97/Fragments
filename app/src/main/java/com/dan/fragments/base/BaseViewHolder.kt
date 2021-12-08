package com.dan.fragments.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView


class BaseViewHolder<T> {
    abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: T,position:Int)
    }
}