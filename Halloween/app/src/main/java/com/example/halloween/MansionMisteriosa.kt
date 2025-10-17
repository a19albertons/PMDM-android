package com.example.halloween

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Button
import androidx.navigation.findNavController


class MansionMisteriosa : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_mansion_misteriosa, container, false)
        val escribir = view.findViewById<TextView>(R.id.mostrarMansion)
        val nombre = Pantalla2Args.fromBundle(requireArguments()).nombre
        escribir.text = getString(R.string.historia_mansion_misteriosa, nombre)
        val button = view.findViewById<Button>(R.id.botonVolverMansion)
        button.setOnClickListener {
            view.findNavController().navigate(MansionMisteriosaDirections.actionMansionMisteriosaToPantalla1())
        }

        return view
    }


}