package com.inandout.real_rider.RecyclerAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inandout.real_rider.data.TimeAttackUserUiState
import com.inandout.real_rider.databinding.ItemRankingBinding


class RVRankAdapter(
    val context: Context,
    val list : ArrayList<TimeAttackUserUiState>
) : RecyclerView.Adapter<RVRankAdapter.RankHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankHolder {
        val binding = ItemRankingBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return RankHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RankHolder, position: Int) {
        holder.binding.ivUser.setImageResource(list.get(position).imageId)
        holder.binding.tvRecord.setText(list.get(position).time)
        holder.binding.tvUserName.setText(list.get(position).name)
    }

    class RankHolder(val binding : ItemRankingBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}