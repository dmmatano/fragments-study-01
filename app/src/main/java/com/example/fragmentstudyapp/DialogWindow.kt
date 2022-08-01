package com.example.fragmentstudyapp

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogWindow: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setMessage(getString(R.string.u_are_amazing))
            .setPositiveButton(getString(R.string.ok)) { _,_ -> }
            .create()

}