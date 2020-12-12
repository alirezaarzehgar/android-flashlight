package com.example.flashlight.camera

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Camera
import android.widget.Toast
import com.example.flashlight.MainActivity
import com.google.android.material.snackbar.Snackbar
import java.lang.Exception

class CameraManaging(val context: Context) {

    var cameraObject: Camera? = null
    var isFlashlightTurnedOn = false

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

    fun turnOfFlashlight() {
        if (isFlashlightTurnedOn) {
            cameraObject?.stopPreview()
            cameraObject?.release()

            cameraObject = null
            isFlashlightTurnedOn = false
        }
    }
}