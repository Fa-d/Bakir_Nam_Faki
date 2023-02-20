package com.kolpolok.nord.ui.dashboard.bottomsheet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.kolpolok.nord.R
import com.kolpolok.nord.databinding.ItemviewServerSubBinding

class ServerSubAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val dataList: MutableList<String> = mutableListOf()
    var onDistrictSelectionClick: ((position: Int, model: String) -> Unit)? = null
    private var checkedItemPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItemviewServerSubBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            val model = dataList[position]
            val binding = holder.binding
            binding.radionIcon.isChecked = position == checkedItemPosition
        }
    }

    inner class ViewHolder(val binding: ItemviewServerSubBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.starIcon.setOnClickListener {
                binding.starIcon.setColorFilter(
                    ContextCompat.getColor(
                        binding.starIcon.context, R.color.goldenStar
                    )
                )
            }
            binding.root.setOnClickListener {
                checkedItemPosition = absoluteAdapterPosition
                notifyDataSetChanged()
            }
        }
    }

    fun initLoad(list: List<String>) {
        dataList.clear()
        dataList.addAll(list)
        notifyDataSetChanged()
    }
}