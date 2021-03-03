package com.example.profile.dependency

import android.content.Context
import android.content.SharedPreferences
import com.example.profile.MainRepository
import com.example.profile.data.InitialApi
import com.example.profile.sharedpref.ISharedPref
import com.example.profile.sharedpref.SharedPref
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton
import retrofit2.converter.moshi.MoshiConverterFactory



// live as long as the app lives - retrofit etc

@Module
@InstallIn(SingletonComponent::class) // -> Application component is depriciated, we use Singleton component
object AppModule {

    // construct dependencies here as functions


    @Singleton // ????
    @Provides
    fun provideInitialApi(): InitialApi = Retrofit.Builder()
        .baseUrl("https://scbl.at/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(InitialApi::class.java)

    @Singleton
    @Provides
    @Named("str_try")
    fun getString():String = "FIRST HILT - YAAY"

    @Singleton
    @Provides
    fun provideMainRepository(api: InitialApi): MainRepository = MainRepository(api)


    /// Shared preferences
    @Singleton
    @Named("shared_preferences")
    @Provides
    fun provideBaseUrl(): String = "sociable" // or anything you want

    @Singleton
    @Provides
    fun provideSharedPrefenreces(@ApplicationContext context: Context,
                                 @Named("shared_preferences") sharedPref: String
    ): SharedPreferences {
        return context.getSharedPreferences(sharedPref, Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideSharedPref(sharedPref: SharedPref): ISharedPref {
        return sharedPref
    }
}