package com.example.flashlight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flashlight.camera.CameraManaging
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_normal_flash_light.*

class NormalFlashLightActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal_flash_light)

        setSupportActionBar(toolbar_normal)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "common flashlight"

        val cameraManaging = CameraManaging(this)

        flashlight_buttong_normal.setOnClickListener {
            if (cameraManaging.isFlashlightTurnedOn) {
                cameraManaging.turnOfFlashlight()
                flashlight_buttong_normal.setIconTintResource(R.color.off)
            }
            else {
                cameraManaging.turnOnFlashlight()
                flashlight_buttong_normal.setIconTintResource(R.color.on)
            }
        }
    }
}