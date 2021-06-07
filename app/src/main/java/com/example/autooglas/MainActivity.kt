package com.example.autooglas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var toolbar: ActionBar
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener{ item ->
        when (item.itemId){
            R.id.navigation_oglasi -> {
                toolbar.title="Oglasi"
                val oglasiFragment=OglasiFragment.newInstance()
                openFragment(oglasiFragment)
                return@OnNavigationItemSelectedListener true

            }
            R.id.navigation_dodaj_oglas ->{
                toolbar.title = "Dodaj Oglas"
                val dodajOglas = DodajOglasFragment.newInstance()
                openFragment(dodajOglas)
                return@OnNavigationItemSelectedListener true
            }
        }
        false

    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = supportActionBar!!
        val bottomNavigationView:BottomNavigationView = findViewById(R.id.navigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener ( mOnNavigationItemSelectedListener )
        openFragment(OglasiFragment.newInstance())
    }
}