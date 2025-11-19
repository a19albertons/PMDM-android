package com.example.uf1_ud05_1_pizza

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.uf1_ud05_1_pizza.databinding.FragmentOrderBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.chip.Chip
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


class OrderFragment : Fragment() {

    private var _binding: FragmentOrderBinding? = null
    private val binding: FragmentOrderBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        val view = binding.root
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
//        val fab = view.findViewById<FloatingActionButton>(R.id.fab)
        binding.fab.setOnClickListener {

            if (binding.groupPizzaType.checkedRadioButtonId == -1) {
                val msg = "Debes seleccionar un tipo de pizza"
                Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
            } else {
                // Lógica adicional, si es necesario
            }
            var msg = ""
            if (binding.groupPizzaType.checkedRadioButtonId == -1) {
                msg = "Debes seleccionar un tipo de pizza"
                // Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
            } else {
                msg = "Has seleccionado una pizza "
                // Tipo de pizza
                msg += when (binding.groupPizzaType.checkedRadioButtonId) {
                    binding.radioMargarita.id -> "Margarita"
                    else -> "Calzone"
                }
                // Extras
                if (binding.chipParmesano.isChecked) msg += " Parmesano"
                if (binding.chipTomateCherry.isChecked) msg += " Tomate Cherry"
            }
            Snackbar.make(binding.fab, msg, Snackbar.LENGTH_SHORT).show()
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}