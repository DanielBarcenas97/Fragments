package com.dan.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dan.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , SecondFragment.FragmentToActivity {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val oneFragment = OneFragment.newInstance("Fragment 1")
        val secondFragment = SecondFragment.newInstance("Fragment 2")

        //supportFragmentManager.beginTransaction().apply {
        //    replace(R.id.fragment,oneFragment)
        //    commit()
        //}

        binding.btnFirstFragment.setOnClickListener{

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment,oneFragment)
                commit()
            }
        }

        binding.btnSecondFragment.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment,secondFragment)
                commit()
            }
        }
    }


    override fun communicate(comm: String?) {
        binding.tvActivity.text = comm
    }

}