package com.example.space

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController


class EstrellasConstelaciones : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_estrellas_constelaciones, container, false)
        val mostrar = view.findViewById<TextView>(R.id.mostrarInfo)
        val orionMitologia = view.findViewById<View>(R.id.orionMitologia)
        val orionObservacion = view.findViewById<View>(R.id.orionObservacion)
        val orionMitologiaText = "Orión es un cazador gigante de la mitología griega, representado en el cielo por una de las constelaciones más reconocibles."
        val orionObservacionText = "La constelación de Orión es visible en el cielo nocturno durante el invierno y destaca por su cinturón formado por tres estrellas alineadas."
        orionMitologia.setOnClickListener {
            mostrar.text = orionMitologiaText
        }

        orionObservacion.setOnClickListener {
            mostrar.text = orionObservacionText
        }


        val osaMayorMitologia = view.findViewById<View>(R.id.osaMayorMitologia)
        val osaMayorObservacion = view.findViewById<View>(R.id.osaMayorObservacion)
        val osaMayorMitologiaText = "La Osa Mayor está asociada con la mitología griega, donde se cuenta la historia de Calisto, una ninfa transformada en osa por Zeus."
        val osaMayorObservacionText = "La Osa Mayor es una constelación prominente en el hemisferio norte, conocida por su forma de carro o cucharón."
        osaMayorMitologia.setOnClickListener {
            mostrar.text = osaMayorMitologiaText
        }

        osaMayorObservacion.setOnClickListener {
            mostrar.text = osaMayorObservacionText
        }


        val casiopeaMitologia = view.findViewById<View>(R.id.casiopeaMitologia)
        val casiopeaObservacion = view.findViewById<View>(R.id.casiopeaObservacion)
        val casiopeaMitologiaText = "Casiopea, reina de Etiopía en la mitología griega, es conocida por su vanidad y su castigo de ser colocada en el cielo."
        val casiopeaObservacionText = "La constelación de Casiopea es fácilmente reconocible por su forma de 'W' o 'M' y es visible durante todo el año en el hemisferio norte."
        casiopeaMitologia.setOnClickListener {
            mostrar.text = casiopeaMitologiaText
        }
        casiopeaObservacion.setOnClickListener {
            mostrar.text = casiopeaObservacionText
        }

        return view
    }

}