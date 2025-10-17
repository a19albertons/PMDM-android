package com.example.halloween

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.navigation.NavArgs
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs


class Pantalla2 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_pantalla2, container, false)
        val casaEncantada = view.findViewById<CardView>(R.id.casaEncantadaLayout)
        casaEncantada.setOnClickListener {
            val nombre = Pantalla2Args.fromBundle(requireArguments()).nombre
            view.findNavController().navigate(Pantalla2Directions.actionPantalla2ToCasaEncantada(nombre))
        }
        val bosqueMaldito = view.findViewById<CardView>(R.id.bosqueMalditoLayout)
        bosqueMaldito.setOnClickListener {
            val nombre = Pantalla2Args.fromBundle(requireArguments()).nombre
            view.findNavController().navigate(Pantalla2Directions.actionPantalla2ToBosqueMaldito(nombre))
        }
        val mansionMisteriosa = view.findViewById<CardView>(R.id.mansionMisteriosaLayout)
        mansionMisteriosa.setOnClickListener {
            val nombre = Pantalla2Args.fromBundle(requireArguments()).nombre
            view.findNavController().navigate(Pantalla2Directions.actionPantalla2ToMansionMisteriosa(nombre))
        }
        return view
    }


}