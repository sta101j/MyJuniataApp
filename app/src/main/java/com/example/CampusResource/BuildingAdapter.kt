package com.example.CampusResource

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.CampusResource.databinding.ItemBuildingBinding

class BuildingAdapter(
    private var list: List<Building>,
    private val onClick: (Building) -> Unit
) : RecyclerView.Adapter<BuildingAdapter.BuildingViewHolder>() {

    inner class BuildingViewHolder(val binding: ItemBuildingBinding)
        : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val pos = adapterPosition
                if (pos != RecyclerView.NO_POSITION) {
                    onClick(list[pos])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuildingViewHolder {
        val binding = ItemBuildingBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return BuildingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BuildingViewHolder, position: Int) {
        val item = list[position]
        holder.binding.tvCode.text = item.code
        holder.binding.tvName.text = item.name
    }

    override fun getItemCount() = list.size

    fun filter(newList: List<Building>) {
        list = newList
        notifyDataSetChanged()
    }
}
