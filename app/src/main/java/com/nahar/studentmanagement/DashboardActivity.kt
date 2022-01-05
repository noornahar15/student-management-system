package com.nahar.studentmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.widget.Toolbar

class DashboardActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var profileLayout: LinearLayout
    private lateinit var settingsLayout: LinearLayout
    private lateinit var notificationLayout: LinearLayout
    private lateinit var helpLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        toolbar = findViewById(R.id.toolbar)
        profileLayout = findViewById(R.id.profile_layout)
        settingsLayout = findViewById(R.id.settings_layout)
        notificationLayout = findViewById(R.id.notification_layout)
        helpLayout = findViewById(R.id.help)

        customToolbar()


        profileLayout.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        settingsLayout.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        notificationLayout.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        helpLayout.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }

    private fun customToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Sms."
    }

}