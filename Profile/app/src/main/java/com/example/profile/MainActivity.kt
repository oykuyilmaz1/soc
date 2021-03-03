package com.example.profile

import android.widget.Toast
import androidx.activity.viewModels
import com.example.profile.base.BaseActivity
import com.example.profile.data.Resource
import com.example.profile.databinding.MainActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainActivityBinding, MainViewModel>() {

    override val viewModel:MainViewModel by viewModels()

    override fun getViewBinding() = MainActivityBinding.inflate(layoutInflater)

    override fun initialize() {
        viewModel.pingResponse.observe(this, {
            when (it) {
                is Resource.Success -> {
                    Toast.makeText(this, it.data, Toast.LENGTH_LONG).show()
                    dismissLoadingDialog()
                }
                is Resource.Error -> {
                    Toast.makeText(this, it.data, Toast.LENGTH_LONG).show()
                    dismissLoadingDialog()
                }
                is Resource.Loading -> showLoadingDialog()
                else -> Unit
            }
        })
//        lifecycleScope.launch {
            viewModel.startPing()
//        }
    }


}