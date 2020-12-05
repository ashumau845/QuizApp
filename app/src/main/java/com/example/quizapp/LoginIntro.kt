package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login_intro.*
import java.lang.Exception

class LoginIntro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_intro)

        val auth = FirebaseAuth.getInstance()
        if(auth.currentUser != null){
            Toast.makeText(this, "User is already logged in!", Toast.LENGTH_SHORT).show()
            redirect("MAIN")
        }
        btngetstarted.setOnClickListener{
            redirect("LOGIN")
        }


    }

    private fun redirect(name:String){
        startActivity( when(name){
            "LOGIN" -> Intent(this,LoginActivity::class.java)
            "MAIN"  -> Intent(this,MainActivity::class.java)
            else -> throw Exception("No Path Exists")
        })
        finish()
    }
}