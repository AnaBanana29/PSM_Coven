package com.example.coven.models

import java.io.Serializable
import java.util.*

class EventoModel(
    var id_Reunion: Int,
    var fecha: String,
    var titulo: String,
    var descripcion: String,
    var nombreLugar: String,
    var latitud: Float,
    var longitud: Float,
    var usuario_id: Int
): Serializable{}