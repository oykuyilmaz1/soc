package com.example.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.profile.base.BaseViewModel
import com.example.profile.data.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

//Viewmodelinhject is depreciated

@HiltViewModel
class MainViewModel@Inject constructor(
    private val repository: MainRepository,
    @Named("str_try") private val str:String
) : BaseViewModel() {

    private val _pingResponse:MutableLiveData<Resource<String>> = MutableLiveData()
    val pingResponse: LiveData<Resource<String>> = _pingResponse
    init {
        Log.d("ViewModel", "string try is $str")
//        repository
    }
    fun startPing(){
        _pingResponse.value = Resource.Loading()
        viewModelScope.launch(Dispatchers.IO) {
            delay(1000L)
            when(repository.startPinging()){
                is Resource.Success -> _pingResponse.postValue(Resource.Success("Successfully pinged"))
                is Resource.Error -> _pingResponse.postValue(Resource.Error("Something went wrong"))
                else -> Unit
            }
        }
    }



}