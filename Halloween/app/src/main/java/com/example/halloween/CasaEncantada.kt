package com.example.halloween

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class CasaEncantada : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_casa_encantada, container, false)
        val escribir = view.findViewById<TextView>(R.id.mostrarEncantada)
        val nombre = Pantalla2Args.fromBundle(requireArguments()).nombre
        escribir.text = nombre+" era una joven fascinada por las casa encantadas. Un día, escucho rumores sobre una mansion abandonada en el bosque, y decidio explorarla. Dentro de la casa, "+"encontro un retrato de Isabella, la antigua propietaria que se parecia mucho a ella. Intrigada, investigo la historia de Isablella y descubrio que había desaparecido misteriosamente. Durante sus noches en la mansion, "+nombre+" sintio la presencia de Isabella y tuvo un sueño en el que Isabella le entregaba una carta. La carata revelaba la verdad sobre su desaparicion"
        return view
    }



}