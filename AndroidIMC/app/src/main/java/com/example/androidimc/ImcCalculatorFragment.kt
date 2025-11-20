package com.example.androidimc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.androidimc.databinding.FragmentImcCalculatorBinding


class ImcCalculatorFragment : Fragment() {
    private var _binding: FragmentImcCalculatorBinding? = null
    private val binding: FragmentImcCalculatorBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentImcCalculatorBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.menosEdad.setOnClickListener {
            binding.edadValor.text = (binding.edadValor.text.toString().toInt() - 1).toString()
        }
        binding.masEdad.setOnClickListener {
            binding.edadValor.text = (binding.edadValor.text.toString().toInt() + 1).toString()
        }
        binding.menosPeso.setOnClickListener {
            binding.pesoValor.text = (binding.pesoValor.text.toString().toInt() - 1).toString()
        }
        binding.masPeso.setOnClickListener {
            binding.pesoValor.text = (binding.pesoValor.text.toString().toInt() + 1).toString()
        }
        binding.sliderAltura.addOnChangeListener { _, value, _ ->
            binding.altura.text = "${value.toInt()} cm"
        }
        binding.moverseResultado.setOnClickListener {
            view.findNavController().navigate(ImcCalculatorFragmentDirections.actionImcCalculatorFragmentToResultIMCFragment(binding.altura.text.toString().split(" ")[0].toInt(),binding.pesoValor.text.toString().toInt(),binding.edadValor.text.toString().toInt()))
        }
        binding.hombreSelecionado.setOnClickListener {
            binding.hombreSelecionado.setBackgroundTintList(resources.getColorStateList(R.color.selecionado))
            binding.mujerSelecionada.setBackgroundTintList(resources.getColorStateList(R.color.fondo_recuadros))
        }
        binding.mujerSelecionada.setOnClickListener {
            binding.hombreSelecionado.setBackgroundTintList(resources.getColorStateList(R.color.fondo_recuadros))
            binding.mujerSelecionada.setBackgroundTintList(resources.getColorStateList(R.color.selecionado))
        }






        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}