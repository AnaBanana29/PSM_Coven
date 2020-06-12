package com.example.coven

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.coven.models.DataSource
import com.example.coven.models.NetCallback
import com.example.coven.models.UsuarioModel
import com.example.coven.models.utils
import com.example.coven.networking.ApiServices
import com.example.coven.networking.Networking
import com.example.coven.networking.serviceBuillder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

@Suppress("DEPRECATION")
class LoginActivity : AppCompatActivity() {
    //Variables
    lateinit var service : ApiServices
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var prefs = getSharedPreferences("misPrefs", Context.MODE_PRIVATE)
        val usr = prefs.getString("usr", null)
        val pwd = prefs.getString("pwd", null)

        if(usr != null)
            txt_Usuario.setText(usr)
        if(pwd != null)
            pwd_Contrasena.setText(pwd)

        context = this
        service = serviceBuillder(this, this).webservice

        //region Navegación

        btn_Entrar.setOnClickListener{
            val usuario = txt_Usuario.text.toString()
            val contrasena = pwd_Contrasena.text.toString()
            //login(usuario, contrasena, service)
            val usuarioLogin = loginDummy(usuario, contrasena)

            if(usuarioLogin != null) {
                val intent: Intent = Intent(context, HomeActivity::class.java)
                intent.putExtra("usuarioLogin", usuarioLogin)

                prefs.edit()
                    .putString("usr", usuario)
                    .putString("pwd", contrasena)
                    .apply()


                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
            }

        }

        btn_Registro.setOnClickListener{
            val intent: Intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

        //endregion

    }

    fun loginDummy(_usuario: String, _contrasena: String): UsuarioModel?{
        val usuariosList = DataSource.createDataSetUsuario()

        usuariosList.forEach {
            if((it.correo == _usuario || it.nombreUsuario == _usuario) && it.contrasena == _contrasena){
                return it
            }
        }
        return null
    }

    /*fun login(_usuario: String, _contrasena: String, service: ApiServices){
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.login(_usuario, _contrasena)
            withContext(Dispatchers.Main) {
                try {
                    if(response.isSuccessful){
                        usuario = response.body()?.let { utils().jsonObjectToUserObject(it)}!!
                        try {
                            val intent: Intent = Intent(context, HomeActivity::class.java)
                            startActivity(intent)
                            finish()
                        }catch (err: Exception){
                            Log.e(this.toString(), err.message)
                        }
                    }else{
                        Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
                    }
                }catch (e: HttpException){
                    Log.e("Error", e.message())
                }catch (e: Exception){
                    Log.e("Error", e.message)
                }
            }
        }

*//*        service!!.login(_usuario, _contrasena).enqueue(object : Callback<UsuarioModel>{
            override fun onResponse(call: Call<UsuarioModel>, response: Response<UsuarioModel>) {
                usuario = response?.body()!!

            }

            override fun onFailure(call: Call<UsuarioModel>, t: Throwable) {
                Toast.makeText(this@LoginActivity, t.message, Toast.LENGTH_LONG).show()            }
        })*//*
    }
*/

}
