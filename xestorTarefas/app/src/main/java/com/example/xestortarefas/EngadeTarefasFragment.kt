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
                binding.errores.text = getString(R.string.error_field_name_empty)

                // Condicional excepcional
                return@setOnClickListener
            }
            if (binding.prioridades.checkedChipId == View.NO_ID) {
                binding.errores.text = getString(R.string.error_field_priority_empty)
//                binding.errores.text = binding.prioridades.checkedChipId.toString()

                // Condicional excepcional
                return@setOnClickListener
            }


//            binding.errores.text = binding.prioridades.checkedChipId.toString()
            var texto = ""
            if (binding.alto.isChecked) {
                texto = getString(R.string.priority_high)
            }
            else if (binding.medio.isChecked) {
                texto = getString(R.string.priority_medium)
            }
            else if (binding.baixo.isChecked) {
                texto = getString(R.string.priority_low)
            }
            model.anadirTarea(texto,binding.nombreTarea.text.toString())
//            binding.errores.text = model.tarefasTotal().toString()
            binding.errores.text = getString(R.string.task_added_success, model.tarefasTotal())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}