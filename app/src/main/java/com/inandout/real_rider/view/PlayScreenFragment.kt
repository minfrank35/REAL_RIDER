package com.inandout.real_rider.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.inandout.real_rider.R
import com.inandout.real_rider.databinding.FragmentPlayScreenBinding

import com.inandout.real_rider.base.BaseFragment

class PlayScreenFragment : BaseFragment<FragmentPlayScreenBinding>(R.layout.fragment_play_screen) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
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