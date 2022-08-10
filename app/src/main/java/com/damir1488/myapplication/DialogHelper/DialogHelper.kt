package com.damir1488.myapplication.DialogHelper

import android.app.AlertDialog
import android.view.View
import com.damir1488.myapplication.AccountHelper.AccountHelper
import com.damir1488.myapplication.MainActivity
import com.damir1488.myapplication.R
import com.damir1488.myapplication.databinding.SignDialogBinding

class DialogHelper(activity: MainActivity) {

    private val act = activity
    private lateinit var binding:SignDialogBinding
    private val accHelper = AccountHelper(act)

    fun createSignDialog(index:Int){
        val builder = AlertDialog.Builder(act)
        binding = SignDialogBinding.inflate(act.layoutInflater)
        builder.setView(binding.root)
        if(index == SIGN_UP_STATE){
            binding.textView.text = act.resources.getString(R.string.ac_sign_up)
            binding.btSignUpIn.text = act.resources.getString(R.string.ac_sign_up)
        }else{
            binding.textView.text = act.resources.getString(R.string.ac_sign_in)
            binding.btSignUpIn.text = act.resources.getString(R.string.ac_sign_in)
            binding.btForgetP.visibility = View.VISIBLE
        }
        builder.show()

        binding.btSignUpIn.setOnClickListener {
            if(index == SIGN_UP_STATE){
                accHelper.signUpWithEmail(binding.editTextTextPersonName2.toString()
                    ,binding.editTextTextPersonName3.toString())
            }else{}
        }
    }


    companion object{
        const val SIGN_UP_STATE = 0
        const val SIGN_IN_STATE = 1
    }
}