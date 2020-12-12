package com.example.flashlight

import android.annotation.SuppressLint
import android.content.Intent
import android.hardware.ConsumerIrManager
import android.os.Bundle
import android.os.Handler
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.BounceInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_welcome_page.*

class WelcomePage : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_page)

        Thread(Runnable {
            repeat(100) {
                pBar.incrementProgressBy(1)

                this@WelcomePage.runOnUiThread(java.lang.Runnable {
                    text_result_progress.text = "%$it"
                })

                Thread.sleep(15)
            }

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            this.finish()
        }).start()
    }
}