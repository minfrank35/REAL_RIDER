package com.inandout.real_rider.live

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

private const val RTSP_REQUEST_KEY = "rtsp_request"

private const val DEFAULT_RTSP_REQUEST = "rtsp://10.0.1.3:554/axis-media/media.amp"

private const val LIVE_PARAMS_FILENAME = "live_params"
class LiveViewModel : ViewModel() {

    companion object {
        private val TAG: String = LiveViewModel::class.java.simpleName
        private const val DEBUG = false
    }

    val rtspRequest = MutableLiveData<String>().apply {
        value = DEFAULT_RTSP_REQUEST
    }

    fun loadParams(context: Context) {
        if (DEBUG)
            Log.v(TAG, "loadParams()")
        val pref = context.getSharedPreferences(LIVE_PARAMS_FILENAME, Context.MODE_PRIVATE)
        try {
            rtspRequest.setValue(pref.getString(RTSP_REQUEST_KEY, DEFAULT_RTSP_REQUEST))
        } catch (e: ClassCastException) {
            e.printStackTrace()
        }
    }

    fun saveParams(context: Context) {
        if (DEBUG) Log.v(TAG, "saveParams()")
        val editor = context.getSharedPreferences(LIVE_PARAMS_FILENAME, Context.MODE_PRIVATE).edit()
        editor.putString(RTSP_REQUEST_KEY, rtspRequest.value)
        editor.apply()
    }

}