package com.dan.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.dan.fragments.databinding.ActivityMain2Binding
import com.dan.fragments.databinding.ActivityMainBinding
import com.dan.fragments.datasource.DataSource

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private lateinit var gridLayoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        gridLayoutManager = GridLayoutManager(this,2)
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup(){
            override fun getSpanSize(position: Int): Int {
                return if (position % 3 == 0){2} else 1
            }
        }

        binding.recyclerView.layoutManager = gridLayoutManager

        val mAdapter = Adapter(DataSource.generatedList)
        binding.recyclerView.adapter = mAdapter



    }
}