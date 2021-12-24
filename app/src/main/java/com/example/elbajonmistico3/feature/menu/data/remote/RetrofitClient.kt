package com.example.elbajonmistico3.feature.menu.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    // https://mocki.io/v1/00cff39e-73e0-4abe-a642-fd9137eac223
    private const val URL_BASE = "https://mocki.io/v1/"
    private val retro = RetrofitClient
    fun getRetrofit(): MenuApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(MenuApi::class.java)
    }
}