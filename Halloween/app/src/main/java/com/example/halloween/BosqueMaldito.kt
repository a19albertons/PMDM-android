package com.example.halloween

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Button
import androidx.navigation.findNavController


class BosqueMaldito : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_bosque_maldito, container, false)
        val escribir = view.findViewById<TextView>(R.id.mostrarBosque)
        val nombre = Pantalla2Args.fromBundle(requireArguments()).nombre
        escribir.text = getString(R.string.historia_bosque_malvado, nombre)
        val button = view.findViewById<Button>(R.id.botonVolverBosque)
        button.setOnClickListener {
            view.findNavController().navigate(BosqueMalditoDirections.actionBosqueMalditoToPantalla1())
        }
        return view
    }


}