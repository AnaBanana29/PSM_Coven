package com.example.coven.database

import android.content.Context

class PaginaGrimorioDataSource(context: Context): SQLHelper(context){

    fun insertarPagina(pagina: PaginaGrimorioDataSource){
        // Abrimos la conexion con la base de datos sqlite
        val db = writableDatabase

    }
}