package com.example.uf1_ud05_1_pizza

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.chip.Chip
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


class OrderFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_order, container, false)
        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        val fab = view.findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val pizzaGroup = view.findViewById<RadioGroup>(R.id.group_pizza_type)
            val pizzaType = pizzaGroup.checkedRadioButtonId

            if (pizzaType == -1) {
                val msg = "Debes seleccionar un tipo de pizza"
                Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
            } else {
                // Lógica adicional, si es necesario
            }
            var msg = ""
            if (pizzaType == -1) {
                msg = "Debes seleccionar un tipo de pizza"
                // Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
            } else {
                msg = "Has seleccionado una pizza "
                // Tipo de pizza
                msg += when (pizzaType) {
                    R.id.radio_margarita -> "Margarita"
                    else -> "Calzone"
                }
                // Extras
                var parmesano = view.findViewById<Chip>(R.id.chip_parmesano)
                if (parmesano.isChecked) msg += " Parmesano"
                var tomate = view.findViewById<Chip>(R.id.chip_tomate_cherry)
                if (tomate.isChecked) msg += " Tomate Cherry"
            }
            Snackbar.make(fab, msg, Snackbar.LENGTH_SHORT).show()
        }

        return view
    }


}