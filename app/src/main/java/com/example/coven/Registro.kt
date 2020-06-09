package com.example.coven

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class Registro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        //region Navegación

        btnEntrar.setOnClickListener{
            val intent: Intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        //endregion
    }
}
