package com.example.flashlight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import kotlinx.android.synthetic.main.activity_flashlight_machine_gun.*
import kotlinx.android.synthetic.main.activity_normal_flash_light.*
import com.example.flashlight.camera.CameraManaging
import com.google.android.material.slider.Slider

class FlashlightMachineGunActivity : AppCompatActivity() {

    val cameraManaging = CameraManaging(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashlight_machine_gun)

        setSupportActionBar(toolbar_gun)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "machine gun"

        var isTurnedon = false

        flashlight_buttong_gun.setOnClickListener {
            if (!isTurnedon) {
                Thread (Runnable {
                    cameraManaging.turnOnMachineGunFlashlight()
                    flashlight_buttong_gun.setIconTintResource(R.color.on)
                }).start()

                isTurnedon = true
            }
            else {
                cameraManaging.stopGun()
                flashlight_buttong_gun.setIconTintResource(R.color.off)

                isTurnedon = false
            }
        }

        flashlight_speed.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                cameraManaging.speed = progress
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
    }

    override fun onDestroy() {
        super.onDestroy()

        cameraManaging.stopGun()
    }
}