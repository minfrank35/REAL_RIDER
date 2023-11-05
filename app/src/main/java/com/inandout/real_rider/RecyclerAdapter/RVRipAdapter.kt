package com.inandout.real_rider.RecyclerAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inandout.real_rider.data.RaceInProgressUserUiState
import com.inandout.real_rider.data.TimeAttackUserUiState
import com.inandout.real_rider.databinding.ItemRaceInProgressBinding
import com.inandout.real_rider.databinding.ItemRankingBinding


class RVRipAdapter(
    val context: Context,
    val list : ArrayList<RaceInProgressUserUiState>
) : RecyclerView.Adapter<RVRipAdapter.RipHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RipHolder {
        val binding = ItemRaceInProgressBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return RipHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RipHolder, position: Int) {
        holder.binding.ivUser.setImageResource(list.get(position).imageId)
        holder.binding.tvRecord.setText(list.get(position).time)
        holder.binding.tvUserName.setText(list.get(position).name)
    }

    class RipHolder(val binding : ItemRaceInProgressBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}