package com.example.xestortarefas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.xestortarefas.databinding.FragmentEngadeTarefasBinding
import com.example.xestortarefas.databinding.FragmentResumoTarefasBinding

/**
 * Fragmento que gestiona la posibilidad de añadir una tarea de forma grafica
 */
class EngadeTarefasFragment : Fragment() {

    // Reclama el modelo View de forma compartida
    val model: TarefasViewModel by viewModels(
        ownerProducer = { this.requireActivity() }
    )

    // binding de forma privada
    private var _binding: FragmentEngadeTarefasBinding? = null

    // Permite obtener el binding privado
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // Obtiene todos los componentes del layout
        _binding = FragmentEngadeTarefasBinding.inflate(inflater, container, false)
        // Guarda todo los componeneste del layout y devuelve como una vista
        val view = binding.root

        return  view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Habilita un listener para manejar el acto de enviar el formulario para llenar una nueva tarea
        binding.enviar.setOnClickListener {
            // Controla el hecho de que no tenga contenido o este sea vacio por ejemplo solo espacios
            if (binding.nombreTarea.text.toString().trim() == "") {
                binding.errores.text = getString(R.string.error_field_name_empty)

                // Condicional excepcional
                return@setOnClickListener
            }

            // Maneja el hecho de que un chip este marcado
            if (binding.prioridades.checkedChipId == View.NO_ID) {
                binding.errores.text = getString(R.string.error_field_priority_empty)
//                binding.errores.text = binding.prioridades.checkedChipId.toString()

                // Condicional excepcional
                return@setOnClickListener
            }


//            binding.errores.text = binding.prioridades.checkedChipId.toString()

            // Si los anteriores filtros se pasan se inicializa un control de que
            // chip esta marcado para mandar su etiqutea a la funcion correspondiente del model
            // y lo recupere como numero en lugar de texto
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

            // Reutiliza el texto de errores para indicar exito y el total de tarefas actual
            binding.errores.text = getString(R.string.task_added_success, model.tarefasTotal())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}