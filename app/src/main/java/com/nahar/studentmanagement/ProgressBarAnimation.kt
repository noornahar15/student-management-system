package com.nahar.studentmanagement

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.ProgressBar

class ProgressBarAnimation(
    private val context: Context,
    private val progressBar: ProgressBar,
    private val from: Float,
    private val to: Float,
    private val email: String

) :
    Animation() {
    @SuppressLint("SetTextI18n")
    override fun applyTransformation(
        interpolatedTime: Float,
        t: Transformation
    ) {
        super.applyTransformation(interpolatedTime, t)
        val value = from + (to - from) * interpolatedTime
        progressBar.progress = value.toInt()

        if (value == to) {
            if (email.isEmpty()) {
                goToLoginPage()

            } else {
                goToDashboardPage()
            }
        }
    }

    private fun goToLoginPage() {
        context.startActivity(
            Intent(context, LoginActivity::class.java).addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            )
        )
    }

    private fun goToDashboardPage() {
        context.startActivity(
            Intent(context, DashboardActivity::class.java).addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            )
        )
    }
}
