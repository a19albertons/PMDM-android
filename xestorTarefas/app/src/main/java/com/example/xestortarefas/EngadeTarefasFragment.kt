package com.example.xestortarefas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.xestortarefas.databinding.FragmentEngadeTarefasBinding
import com.example.xestortarefas.databinding.FragmentResumoTarefasBinding

class EngadeTarefasFragment : Fragment() {

    val model: TarefasViewModel by viewModels(
        ownerProducer = { this.requireActivity() }
    )

    private var _binding: FragmentEngadeTarefasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEngadeTarefasBinding.inflate(inflater, container, false)
        val view = binding.root

        return  view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.enviar.setOnClickListener {
            if (binding.nombreTarea.text.toString().trim() == "") {
                binding.errores.text = "El campo nombre esta vacio"

                // Condicional excepcional
                return@setOnClickListener
            }
            if (binding.prioridades.checkedChipId == View.NO_ID) {
                binding.errores.text = "El campo de prioridad esta vacio"
//                binding.errores.text = binding.prioridades.checkedChipId.toString()

                // Condicional excepcional
                return@setOnClickListener
            }


//            binding.errores.text = binding.prioridades.checkedChipId.toString()
            var texto = ""
            if (binding.alto.isChecked) {
                texto = "alto"
            }
            else if (binding.medio.isChecked) {
                texto = "medio"
            }
            else if (binding.baixo.isChecked) {
                texto = "baixo"
            }
            model.anadirTarea(texto,binding.nombreTarea.text.toString())
//            binding.errores.text = model.tarefasTotal().toString()
            binding.errores.text = "Tareas añadida con exito. Actualmente hay: "+model.tarefasTotal()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}