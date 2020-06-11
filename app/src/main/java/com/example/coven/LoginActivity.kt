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

        btn_Entrar.setOnClickListener{
            val intent: Intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        btn_Registro.setOnClickListener{
            val intent: Intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

        //endregion

    }
}
