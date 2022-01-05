package com.nahar.studentmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private lateinit var emailEt: EditText
    private lateinit var passwordEt: EditText
    private lateinit var loginBtn: Button
    private lateinit var clickTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailEt = findViewById(R.id.emailLog_et)
        passwordEt = findViewById(R.id.passwordLog_et)
        loginBtn = findViewById(R.id.login_btn)
        clickTv = findViewById(R.id.click_tv)

        val sharedPreferences = getSharedPreferences("registrationInfo", MODE_PRIVATE)
        val sharedPrefEmail = sharedPreferences.getString("email", "")
        val sharedPrefPassword = sharedPreferences.getString("password", "")

        loginBtn.setOnClickListener {
            val email: String = emailEt.text.toString()
            val password: String = passwordEt.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                if (email == sharedPrefEmail && password == sharedPrefPassword) {

                    val intent = Intent(this, DashboardActivity::class.java)
                    startActivity(intent)

                    saveData(email)

                    Toast.makeText(this, "Login successfully", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Email or password not mach", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Email or password not mach", Toast.LENGTH_LONG).show()
            }
        }

        clickTv.setOnClickListener() {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }

    private fun saveData(email: String) {
        val sharedPreferences = getSharedPreferences("loginInfo", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("email", email)
        editor.apply()
    }

}
