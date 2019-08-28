package com.app.fragmentbackstack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val fragmentOne = OneFragment()

        fragmentTransaction.add(R.id.contentFragment, fragmentOne, OneFragment::class.simpleName)
        fragmentTransaction.commit()
    }
}
