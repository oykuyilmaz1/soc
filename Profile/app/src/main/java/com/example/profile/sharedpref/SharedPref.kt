package com.example.profile.sharedpref

import android.content.SharedPreferences
import javax.inject.Inject

//WRITE YOUR CONSTANTS HERE
// EXAMPLE private const val TOKEN = "Token"

class SharedPref @Inject constructor(
    private val sharedPref: SharedPreferences
):ISharedPref {

    override fun saveToken(token: String?) {
        TODO("EXAMPLE")
    }
    //implement members here

}