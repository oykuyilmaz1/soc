package com.example.profile

import androidx.lifecycle.MutableLiveData
import com.example.profile.data.BaseResponse
import com.example.profile.data.InitialApi
import com.example.profile.data.Resource
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val api: InitialApi
){
    suspend fun startPinging():Resource<BaseResponse> {
        val response = api.ping()
        return if(response.isSuccessful){
            Resource.Success(response.body()!!)
        } else {
            Resource.Error(response.message())
        }
    }

}