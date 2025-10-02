package com.example.halloween

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class BosqueMaldito : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_bosque_maldito, container, false)
        val escribir = view.findViewById<TextView>(R.id.mostrarBosque)
        val nombre = Pantalla2Args.fromBundle(requireArguments()).nombre
        escribir.text = nombre+" era una joven fascinada por los antiguos y prohibidos bosques. Un día, escuchó rumores sobre un claro maldito y brumoso en las profundidades del Bosque Malvado, y decidió explorarlo. Dentro del claro, envuelta en una niebla antinatural, "+"encontró una talla de madera en descomposición de Isabella, la antigua guardabosques del lugar, que se parecía mucho a ella. Intrigada, investigó la historia de Isabella y descubrió que había desaparecido misteriosamente. Durante sus noches en el claro, "+nombre+" sintió la presencia helada de Isabella y tuvo un sueño en el que Isabella le entregaba un rústico mapa tallado en corteza. El mapa revelaba la verdadera ruta de su desaparición y el oscuro secreto oculto en el corazón del bosque."
        return view
    }


}