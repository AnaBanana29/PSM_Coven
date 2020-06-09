package com.example.coven

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.coven.fragments.EventosFragment
import com.example.coven.fragments.HomeFragment
import com.example.coven.fragments.LibreriaFragment

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val homeFragment = HomeFragment()
        val eventosFragment = EventosFragment()
        val libreriaFragment = LibreriaFragment()
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navegarFragments(homeFragment)

        navView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> navegarFragments(homeFragment)
                R.id.nav_eventos -> navegarFragments(eventosFragment)
                R.id.nav_biblioteca -> navegarFragments(libreriaFragment)
            }
            true
        }

        //val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
/*        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_dashboard, R.id.nav_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)*/
    }

    private fun navegarFragments(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragmentContainer, fragment)
            commit()
        }
    }
}
