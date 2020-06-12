package com.example.coven.database

import android.content.ContentValues
import android.content.Context
import com.example.coven.models.PaginaGrimorioModel

class PaginaGrimorioDataSource(context: Context): SQLHelper(context){

    fun insertarPagina(pagina: PaginaGrimorioModel){
        // Abrimos la conexion con la base de datos sqlite
        val db = writableDatabase

        val values = ContentValues()
        values.put(sColumnTitulo, pagina.titulo)
        values.put(sColumnContenido, pagina.contenido)

        // Insertamos la informacion en la tabla
        db.insert(sTableName, null, values)
        // Cerramos la conexion con la base de datos sqlite
        db.close()

    }

    val selectPaginas:MutableList<PaginaGrimorioModel>
    get() {
        val db = writableDatabase
        val paginasList:MutableList<PaginaGrimorioModel> = ArrayList()

        val cursor = db.rawQuery("SELECT * FROM $sTableName", null)

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast) {
                val id = cursor.getInt(cursor.getColumnIndex(sColumnId))
                val titulo = cursor.getString(cursor.getColumnIndex(sColumnTitulo))
                val contenido = cursor.getString(cursor.getColumnIndex(sColumnContenido))
                paginasList.add(PaginaGrimorioModel(id, titulo, contenido))
                cursor.moveToNext()
            }
            cursor.close()
        }
        db.close()
        return paginasList

    }

    companion object {
        private const val sTableName = "PaginaGrimorio"
        private const val sColumnId = "id_Pagina"
        private const val sColumnTitulo = "titulo"
        private const val sColumnContenido = "contenido"
    }
}