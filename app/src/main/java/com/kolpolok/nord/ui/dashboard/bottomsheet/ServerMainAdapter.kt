package com.kolpolok.nord.ui.dashboard.bottomsheet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kolpolok.nord.databinding.ItemviewServerMainBinding

class ServerMainAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val dataList: MutableList<List<String>> = mutableListOf()
    private var currentlySelectedItemPos = -1
    var onDistrictSelectionClick: ((position: Int, model: String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItemviewServerMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            val model = dataList[position]
            val binding = holder.binding
            val innerItem = ServerSubAdapter()
            with(binding.subserversRecycler) {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this.context)
                adapter = innerItem
            }
            innerItem.initLoad(model)
            if (position == currentlySelectedItemPos) {
                if (binding.subserversRecycler.visibility == View.VISIBLE) {
                    binding.arrowIcon.rotation = -90.0f
                    binding.subserversRecycler.visibility = View.GONE
                } else {
                    binding.arrowIcon.rotation = 90.0f
                    binding.subserversRecycler.visibility = View.VISIBLE
                }
            } else {
                binding.arrowIcon.rotation = -90.0f
                binding.subserversRecycler.visibility = View.GONE
            }
        }
    }

    inner class ViewHolder(val binding: ItemviewServerMainBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                currentlySelectedItemPos = absoluteAdapterPosition
                notifyDataSetChanged()
            }
        }
    }

    fun initLoad(list: List<List<String>>) {
        dataList.clear()
        dataList.addAll(list)
        notifyDataSetChanged()
    }
}