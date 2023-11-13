package com.inandout.real_rider.view

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.alexvas.rtsp.widget.RtspSurfaceView
import com.inandout.real_rider.R
import com.inandout.real_rider.databinding.FragmentPlayScreenBinding

import com.inandout.real_rider.base.BaseFragment
import com.inandout.real_rider.live.LiveViewModel

class PlayScreenFragment : BaseFragment<FragmentPlayScreenBinding>(R.layout.fragment_play_screen) {
    private lateinit var liveViewModel: LiveViewModel

    private val rtspStatusListener = object: RtspSurfaceView.RtspStatusListener {
        override fun onRtspStatusDisconnecting() {
            binding.apply {
            }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)

    }

    override fun onResume() {
        super.onResume()
        liveViewModel.loadParams(requireContext())
    }

    override fun onPause() {
        val started = binding.svVideo.isStarted()

        super.onPause()
        liveViewModel.saveParams(requireContext())

        if (started) {
            binding.svVideo.stop()
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        liveViewModel = ViewModelProvider(this).get(LiveViewModel::class.java)

        binding.svVideo.setStatusListener(rtspStatusListener)

        val uri = Uri.parse("rtsp://192.168.70.192:8080/h264.sdp")
        binding.svVideo.init(uri, null, null, "rtsp-client-android")
        binding.svVideo.start(true, true)
    }


    private fun initListener() {
        binding.ivLeftBtn.setOnClickListener {
            // TODO
        }

        binding.ivRightBtn.setOnClickListener {
            // TODO
        }

        binding.ivAccel.setOnClickListener {
            // TODO
            findNavController().navigate(R.id.action_playScreenFragment_to_tempResultFragment)
        }

        binding.ivBrake.setOnClickListener {
            // TODO
        }
    }
}