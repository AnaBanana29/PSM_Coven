package com.example.coven.models

import java.io.Serializable

class UsuarioModel (
   val id_Usuario : Int,
   val nombreUsuario : String,
   val nombre : String,
   val apellidos : String,
   val correo : String,
   val contrasena : String
) : Serializable{}