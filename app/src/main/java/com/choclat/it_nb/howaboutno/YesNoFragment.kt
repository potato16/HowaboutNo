package com.choclat.it_nb.howaboutno


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


/**
 * A simple [Fragment] subclass.
 */
class YesNoFragment : Fragment() {

    interface YesNoFragmentListener{
        fun sendsomethingyesno()
    }
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_yes_no, container, false)
    }

    override fun onStart() {
        super.onStart()
        view!!.findViewById<Button>(R.id.btn_yn_another).setOnClickListener {
            val ran = (Math.random()*2).toInt()
            var textRan = ""
            when (ran){
                0 -> textRan = "No"
                1 -> textRan = "Yes"
                2 -> textRan = "Hmmm!"
            }
            view!!.findViewById<TextView>(R.id.txt_yes_no).text = textRan
        }
        view!!.findViewById<Button>(R.id.btn_yn_back).setOnClickListener {
            fragmentManager.popBackStack()
        }
    }

}// Required empty public constructor
