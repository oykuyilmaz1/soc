package com.example.profile.data

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.POST

interface InitialApi {

    @POST("v1/ping")
    suspend fun ping(): Response<BaseResponse>

}