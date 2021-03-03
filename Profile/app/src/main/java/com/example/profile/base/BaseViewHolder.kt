package com.example.profile.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder(binding: ViewBinding): RecyclerView.ViewHolder(binding.root) {

    abstract fun bindData(params:Any)


}