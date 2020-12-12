package com.example.flashlight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flashlight.camera.CameraManaging
import kotlinx.android.synthetic.main.button_layout.*

class NormalFlashLightActivity : AppCompatActivity() {

    val cameraManaging = CameraManaging(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_normal_flash_light)
        flashlightButtong.setOnClickListener {
            if (cameraManaging.isFlashlightTurnedOn) {
                cameraManaging.turnOfFlashlight()
                flashlightButtong.setIconTintResource(R.color.off)
            }
            else {
                cameraManaging.turnOnFlashlight()
                flashlightButtong.setIconTintResource(R.color.on)
            }
        }

    }
}