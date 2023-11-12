package com.inandout.real_rider

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.inandout.real_rider.util.hideSystemUI


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        hideSystemUI()
    }

    override fun onResume() {
        super.onResume()
        hideSystemUI()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        /**
         * hide status bar code start
         */
        val X = event.x.toInt()
        val Y = event.y.toInt()
        val eventaction = event.action
        if (Y < 400) {
            onWindowFocusChanged(true)
            //    Toast.makeText(this, "ACTION_DOWN AT COORDS " + "X: " + X + " Y: " + Y, Toast.LENGTH_SHORT).show();
        }

        /**
         * hide status bar code stop
         */
        return true
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)

        /**
         * hide status bar code start
         */
        Log.d("Focus debug", "Focus changed !")
        if (!hasFocus) {
            Log.d("Focus debug", "Lost focus !")
            val closeDialog = Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)
            sendBroadcast(closeDialog)
        }
        /**
         * hide status bar code stop
         */
    }
}