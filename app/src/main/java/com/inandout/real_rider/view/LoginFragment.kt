package com.inandout.real_rider.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.inandout.real_rider.R
import com.inandout.real_rider.databinding.FragmentLoginBinding

import com.inandout.real_rider.base.BaseFragment
import com.inandout.real_rider.util.changeColorPartOfTextView

class LoginFragment : BaseFragment<FragmentLoginBinding>(R.layout.fragment_login) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeColorPartOfTextView(binding.tvRealRider, 0, 1, Color.parseColor("#F31414"))
        changeColorPartOfTextView(binding.tvRealRider, 5, 6, Color.parseColor("#668E5B"))
        initListener()
    }

    private fun initListener() {
        binding.tvStartBtn.setOnClickListener {
            findNavController().navigateSafe(R.id.action_loginFragment_to_mainFragment)
        }
    }
}