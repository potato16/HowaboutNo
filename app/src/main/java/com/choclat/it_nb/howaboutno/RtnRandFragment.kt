package com.choclat.it_nb.howaboutno


import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import java.util.concurrent.ThreadLocalRandom


/**
 * A simple [Fragment] subclass.
 */
class RtnRandFragment : Fragment() {

    interface RtnRandListener {
        fun sendsomething()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_rtn_rand, container, false)
    }

     override fun onStart() {
         val sharedPref = activity.getSharedPreferences(getString(R.string.prefence_file_key),Context.MODE_PRIVATE)
         val default_color = Color.BLACK
         val default_value_text = "00"
         val color_saved = sharedPref.getInt(getString(R.string.saved_text_color), default_color)
         val text_value_saved = sharedPref.getString(getString(R.string.saved_text_value),default_value_text)
         val txtShow = view!!.findViewById<TextView>(R.id.txtShow)
         txtShow.setTextColor(color_saved)
         txtShow.text = text_value_saved
         view!!.findViewById<View>(R.id.frg_rtn_rand).setBackgroundColor(-16777217-color_saved)
        super.onStart()
         view!!.findViewById<Button>(R.id.btnRun).isEnabled = false
        /*view!!.findViewById<Button>(R.id.btnRun).setOnClickListener {
           // val ranNum = ThreadLocalRandom.current().nextInt(0,17)
            var txtShow = view!!.findViewById<TextView>(R.id.txtShow)
            val r_value = (Math.random()*255).toInt()
            val g_value = (Math.random()*255).toInt()
            val b_value = (Math.random()*255).toInt()
            val ran_value = (Math.random()).toString().substring(2,4)
            view!!.findViewById<View>(R.id.frg_rtn_rand).setBackgroundColor(Color.rgb(r_value,g_value,b_value))
            txtShow.text = ran_value
            txtShow.setTextColor(Color.rgb(255-r_value,255-g_value,255-b_value))

        }*/

         view!!.findViewById<View>(R.id.frg_rtn_rand).setOnTouchListener(hahaTouch())
         view!!.findViewById<Button>(R.id.btn_rtn_gosomewhere).setOnClickListener {
             val rollAdice = (Math.random()*4).toInt()
             (activity as RtnRandListener).sendsomething()
         }
    }

    override fun onStop() {
        super.onStop()
        //val backgroundColor = view!!.findViewById<View>(R.id.frg_rtn_rand)
        val txtShow = view!!.findViewById<TextView>(R.id.txtShow)
        val textColor = txtShow.currentTextColor
        val textValue = txtShow.text
        val sharedRef = activity.getSharedPreferences(getString(R.string.prefence_file_key), Context.MODE_PRIVATE)
        val editor = sharedRef.edit()
        editor.putInt(getString(R.string.saved_text_color),textColor)
        editor.putString(getString(R.string.saved_text_value), textValue.toString())
        editor.commit()
    }
    class hahaTouch: View.OnTouchListener{
        override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
            val r_value = (Math.random()*255).toInt()
            val g_value = (Math.random()*255).toInt()
            val b_value = (Math.random()*255).toInt()
            var txtShow = p0!!.findViewById<TextView>(R.id.txtShow)
            val ran_value = (Math.random()).toString().substring(2,4)
            val color = Color.rgb(r_value,g_value,b_value)
            val color_re = Color.rgb(255-r_value,255-g_value,255-b_value)
            p0!!.setBackgroundColor(Color.rgb(r_value,g_value,b_value))
            txtShow.text = ran_value
            txtShow.setTextColor(Color.rgb(255-r_value,255-g_value,255-b_value))
           return true
        }

    }
}// Required empty public constructor
