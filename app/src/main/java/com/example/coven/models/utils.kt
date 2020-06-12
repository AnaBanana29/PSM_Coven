package com.example.coven.models

import com.google.gson.Gson
import com.google.gson.JsonObject

class utils {

    fun jsonObjectToUserObject(jsonObject: JsonObject): UsuarioModel{
        val usuario: UsuarioModel
        val gson = Gson()
        usuario = gson.fromJson(jsonObject, UsuarioModel::class.java)
        return usuario
    }

}