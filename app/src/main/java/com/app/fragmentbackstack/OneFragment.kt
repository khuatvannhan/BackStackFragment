package com.app.fragmentbackstack

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_one.*


class OneFragment : Fragment() {
    private val TAG = javaClass.simpleName
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onResume() {
        super.onResume()
        fragmentManager?.fragments?.forEach {
            Log.e(TAG, "Fragment exists is ${it.javaClass.simpleName}")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {
            val fragmentTwo = TwoFragment()
            val fragmentTransaction = fragmentManager?.beginTransaction()
            val tag = TwoFragment::class.java.name
            fragmentTransaction?.add(R.id.contentFragment, fragmentTwo, tag)
            fragmentTransaction?.addToBackStack("2")
            fragmentTransaction?.commit()
        }
        textView.setOnClickListener {
            Log.e(TAG, "Fragment exists is ${ fragmentManager?.fragments?.size}")
            fragmentManager?.fragments?.forEach {
                Log.e(TAG, "Fragment exists is ${it.javaClass.simpleName}")
            }
        }
    }
}
