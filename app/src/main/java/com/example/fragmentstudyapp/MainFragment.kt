package com.example.fragmentstudyapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.fragmentstudyapp.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private val TAG ="MainFragmentLog"
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate() <-----------------------")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d(TAG,"onCreateView() <-----------------------")
        _binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val someInt = requireArguments().getInt("some_int")
        Log.d(TAG,"onViewCreate() bundle data of activity is: $someInt <-----------------------")

        binding.goToSecondBtn.setOnClickListener {
            parentFragmentManager.commit {
                replace<SecondFragment>(R.id.fragment_container_view)
                setReorderingAllowed(true)
                addToBackStack("name") // name can be null
            }
        }


    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d(TAG,"onViewStateRestored() <-----------------------")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart() <-----------------------")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume() <-----------------------")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause() <-----------------------")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG,"onSaveInstanceState() <-----------------------")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG,"onDestroyView() <-----------------------")
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        Log.d(TAG,"onDestroy() <-----------------------")
    }
}

