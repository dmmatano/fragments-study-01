package com.example.fragmentstudyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //podemos add o fragment na view usando isso no xml da activity:
        //android:name="com.example.fragmentstudyapp.MainFragment"
        //ou add programaticamente usando o código abaixo...
        //o laço condicional garante que o fragment será add apenas na primeira
        //vez que a activity for criada.
        if (savedInstanceState == null) {
            val bundle = bundleOf("some_int" to 0) //usado caso queira passar dados ao fragmt
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<MainFragment>(R.id.fragment_container_view, args = bundle)
            }
        }
    }

    /** Sobre o fragment manager:
     * Local: Host Activity ... supportFragmentManager ---> FragmentManager da activity (FragmentActivity)
     * Local: Host Fragment ... parentFragmentManager ---> FragmentManager da activity
     * Local: Host Fragment ... childFragmentManager ---> FragmentManager dele mesmo (Host Fragment)
     * Local: Child Fragments ... parentFragmentManager ---> FragmentManager do Host Fragment
     */
}