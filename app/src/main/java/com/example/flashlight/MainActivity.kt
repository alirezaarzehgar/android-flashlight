package com.example.flashlight

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

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