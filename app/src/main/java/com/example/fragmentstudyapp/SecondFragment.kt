package com.example.fragmentstudyapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.fragmentstudyapp.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var changeFragmtBtn: Button
    private lateinit var showDialogBtn: Button
    private var counter = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentSecondBinding>(
            inflater,
            R.layout.fragment_second,
            container,
            false
        )

        binding.user = User("Jorge Gustav Gullart","55")

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        changeFragmtBtn = view.findViewById(R.id.change_fragmt_btn)
        showDialogBtn = view.findViewById(R.id.show_dialog_btn)

        changeFragmtBtn.setOnClickListener {
            when(counter){
                0->{
                    childFragmentManager.commit {
                        replace<InnerFragment>(R.id.second_fragment_container)
                        setReorderingAllowed(true)
                        addToBackStack("name") // name can be null
                    }
                    counter = 1
                }
                1->{
                    childFragmentManager.commit {
                        replace<MiddleInnerFragment>(R.id.second_fragment_container)
                        setReorderingAllowed(true)
                        addToBackStack("name") // name can be null
                    }
                    counter = 2
                }
                2->{
                    childFragmentManager.commit {
                        replace<LastInnerFragment>(R.id.second_fragment_container)
                        setReorderingAllowed(true)
                        addToBackStack("name") // name can be null
                    }
                    counter = 0
                }
            }
        }

        showDialogBtn.setOnClickListener {
            DialogWindow().show(childFragmentManager,null)
        }
    }

}