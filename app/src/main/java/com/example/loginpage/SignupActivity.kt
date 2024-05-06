package com.example.loginpage

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.loginpage.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    lateinit var signupBinding: ActivitySignupBinding
    private var fileName="shredPref"
    private var email="username"
    private var password="password"
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        signupBinding = ActivitySignupBinding.inflate(layoutInflater)
        val view = signupBinding.root
        setContentView(view)

        signupBinding.regBtn.setOnClickListener {
            sharedPreferences = getSharedPreferences(fileName, MODE_PRIVATE)

            sharedPreferences.getString(email, "")
            sharedPreferences.getString(password, "")

            var fetchedEmail = signupBinding.emailEdit.text.toString()
            var fetchedPwd = signupBinding.pwdEdit.text.toString()

            var editor = sharedPreferences.edit()

            if (signupBinding.checkBox.isChecked) {
                editor.putString(email, fetchedEmail)
                editor.putString(password, fetchedPwd)

                editor.apply()
                Toast.makeText(this, "Registered", Toast.LENGTH_LONG).show()
            }
        }
        signupBinding.logBtn.setOnClickListener {
            val intent= Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}