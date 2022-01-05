package com.nahar.studentmanagement

import android.graphics.Color
import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat

class SplashActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private lateinit var progressBarAnimation: ProgressBarAnimation
    private  var sharedPrefEmail: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        init()

        getSharedPrefValue()

        setProgressBarColor()

        setProgressing()

        animation()

    }

    private fun setProgressBarColor(){
        progressBar.progressDrawable.colorFilter=
            BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                Color.YELLOW,
                BlendModeCompat.SRC_IN
            )
    }
    private fun setProgressing(){
        progressBar.max = 100
        progressBar.scaleY = 3f
    }

    private fun animation(){
        progressBarAnimation = ProgressBarAnimation(this, progressBar, 0f, 100f, sharedPrefEmail)
        progressBarAnimation.duration = 5000
        progressBar.animation = progressBarAnimation
    }
    private fun getSharedPrefValue() {
        val sharedPreferences = getSharedPreferences("loginInfo", MODE_PRIVATE)
        sharedPrefEmail = sharedPreferences.getString("email", "").toString()
    }

    private fun init() {
        progressBar = findViewById(R.id.progressbar)
    }
}