package com.example.halloween

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController


class Pantalla1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_pantalla1, container, false)
        val button = view.findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val nombre = view.findViewById<EditText>(R.id.editTextText).text.toString()
            view.findNavController().navigate(Pantalla1Directions.actionPantalla1ToPantalla2(nombre))
        }
        return view
    }

}