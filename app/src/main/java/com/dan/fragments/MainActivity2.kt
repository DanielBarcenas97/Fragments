package com.dan.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.MergeAdapter
import com.dan.fragments.adapters.ListAdapter
import com.dan.fragments.adapters.FooterAdapter
import com.dan.fragments.adapters.HeaderAdapter
import com.dan.fragments.databinding.ActivityMain2Binding
import com.dan.fragments.datasource.DataSource
import com.dan.fragments.model.User
import java.util.ArrayList

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    //private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var layoutManager: LinearLayoutManager

    var list: MutableList<Any> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        //gridLayoutManager = GridLayoutManager(this,2)
        //gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup(){
        //    override fun getSpanSize(position: Int): Int {
        //        return if (position % 3 == 0){2} else 1
        //    }
        //}

        list.addAll(DataSource.generatedList)
        addAds()

        layoutManager = LinearLayoutManager(this)

        binding.recyclerView.layoutManager = layoutManager

        val headerAdapter = HeaderAdapter("This is Header Adapter")



        val mAdapter = ListAdapter(list)

        val footerAdapter = FooterAdapter("This is Footer Adapter")

        val mergeAdapter = MergeAdapter(headerAdapter, mAdapter,footerAdapter)


        binding.recyclerView.adapter = mergeAdapter


    }


    fun addAds() {

        list.add(0, "Anuncio")
        list.add(2, "Anuncio")
        list.add(4, "Anuncio")
        list.add(6, "Anuncio")
        list.add(8, "Anuncio")
        list.add(10, "Anuncio")



    }

}