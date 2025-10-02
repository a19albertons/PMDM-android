package com.example.halloween

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class MansionMisteriosa : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_mansion_misteriosa, container, false)
        val escribir = view.findViewById<TextView>(R.id.mostrarMansion)
        val nombre = Pantalla2Args.fromBundle(requireArguments()).nombre
        escribir.text = nombre+" era una joven fascinada por las mansiones misteriosas. Un día, escuchó rumores sobre una antigua mansión abandonada en la colina, y decidió explorarla. Dentro de la mansión, "+"encontró un diario encuadernado en cuero en la biblioteca secreta, que contenía las crónicas de Lord Blackwood, el antiguo dueño que se parecía mucho a ella. Intrigada, investigó la historia de Lord Blackwood y descubrió que había desaparecido misteriosamente. Durante sus noches en la mansión, "+nombre+" sintió la presencia de Lord Blackwood y tuvo un sueño en el que el antiguo dueño le entregaba un medallón con un grabado oculto. El medallón revelaba la verdad sobre su desaparición y el tesoro escondido de la mansión."

        return view
    }


}