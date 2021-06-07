package com.example.autooglas

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_oglasi.view.*

class OglasiFragment :Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View= inflater.inflate(R.layout.fragment_oglasi, container, false)
        OglasLister.automobili.sortByDescending { it.rezerv }
        val lista_oglasa=view.lista_oglasa
        lista_oglasa.adapter=MojAdapter(view.context)
        return view
    }

    companion object{
        fun newInstance():OglasiFragment = OglasiFragment()
    }

    private class MojAdapter(context: Context):BaseAdapter(){
        private val mContext:Context = context
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View{

            val textView=TextView(mContext)
            textView.setText(OglasLister.automobili.get(position).naziv)
            if (OglasLister.automobili.get(position).rezerv){
                textView.setTextColor(Color.RED)
            }
            textView.setOnClickListener({
                Toast.makeText(mContext,"Ovde treba dodati detaljan prikaz vesti",Toast.LENGTH_LONG).show()
            })
            return textView
        }

        override fun getItem(position: Int): Any {
           return OglasLister.automobili.get(position)
        }

        override fun getItemId(position: Int): Long {
            TODO("Not implemented")
        }

        override fun getCount(): Int {
            return OglasLister.automobili.size
        }
    }

}