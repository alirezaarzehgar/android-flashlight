package com.example.flashlight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_flashlight_machine_gun.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_normal_flash_light.*

class FlashlightMachineGunActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashlight_machine_gun)

        setSupportActionBar(toolbar_gun)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "machine gun"
    }
}