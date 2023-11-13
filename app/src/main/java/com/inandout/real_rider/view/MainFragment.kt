package com.inandout.real_rider.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.inandout.real_rider.R
import com.inandout.real_rider.databinding.FragmentMainBinding

import com.inandout.real_rider.base.BaseFragment

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {
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
        binding.commTitleBarMain.setOnBackButtonListener {
            findNavController().popBackStack()
        }
        binding.clClassic.setOnClickListener {
            findNavController().navigateSafe(R.id.action_mainFragment_to_singleReadyFragment)
        }
        binding.clArcade.setOnClickListener {
            findNavController().navigateSafe(R.id.action_mainFragment_to_singleReadyFragment)
        }
        binding.clTimeAttack.setOnClickListener {
            findNavController().navigateSafe(R.id.action_mainFragment_to_timeAttackReadyFragment)
        }
    }
}