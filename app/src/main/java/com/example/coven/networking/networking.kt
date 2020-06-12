package com.example.coven.networking

import com.example.coven.models.EventoModel
import com.example.coven.models.UsuarioModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService{
    //region Usuarios
    @GET("Usuarios/Login?{_usuario}&{_contrasena}")
    fun login(@Path("_usuario") id: Int, @Path("_contrasena") contrasena: Int): Call<UsuarioModel>
    //endregion

    //region Eventos
    @GET("Reunion/Select")
    fun eventosSelect() : Call<List<EventoModel>>
    //endregion
}