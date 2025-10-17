package com.example.halloween

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController


class CasaEncantada : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_casa_encantada, container, false)
        val escribir = view.findViewById<TextView>(R.id.mostrarEncantada)
        val nombre = Pantalla2Args.fromBundle(requireArguments()).nombre
        escribir.text = getString(R.string.historia_casa_encantada, nombre)
        val button = view.findViewById<Button>(R.id.botonVolverEncantada)
        button.setOnClickListener {
            view.findNavController().navigate(CasaEncantadaDirections.actionCasaEncantadaToPantalla1())
        }
        return view
    }



}