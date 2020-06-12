package com.example.coven.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

open class SQLHelper(context: Context?) :
    SQLiteOpenHelper(context, sDBName, null, sDBVersion) {

    override fun onCreate(db: SQLiteDatabase) {
        val tablePaginaGrimorio = "CREATE TABLE PaginaGrimorio(id_Pagina INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT NOT NULL, contenido TEXT NOT NULL);"
        db.execSQL(tablePaginaGrimorio)
    }

    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) {


        db.execSQL("DROP TABLE IF EXISTS PaginaGrimorio")
        onCreate(db)
    }

    companion object {
        private const val sDBName = "psm_coven.db"
        private const val sDBVersion = 1
    }
}