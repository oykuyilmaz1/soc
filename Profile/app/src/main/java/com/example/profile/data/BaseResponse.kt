package com.example.profile.data

open class BaseResponse {
    lateinit var status: Status
}

data class Status(
    val success: Boolean,
    val reason: String
)