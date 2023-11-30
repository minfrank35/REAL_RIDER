package com.inandout.real_rider.view

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.alexvas.rtsp.RtspClient
import com.alexvas.rtsp.widget.RtspSurfaceView
import com.alexvas.utils.NetUtils
import com.google.android.gms.common.api.internal.RemoteCall
import com.inandout.real_rider.R
import com.inandout.real_rider.databinding.FragmentPlayScreenBinding

import com.inandout.real_rider.base.BaseFragment
import com.inandout.real_rider.live.LiveViewModel
import java.util.concurrent.atomic.AtomicBoolean

class PlayScreenFragment : BaseFragment<FragmentPlayScreenBinding>(R.layout.fragment_play_screen) {
    var remonCall : RemonCall? = null
    //TODO :: RTSP 주석 처리
//    private lateinit var liveViewModel: LiveViewModel

//    val rtspClientListener = object: RtspClient.RtspClientListener {
//        override fun onRtspConnecting() {
//            Log.e("listener", "onRtspConnecting");
//        }
//        override fun onRtspConnected(sdpInfo: RtspClient.SdpInfo) {
//            Log.e("listener", "onRtspConnected");
//        }
//        override fun onRtspVideoNalUnitReceived(data: ByteArray, offset: Int, length: Int, timestamp: Long) {
//            Log.e("ONFRAMERECEIVED2", offset.toString());
//        }
//        override fun onRtspAudioSampleReceived(data: ByteArray, offset: Int, length: Int, timestamp: Long) {
//            // Send raw audio to decoder
//            Log.e("ONFRAMERECEIVED", offset.toString());
//        }
//
//        override fun onRtspDisconnecting() {
//            Log.e("listener", "onRtspDisconnecting");
//        }
//
//        override fun onRtspDisconnected() {
//            Log.e("listener", "onRtspDisconnected");
//        }
//        override fun onRtspFailedUnauthorized() {
//            Log.e("listener", "onRtspFailedUnauthorized");
//        }
//        override fun onRtspFailed(message: String?) {
//            Log.e("listener", "onRtspFailed '$message'")
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        //TODO :: RTSP 주석 처리
//        liveViewModel.loadParams(requireContext())
    }

    override fun onPause() {
        super.onPause()

        //TODO :: RTSP 주석 처리
//        val started = binding.svVideo.isStarted()
//
//        liveViewModel.saveParams(requireContext())
//
//        if (started) {
//            binding.svVideo.stop()
//        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()

        //TODO :: RTSP 주석 처리
//        liveViewModel = ViewModelProvider(this).get(LiveViewModel::class.java)
//
//        val uri = Uri.parse("rtsp://192.168.166.209:8080/h264.sdp")
//
//
//        binding.svVideo.init(uri, null, null, "rtsp-client-android")
//        binding.svVideo.setStatusListener(object : RtspSurfaceView.RtspStatusListener {
//            override fun onRtspStatusConnecting() {
//                super.onRtspStatusConnecting()
//            }
//
//            override fun onRtspStatusConnected() {
//                super.onRtspStatusConnected()
//            }
//
//            override fun onRtspStatusDisconnecting() {
//                super.onRtspStatusDisconnecting()
//            }
//
//            override fun onRtspStatusDisconnected() {
//                super.onRtspStatusDisconnected()
//            }
//
//            override fun onRtspStatusFailedUnauthorized() {
//                super.onRtspStatusFailedUnauthorized()
//            }
//
//            override fun onRtspStatusFailed(message: String?) {
//                super.onRtspStatusFailed(message)
//            }
//
//            override fun onRtspFirstFrameRendered() {
//                super.onRtspFirstFrameRendered()
//            }
//
//            override fun onRtspFrame(byteArray: ByteArray) {
//                super.onRtspFrame(byteArray)
//            }
//        })
//        binding.svVideo.start(true, true)
    }


    @SuppressLint("ClickableViewAccessibility")
    private fun initListener() {
        binding.ivLeftBtn.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: android.view.MotionEvent?): Boolean {
                when (event?.action) {
                    android.view.MotionEvent.ACTION_DOWN -> {
                        bluetoothThread.sendData("a")
                    }
                    android.view.MotionEvent.ACTION_UP -> {
                        bluetoothThread.sendData("z")

                    }
                }
                return true
            }
        })

        binding.ivRightBtn.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: android.view.MotionEvent?): Boolean {
                when (event?.action) {
                    android.view.MotionEvent.ACTION_DOWN -> {
                        bluetoothThread.sendData("d")
                    }
                    android.view.MotionEvent.ACTION_UP -> {
                        bluetoothThread.sendData("c")

                    }
                }
                return true
            }
        })

        binding.ivAccel.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: android.view.MotionEvent?): Boolean {
                when (event?.action) {
                    android.view.MotionEvent.ACTION_DOWN -> {
                        bluetoothThread.sendData("w")
                    }
                    android.view.MotionEvent.ACTION_UP -> {
                        bluetoothThread.sendData("m")
                    }
                }
                return true
            }
        })

        binding.ivBrake.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: android.view.MotionEvent?): Boolean {
                when (event?.action) {
                    android.view.MotionEvent.ACTION_DOWN -> {
                        bluetoothThread.sendData("s")
                    }
                    android.view.MotionEvent.ACTION_UP -> {
                        bluetoothThread.sendData("p")
                    }
                }
                return true
            }
        })
    }
}