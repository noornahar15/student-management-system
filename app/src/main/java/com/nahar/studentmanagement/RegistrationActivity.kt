package com.nahar.studentmanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.content.Intent
import java.util.regex.Pattern

class RegistrationActivity : AppCompatActivity() {
    private lateinit var nameEt: EditText
    private lateinit var emailEt: EditText
    private lateinit var passwordEt: EditText
    private lateinit var addressEt: EditText
    private lateinit var registrationBtn: Button
    private lateinit var emailPattern: Pattern

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        nameEt = findViewById(R.id.name_et)
        emailEt = findViewById(R.id.email_et)
        passwordEt = findViewById(R.id.password_et)
        addressEt = findViewById(R.id.address_et)
        registrationBtn = findViewById(R.id.registration_btn)
        emailPattern = Pattern.compile("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")

        registrationBtn.setOnClickListener {
            val name: String = nameEt.text.toString()
            val email: String = emailEt.text.toString()
            val password: String = passwordEt.text.toString()
            val address: String = addressEt.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && address.isNotEmpty()) {
                if (emailPattern.matcher(email).matches()) {

                    val intent = Intent(this, LoginActivity::class.java)
                    /*intent.putExtra("email", email)
                    intent.putExtra("password", password)
                    intent.putExtra("emailPattern", email)*/
                    startActivity(intent)

                    saveData(email, password)     //SharedPreferences save

                } else {
                    Toast.makeText(this, "Invalid email address", Toast.LENGTH_SHORT).show()
                }

            } else {
                Toast.makeText(this, "Please enter your information!", Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun saveData(email:String, password:String) {
        val sharedPreferences = getSharedPreferences("registrationInfo", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("email", email)
        editor.putString("password", password)
        editor.apply()
    }
}