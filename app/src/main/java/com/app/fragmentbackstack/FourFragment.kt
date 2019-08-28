package com.app.fragmentbackstack

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.fragment_four.*

class FourFragment : Fragment() {
    private val TAG = javaClass.simpleName

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_four, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragmentList = fragmentManager?.fragments

        button1.setOnClickListener {
            // Goto Root
            /* val fragmentTransaction = fragmentManager?.beginTransaction()
             fragmentList?.forEach { fragment ->
                 if (fragment.javaClass.name != OneFragment::class.java.name &&
                         fragment.javaClass.name != FourFragment::class.java.name) {
                     fragmentTransaction?.remove(fragment)
                 }
             }
             fragmentTransaction?.commit()
             fragmentManager?.fragments?.forEach {
                 Log.e(TAG, "Fragment exists is ${it.javaClass.simpleName}")
             }*/

            fragmentManager?.popBackStack("3", FragmentManager.POP_BACK_STACK_INCLUSIVE)
//            fragmentManager?.popBackStackImmediate()
        }
        button2.setOnClickListener {
            val fragmentTransaction = fragmentManager?.beginTransaction()
            fragmentList?.forEach { fragment ->
                if (fragment.javaClass.name == ThreeFragment::class.java.name) {
                    fragmentTransaction?.remove(fragment)
                }
            }
            fragmentTransaction?.commit()
            fragmentManager?.fragments?.forEach {
                Log.e(TAG, "Fragment exists is ${it.javaClass.simpleName}")
            }
            fragmentManager?.popBackStack()
        }

        button3.setOnClickListener {
            fragmentManager?.popBackStack()
        }
    }
}
