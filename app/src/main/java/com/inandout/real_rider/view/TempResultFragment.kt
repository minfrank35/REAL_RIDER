package com.inandout.real_rider.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.inandout.real_rider.R
import com.inandout.real_rider.base.BaseFragment
import com.inandout.real_rider.databinding.FragmentTempResultBinding

class TempResultFragment : BaseFragment<FragmentTempResultBinding>(R.layout.fragment_temp_result) {
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
        binding.tvNextBtn.setOnClickListener {
            findNavController().navigate(R.id.action_tempResultFragment_to_playResultFragment)
        }
    }
}