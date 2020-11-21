package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        firebaseAuth= FirebaseAuth.getInstance()
        btnlogin.setOnClickListener{
            login()
        }
    }

    private fun login(){
        val email=etemail.text.trim().toString()
        val password=etPassword.text.trim().toString()

        if(email.isBlank() || password.isBlank()){
            Toast.makeText(this,"Email/password cannot be empty",Toast.LENGTH_SHORT).show()
            return
        }

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this){
            if(it.isSuccessful){
                Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Authentication Failed",Toast.LENGTH_SHORT).show()
            }
        }
    }
}