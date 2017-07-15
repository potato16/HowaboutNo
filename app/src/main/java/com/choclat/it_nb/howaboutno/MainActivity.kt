package com.choclat.it_nb.howaboutno

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity(), RtnRandFragment.RtnRandListener, YesNoFragment.YesNoFragmentListener {
    override fun sendsomethingyesno() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendsomething() {
       val rolladice = (Math.random()*4).toInt()
        when(rolladice){
            1 -> supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_rtn_container,YesNoFragment())
                    .addToBackStack(null).commit()
            2 -> supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_rtn_container,TakeSelfie())
                    .addToBackStack(null).commit()
            else -> Toast.makeText(applicationContext,"Nothing happen! Hmm",500).show()

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (findViewById(R.id.fragment_rtn_container) != null){
            if (savedInstanceState != null) return
        }
        supportFragmentManager.beginTransaction().add(R.id.fragment_rtn_container,RtnRandFragment()).commit()
    }
}
