package com.example.coven

import android.content.Intent
import android.gesture.GestureLibraries
import android.gesture.GestureLibrary
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_gestos.*

class GestosActivity : AppCompatActivity() {

    //Objeto el cual tendra nuestras gesturas que creemos
    // nosotros mismos con la app "Gesture Builder"
    private lateinit var gestureLibrary: GestureLibrary

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestos)

        gestureLibrary = GestureLibraries.fromRawResource(this, R.raw.gestures)

        // Si no se pudo cargar nuestra libreria (coleccion) de gesturas
        if (!gestureLibrary.load()) {
            finish()
        }

        gesture_overlay.addOnGesturePerformedListener { overlay, gesture ->

            val predictions = gestureLibrary.recognize(gesture)
            if(predictions.size > 0) {
                val prediction = predictions[0]

                if(prediction.score > 1.0) {
                    if (prediction.name == "clave") {
                        val intent: Intent = Intent(this, GrimorioActivity::class.java)
                        startActivity(intent)
                    }
                }
            }

        }
    }
}
