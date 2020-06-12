package com.example.coven

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.coven.fragments.EventoAdapter
import com.example.coven.models.EventoModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import kotlinx.android.synthetic.main.activity_detalles_evento.*

class DetallesEventoActivity : AppCompatActivity(), OnMapReadyCallback {
    // Geocoding:
    // Transforma coordenadas geograficas en direcciones (calle, colonia, avenidas, pais, etc)
    // Reverse Geocoding
    // Transofma nombre de direcciones (calles, colonias, avenidas, pais, etc) en coordenadas geograficas
    private var geocoder: Geocoder? = null

    // Objeto con el cual podremos hacer uso de nuestro mapa de Google
    private var map: GoogleMap? = null

    // LocationManager: Nos permite obtener la ubicacion del usuario a traves de diferentes metodos.
    private var locationManager: LocationManager? = null

    // Fragmento del mapa
    private var mapFragment: SupportMapFragment? = null

    // Extra: Lo utilizamos para agregar marcadores al mapa
    private var markerPositions: MutableList<LatLng>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles_evento)

        var eventoDetalles = intent.getSerializableExtra("Evento") as EventoModel

        if(eventoDetalles != null){
            txt_eventoTitulo.setText(eventoDetalles.titulo)
            txt_eventoFecha.setText(eventoDetalles.fecha)
            txt_eventoDescripcion.setText(eventoDetalles.descripcion)
        }

        // Fragmento que contiene al mapa de google en el Layout
        mapFragment = supportFragmentManager.findFragmentById(R.id.mapView) as SupportMapFragment

        // Como estamos implementando OnMapReadyCallback (Ver arriba) esto quiere decir que se debe de encontrar
        // el metodo "onMapReady" y una ves que se termine de cargar el mapa se llamara a este metodo para poder
        // comenzar a utilizar el objeto mapa
        mapFragment!!.getMapAsync(this)
    }

    // Se llama cuando el mapa este listo para trabajar con el
    override fun onMapReady(googleMap: GoogleMap?) {
        // Instaciammos nuestor objeto mapa
        map = googleMap

        // Inicializa nuestro objeto LocationManager
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        // Listener para detectar los eventos "Click" dentro del mapa
        map!!.setOnMapClickListener {
            // Funcion extra que desarrollamos para agregar marcadores al mapa
            // ..
        }

        // Si estamos en Android 6.0+ tenemos que pedir permisos en tiempo de ejecucion
        // Si estamos debajo de Android 6.0 solo hace falta pedir permisos desde el AndroidManifest
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) checkPermissions() else moveMapCameraToUserLocation()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (grantResults.isNotEmpty()) {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Se requiere aceptar el permiso", Toast.LENGTH_SHORT).show()
                checkPermissions()
            } else {
                Toast.makeText(this, "Permisio concedido", Toast.LENGTH_SHORT).show()
                moveMapCameraToUserLocation()
            }
        }
    }

    private fun checkPermissions() {
        // Apartir de Android 6.0+ necesitamos pedir el permiso de ubicacion
        // directamente en tiempo de ejecucion de la app
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // Si no tenemos permiso para la ubicacion
            // Solicitamos permiso
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                1
            )
        } else {
            // Ya se han concedido los permisos anteriormente
            moveMapCameraToUserLocation()
        }
    }

    private fun moveMapCameraToUserLocation() {
        // Continuamos obteniendo la ubicacion del usuario para despues mostrar esa ubicacion en el mapa por default
        // pero cuando no se encuentre la ubicacion entonces pondremos una ubicacion fija.
        var currentLocation: LatLng? = null
        try {
            // Muestra el boton de "Mi Ubicacion" en el mapa (El tipico circulo azul de google)
            map!!.isMyLocationEnabled = true

            // Utilizamos el metodo que desarrollamos para obtener la ubicacion del usuario
            currentLocation = getCurrentLocation()
        } catch (e: SecurityException) {
            e.printStackTrace()
        }

        // Si se pudo obtener la ubicacion del usuario
        if (currentLocation != null) {
            // Movemos la camara para que apunte a otra coordenada diferente e la default
            map!!.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 16f))

        } else { // Si no se pudo obtener la ubicacion
            // Ponemos una ubicacion fija
            val mtyLocation = LatLng(25.65, -100.29)
            map!!.moveCamera(CameraUpdateFactory.newLatLngZoom(mtyLocation, 16f))

        }
    }

    @Throws(SecurityException::class)
    private fun getCurrentLocation(): LatLng? {
        val providers = locationManager!!.getProviders(true)
        var bestLocation: Location? = null

        for(provider in providers){
            //getLastKnownLocation: Obtiene la útima ubicación conocida por el proveedor seleccionado
            val l = locationManager!!.getLastKnownLocation(provider)?: continue
            if(bestLocation == null || l.accuracy < bestLocation.accuracy){
                showToast("Proveedor seleccionado: $provider")
                bestLocation = l
            }
        }

        if(bestLocation == null){
            showToast("No se pudo obtener la ubicación. Espere un momento")
            return null
        }
        return LatLng(bestLocation.latitude, bestLocation.longitude)
    }

    private fun addMarker(
        title: String,
        position: LatLng,
        clean: Boolean,
        polys: Boolean
    ) {
        if (clean) {
            map!!.clear()
        }

        // De esta manera se pueden agregar marcadores al mapa
        val opts = MarkerOptions()
        opts.position(position)
        opts.title(title)

        // La clase GoogleMap tiene el metodo addMarker
        map!!.addMarker(opts)
        if (!polys) return
        if (markerPositions == null) markerPositions = ArrayList()

        // EXTRA: Tambien se pueden poner lineas dentro del mapa
        val line = PolylineOptions()
        line.width(8f)
        line.color(Color.BLUE)
        if (markerPositions!!.size > 0) {
            val latLng = markerPositions!![markerPositions!!.size - 1]
            line.add(latLng)
        }
        line.add(position)
        markerPositions!!.add(position)

        // Muestra una linea en el mapa
        map!!.addPolyline(line)
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
