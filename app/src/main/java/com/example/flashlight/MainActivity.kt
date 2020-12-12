package com.example.flashlight

import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Color.YELLOW
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.hardware.Camera
import android.widget.Toast
import com.example.flashlight.camera.CameraManaging
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.button_layout.*
import java.lang.reflect.Parameter
import java.security.Policy

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

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