package com.damir1488.myapplication.AccountHelper

import android.widget.Toast
import com.damir1488.myapplication.MainActivity
import com.google.firebase.auth.FirebaseUser

class AccountHelper(activity:MainActivity){

    private val act = activity
    fun signUpWithEmail(email:String,password:String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            act.mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {task ->
                if(task.isSuccessful){
                    task.result.user!!.sendEmailVerification()
                    Toast.makeText(act.applicationContext,"успешно",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(act.applicationContext,"хуй там",Toast.LENGTH_LONG).show()
                }
            }
        }

    }
    fun sendemailVerification(user: FirebaseUser){
        user.sendEmailVerification().addOnCompleteListener {
            if(it.isSuccessful){
                Toast.makeText(act.applicationContext,"успешно1",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(act.applicationContext,"нет",Toast.LENGTH_LONG).show()
            }
        }
    }
}