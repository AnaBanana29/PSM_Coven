package com.example.coven

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.coven.database.PaginaGrimorioDataSource
import com.example.coven.models.PaginaGrimorioModel
import kotlinx.android.synthetic.main.activity_add_pag_grimorio.*
import java.io.IOException

class AddPagGrimorioActivity : AppCompatActivity() {

    val dataSource = PaginaGrimorioDataSource(this)
    private lateinit var mPaginaGrimorio: PaginaGrimorioModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_pag_grimorio)

        mPaginaGrimorio = PaginaGrimorioModel()

        btn_aceptar.setOnClickListener{
            try {
                val titulo = txt_paginaTitulo!!.text.toString()
                val contenido = txt_paginaContenido!!.text.toString()
                if (titulo.isEmpty() || contenido.isEmpty()) {
                    Toast.makeText(this, "Faltan Campos", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                mPaginaGrimorio.titulo = titulo
                mPaginaGrimorio.contenido = contenido

                dataSource.insertarPagina(mPaginaGrimorio)
            }
            catch (e: IOException){
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }


            finish()


        }
    }
}
