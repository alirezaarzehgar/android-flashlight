package com.example.flashlight.camera

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Camera
import android.widget.Toast
import com.example.flashlight.MainActivity
import com.google.android.material.snackbar.Snackbar
import java.lang.Exception
import kotlin.concurrent.thread
import kotlin.properties.Delegates

class CameraManaging(val context: Context) {

    var cameraObject: Camera? = null
    var isFlashlightTurnedOn = false
    var speed: Int = 0
    private var continueGun: Boolean = true

    fun turnOnFlashlight() {
        try {
            if (context.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {
                cameraObject = Camera.open()

                val cameraParameters = cameraObject?.parameters
                cameraParameters?.flashMode = Camera.Parameters.FLASH_MODE_TORCH

                cameraObject?.parameters = cameraParameters
                cameraObject?.startPreview()

                isFlashlightTurnedOn = true
            }
        }
        catch (exception: Exception) {
            exception.stackTrace
            Toast.makeText(context, "try again", Toast.LENGTH_SHORT).show()
        }
    }

    fun turnOnMachineGunFlashlight() {
        continueGun = true

        thread {
            while (continueGun) {
                turnOnFlashlight()
                turnOfFlashlight()
                Thread.sleep((speed * 20).toLong())
            }
        }
    }

    fun stopGun() {
        continueGun = false
    }

    fun turnOfFlashlight() {
        if (isFlashlightTurnedOn) {
            cameraObject?.stopPreview()
            cameraObject?.release()

            cameraObject = null
            isFlashlightTurnedOn = false
        }
    }
}