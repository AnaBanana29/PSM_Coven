package com.example.coven.networking

import android.app.ProgressDialog
import android.content.Context
import android.os.AsyncTask
import android.util.Log
import com.example.coven.models.EventoModel
import com.example.coven.models.NetCallback
import com.example.coven.models.UsuarioModel
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import java.util.ArrayList

@Suppress("DEPRECATION")
class Networking(var context: Context) :
    AsyncTask<Any?, Int?, Any?>() {


    private var progressDialog: ProgressDialog? = null

    override fun onPreExecute() {
        super.onPreExecute()
        progressDialog = ProgressDialog(context)
        progressDialog!!.setTitle("Conectando")
        progressDialog!!.setMessage("Espere...")
        progressDialog!!.setCancelable(false)
        progressDialog!!.show()
    }


    override fun doInBackground(vararg params: Any?): Any? {
        val action = params[0] as String

        when(action){

            "login" -> {
                val usuario = usuarioLogin
                // Llamamos a nuestro callback
                val netCallback = params[1] as NetCallback
                netCallback.onWorkFinish(usuario)
            }

        }

        return null
    }

    override fun onPostExecute(result: Any?) {
        super.onPostExecute(result)
    }

    //region Usuarios
     val usuarioLogin: UsuarioModel
        get() {
            val usuarioLista: MutableList<UsuarioModel> = ArrayList()
            val postParams = "_usuario=test&_contrasena=test"
            val response = ""
            var conn: HttpURLConnection? = null
            var url: URL? = null
            try {
                url = URL(SERVER_PATH + "Usuarios/Login")
                conn = url.openConnection() as HttpURLConnection
                conn!!.doInput = true
                conn.doOutput = true
                conn.connectTimeout = TIMEOUT
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
                conn.setFixedLengthStreamingMode(postParams.toByteArray().size)
                val out: OutputStream = BufferedOutputStream(conn.outputStream)
                out.write(postParams.toByteArray())
                out.flush()
                out.close()
                val responseCode = conn.responseCode
                Log.w("RESPONSE CODE", "" + responseCode)
                val `in`: InputStream = BufferedInputStream(conn.inputStream)
                val jsonResponse = inputStreamToString(`in`)
                try {
                    val jsonArray = JSONArray(jsonResponse)
                    for (i in 0 until jsonArray.length()) {
                        val `object` = jsonArray.getJSONObject(i)

                        val id_Usuario = `object`.getString("id_Usuario").toInt()
                        val nombreUsuario = `object`.getString("nombreUsuario")
                        val nombre = `object`.getString("nombre")
                        val apellidos = `object`.getString("apellidos")
                        val correo = `object`.getString("correo")
                        val contrasena = `object`.getString("contrasena")
                        usuarioLista.add(UsuarioModel(id_Usuario, nombreUsuario, nombre, apellidos, correo, contrasena))
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return usuarioLista[0]
        }
    //endregion

    // Metodo que lee un String desde un InputStream (Convertimos el InputStream del servidor en un String)
    private fun inputStreamToString(`is`: InputStream): String {
        var rLine: String? = ""
        val response = StringBuilder()
        val rd = BufferedReader(InputStreamReader(`is`))
        try {
            while (rd.readLine().also { rLine = it } != null) {
                response.append(rLine)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return response.toString()
    }

    companion object {
        const val SERVER_PATH = "https://wscoven.conveyor.cloud/api/"
        const val TIMEOUT = 3000
    }
}