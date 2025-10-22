package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController


class Onboarding0Fragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_onboarding0, container, false)

        val botonSiguiente = view.findViewById<Button>(R.id.boton_siguiente)
        botonSiguiente.setOnClickListener {
            view.findNavController().navigate(R.id.action_onboarding0Fragment_to_onboarding1Fragment)
        }

        val botonSkip = view.findViewById<Button>(R.id.boton_skip)
        botonSkip.setOnClickListener {
            view.findNavController().navigate(R.id.action_onboarding0Fragment_to_homeFragment)
        }

        return view
    }

}