package com.example.flashlight

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        //animation
        //declare animation
        val common_button_flashlight_animation = AnimationUtils.loadAnimation(this, R.anim.common_button_flashlight)
        val gun_button_flashlight_animation = AnimationUtils.loadAnimation(this, R.anim.machine_gun_button_flashlight)

        // set animation
        normal.startAnimation(common_button_flashlight_animation)
        machine_gun.startAnimation(gun_button_flashlight_animation)


        normal.setOnClickListener {
            val intent = Intent(this, NormalFlashLightActivity::class.java)

            try {
                startActivity(intent)
            }catch (e: Exception) {
                Toast.makeText(this, "$e", Toast.LENGTH_SHORT).show()
            }
        }

        machine_gun.setOnClickListener {
            val intent = Intent(this, FlashlightMachineGunActivity::class.java)

            try {
                startActivity(intent)
            }catch (e: Exception) {
                Toast.makeText(this, "$e", Toast.LENGTH_SHORT).show()
            }
        }
    }
}