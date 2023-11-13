package com.inandout.real_rider.view

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.inandout.real_rider.R
import com.inandout.real_rider.databinding.FragmentIntroBinding
import com.inandout.real_rider.base.BaseFragment

class IntroFragment : BaseFragment<FragmentIntroBinding>(R.layout.fragment_intro) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler().postDelayed({
            findNavControllerSafely()?.navigateSafe(R.id.action_introFragment_to_intro2Fragment)
        }, 3000) // 3초(3000밀리초) 지연
    }
}