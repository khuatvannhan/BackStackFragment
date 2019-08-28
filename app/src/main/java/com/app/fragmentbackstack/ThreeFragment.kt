package com.app.fragmentbackstack

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_three.*

class ThreeFragment : Fragment() {
    private val TAG = javaClass.simpleName

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_three, container, false)
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "Fragment exists is ${fragmentManager?.fragments?.size}")
        fragmentManager?.fragments?.forEach {
            Log.e(TAG, "Fragment exists is ${it.javaClass.simpleName}")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button1.setOnClickListener {
         /*   val fragmentTransaction = fragmentManager?.beginTransaction()
            //            Three -> One
            val fragmentList = fragmentManager?.fragments
            fragmentList?.forEach { fragment ->
                if (fragment.javaClass.name == TwoFragment::class.java.name) {
                    fragmentTransaction?.remove(fragment)
                }
            }
            fragmentTransaction?.commit()*/
            Log.e(TAG, "Fragment exists is ${fragmentManager?.fragments?.size}")
            fragmentManager?.fragments?.forEach {
                Log.e(TAG, "Fragment exists is ${it.javaClass.simpleName}")
            }
//            fragmentManager?.popBackStack()
        }
        button2.setOnClickListener {
            fragmentManager?.popBackStack()
        }
        button3.setOnClickListener {
            val fragmentTransaction = fragmentManager?.beginTransaction()
            val fourFragment = FourFragment()
            val tag = ThreeFragment::class.java.name
            fragmentTransaction?.add(R.id.contentFragment, fourFragment, tag)
            fragmentTransaction?.addToBackStack(tag)
            fragmentTransaction?.commit()
        }
    }
}
