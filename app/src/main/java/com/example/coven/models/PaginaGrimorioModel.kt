package com.example.coven.models

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

//id_Pagina INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT NOT NULL, contenido TEXT NOT NUL

@Entity(tableName = "PaginaGrimorio")
class PaginaGrimorioModel {
    @PrimaryKey
    var id_Pagina = 0
    var titulo: String? = null
    var contenido: String? = null

    @Ignore
    constructor() {}

    @Ignore
    constructor(
        titulo: String?,
        contenido: String?
    ) {
        this.titulo = titulo
        this.contenido = contenido
    }

    constructor(
        id_Pagina: Int,
        titulo: String?,
        contenido: String?
    ) {
        this.id_Pagina = id_Pagina
        this.titulo = titulo
        this.contenido = contenido
    }
}