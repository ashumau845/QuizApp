package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        firebaseAuth=FirebaseAuth.getInstance()

        btnlogin.setOnClickListener {
            signupuser()
        }

        txtsignup.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }
    }

    private fun signupuser(){
        val email=etemail.text.toString()
        val password=etPassword.text.toString()
        val confirmpassword=etconfirmPassword.text.toString()

       if(email.isBlank()||password.isBlank()||confirmpassword.isBlank()){
           Toast.makeText(applicationContext,"Email and Password can't be blank",Toast.LENGTH_SHORT).show()
       }

       if(password!=confirmpassword){
           Toast.makeText(applicationContext,"Password and Confirm Password do not match",Toast.LENGTH_SHORT).show()
       }

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this){
                    if(it.isSuccessful){
                        Toast.makeText(applicationContext,"Successful Login",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(applicationContext,"Error in creating user.",Toast.LENGTH_SHORT).show()
                    }
                }
    }
}