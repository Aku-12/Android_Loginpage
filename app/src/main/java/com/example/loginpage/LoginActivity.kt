package com.example.loginpage

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginpage.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var activityLoginBinding: ActivityLoginBinding
    private var fileName="shredPref"
    private var email="username"
    private var password="password"
    private lateinit var sharedPreferences:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        activityLoginBinding=ActivityLoginBinding.inflate(layoutInflater)
        var view=activityLoginBinding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        sharedPreferences=getSharedPreferences(fileName, MODE_PRIVATE)
        val fetchedEmail=sharedPreferences.getString(email,"")
        val fetchedPassword=sharedPreferences.getString(password,"")

       activityLoginBinding.logBtn.setOnClickListener {
           val emailFieldValue=activityLoginBinding.emailEdit.text.toString()
           val pwdFieldValue=activityLoginBinding.pwdEdit.text.toString()
         if (emailFieldValue.equals(fetchedEmail)&&pwdFieldValue.equals(fetchedPassword)){
             Toast.makeText(this,"Login Sucessfully",Toast.LENGTH_LONG).show()
         }
       }
    }
}