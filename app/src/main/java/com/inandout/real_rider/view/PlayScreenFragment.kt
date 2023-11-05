package com.inandout.real_rider.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    }
}