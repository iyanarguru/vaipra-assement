package com.vaipraa.assement.core

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.vaipraa.assement.core.presentation.activity.Meal
import com.vaipraa.assement.databinding.ItemMealBinding

class GenericAdapter<T>(
    itemList: List<T>?,
    private val layoutResId: Int,
    private val bind: (item: T, binding: ViewDataBinding) -> Unit,
    private val onItemClick: ((item: T) -> Unit)? = null
) : RecyclerView.Adapter<GenericAdapter<T>.ViewHolder>() {

    private var newItemList: List<T> = itemList ?: emptyList()

    inner class ViewHolder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: T) {
            bind(item, binding)

            if (binding is ItemMealBinding) binding.addButton.setOnClickListener {
                onItemClick?.invoke(item)
            } else {
                binding.root.setOnClickListener {
                    onItemClick?.invoke(item)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(inflater, layoutResId, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = newItemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(newItemList[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data: List<T>) {
        newItemList = data
        notifyDataSetChanged()
    }


}
