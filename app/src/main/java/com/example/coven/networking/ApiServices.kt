package com.example.coven.networking

import android.app.Activity
import android.content.Context
import com.example.coven.models.EventoModel
import com.example.coven.models.UsuarioModel
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

interface ApiServices {

    @GET("Usuarios/Login")
        fun login(@Query("_usuario") _usuario: String, @Query("_contrasena") _contrasena: String): Response<JsonObject>


    @GET("Reunion/Select")
    fun selectEventos(): Response<JsonArray>
}

class serviceBuillder(private val context: Context, private val activity: Activity){
    val BASE_URL = "https://wscoven.conveyor.cloud/api/"

    val webservice by lazy {
        Retrofit.Builder()
            .client(
                OkHttpClient.Builder()
                    .connectTimeout(1000, TimeUnit.SECONDS)
                    .readTimeout(1000, TimeUnit.SECONDS)
                    .build()
            )
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(ApiServices::class.java)
    }
}
