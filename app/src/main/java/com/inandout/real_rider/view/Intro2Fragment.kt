package com.inandout.real_rider.view

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.res.colorResource
import androidx.navigation.fragment.findNavController
import com.inandout.real_rider.R
import com.inandout.real_rider.databinding.FragmentIntro2Binding
import com.inandout.real_rider.base.BaseFragment
import com.inandout.real_rider.util.changeColorPartOfTextView

class Intro2Fragment : BaseFragment<FragmentIntro2Binding>(R.layout.fragment_intro2) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeColorPartOfTextView(binding.tvIntro2RealRider, 0, 1, Color.parseColor("#F31414"))
        changeColorPartOfTextView(binding.tvIntro2RealRider, 5, 6, Color.parseColor("#668E5B"))
        Handler().postDelayed({
            findNavController()?.navigateSafe(R.id.action_intro2Fragment_to_loginFragment)
        }, 3000) // 3초(3000밀리초) 지연
    }
}