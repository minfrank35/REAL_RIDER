package com.inandout.real_rider.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.inandout.real_rider.R
import com.inandout.real_rider.RecyclerAdapter.RVRankAdapter
import com.inandout.real_rider.RecyclerAdapter.RVRipAdapter
import com.inandout.real_rider.databinding.FragmentPlayResultBinding

import com.inandout.real_rider.base.BaseFragment
import com.inandout.real_rider.data.RaceInProgressUserUiState
import com.inandout.real_rider.data.TimeAttackUserUiState
import java.util.*

class PlayResultFragment : BaseFragment<FragmentPlayResultBinding>(R.layout.fragment_play_result) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        initRecyclerView()
    }

    private fun initListener() {
        binding.commTitleBarPlayResult.setOnBackButtonListener {
            findNavController().popBackStack()
        }
    }

    private fun initRecyclerView() {

        val list : ArrayList<RaceInProgressUserUiState> = ArrayList()
        list.add(RaceInProgressUserUiState(name = "짱구", imageId = R.drawable.ic_launcher_foreground, time = "01:20:23"))
        list.add(RaceInProgressUserUiState(name = "짱구", imageId = R.drawable.ic_launcher_foreground, time = "01:20:23"))
        list.add(RaceInProgressUserUiState(name = "짱구", imageId = R.drawable.ic_launcher_foreground, time = "01:20:23"))
        list.add(RaceInProgressUserUiState(name = "짱구", imageId = R.drawable.ic_launcher_foreground, time = "01:20:23"))
        list.add(RaceInProgressUserUiState(name = "짱구", imageId = R.drawable.ic_launcher_foreground, time = "01:20:23"))

        binding.rvRaceResult.adapter = RVRipAdapter(requireContext(), list)
    }
}