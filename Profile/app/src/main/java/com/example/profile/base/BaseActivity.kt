package com.example.profile.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.example.profile.databinding.ProgressBarBinding


abstract class BaseActivity<B: ViewBinding, VM: BaseViewModel> : AppCompatActivity() {

    lateinit var binding: B
    lateinit var bindingProgressBar: ProgressBarBinding
    abstract val viewModel:VM



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        bindingProgressBar = ProgressBarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addContentView(bindingProgressBar.root, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT))
        initialize()
    }
    abstract fun getViewBinding(): B // B.inflate(layoutInflater)
    abstract fun initialize() //for options menu, nav bar, shared pref etc.

    fun showLoadingDialog() { bindingProgressBar.progressBar.visibility = View.VISIBLE}
    fun dismissLoadingDialog() { bindingProgressBar.progressBar.visibility = View.INVISIBLE}


}