package com.inandout.real_rider.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.inandout.real_rider.R
import com.inandout.real_rider.data.TimeAttackUserUiState
import com.inandout.real_rider.databinding.FragmentTimeAttackReadyBinding
import com.inandout.real_rider.decoration.RecyclerContentPaddingDecoration
import com.inandout.real_rider.RecyclerAdapter.RVRankAdapter

import com.inandout.real_rider.base.BaseFragment

class TimeAttackReadyFragment : BaseFragment<FragmentTimeAttackReadyBinding>(R.layout.fragment_time_attack_ready) {
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
        binding.commTitleBarMain.setOnBackButtonListener {
            findNavController().popBackStack()
        }
        binding.tvStartBtn.setOnClickListener {
            findNavController().navigate(R.id.playScreenFragment)
        }
    }

    private fun initRecyclerView() {

        val list : ArrayList<TimeAttackUserUiState> = ArrayList()
        list.add(TimeAttackUserUiState(name = "짱구", imageId = R.drawable.ic_launcher_foreground, time = "01:20:23"))
        list.add(TimeAttackUserUiState(name = "짱구", imageId = R.drawable.ic_launcher_foreground, time = "01:20:23"))
        list.add(TimeAttackUserUiState(name = "짱구", imageId = R.drawable.ic_launcher_foreground, time = "01:20:23"))
        list.add(TimeAttackUserUiState(name = "짱구", imageId = R.drawable.ic_launcher_foreground, time = "01:20:23"))
        list.add(TimeAttackUserUiState(name = "짱구", imageId = R.drawable.ic_launcher_foreground, time = "01:20:23"))

        binding.rvRanking.adapter = RVRankAdapter(requireContext(), list)
    }
}