package com.example.coven

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {
    //Variables

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //region Navegación

        btnEntrar.setOnClickListener{
            val intent: Intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        btnRegistro.setOnClickListener{
            val intent: Intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

        //endregion

    }
}
