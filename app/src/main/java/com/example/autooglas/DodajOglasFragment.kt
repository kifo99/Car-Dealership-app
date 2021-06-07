package com.example.autooglas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_dodaj_oglas.*



class DodajOglasFragment :Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_dodaj_oglas, container, false)
        val dugme:Button = view.findViewById(R.id.dodaj)
        dugme.setOnClickListener ({
           OglasLister.automobili.add(Automobil(nazivVozila.text.toString(), tipGoriva.text.toString(),
                    regBroj.text.toString(), opisVozila.text.toString(), godiste.text.toString().toInt(), cijena.text.toString().toInt(), rezervVozilo.isChecked))
            Toast.makeText(view.context, "Dodali ste oglas", Toast.LENGTH_LONG).show()

        })
        return view
    }
        companion object{
            fun newInstance():DodajOglasFragment= DodajOglasFragment()
        }
}