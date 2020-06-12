package com.example.coven.models

import java.util.*

class EventoModel(
    var id_Reunion: Int,
    var titulo: String,
    var descripcion: String,
    var nombreLugar: String,
    var latitud: Float,
    var longitud: Float,
    var usuario_id: Int
){}