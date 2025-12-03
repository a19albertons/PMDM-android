package com.example.xestortarefas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.xestortarefas.databinding.FragmentResumoTarefasBinding

/**
 * Fragmento que muestra un resumen de la lista de tareas
 */
class ResumoTarefasFragment : Fragment() {

    // Invoca al model y lo comparte con el resto de fragmentos participes en esta actividad
    val model: TarefasViewModel by viewModels(
        ownerProducer = { this.requireActivity() }
    )

    // Almacena el binding de forma privada
    private var _binding: FragmentResumoTarefasBinding? = null

    // Devuelve el binding privado
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // Recupera todas las referencias del layout
        _binding = FragmentResumoTarefasBinding.inflate(inflater, container, false)

        // Crea una vista del root y la devuelve
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Crear cada texto solicitando el valor a la función correspondiente
        binding.totalTarefas.text = getString(R.string.total_tasks, model.tarefasTotal())
        binding.totalTarefasCompletadas.text = getString(R.string.total_completed_tasks, model.tarefasTotalCompletadas())
        binding.totalTarefasPrioridadeAlta.text = getString(R.string.total_high_priority_tasks, model.tarefasPrioridadeAlta())
        binding.totalTarefasPrioridadeMedia.text = getString(R.string.total_medium_priority_tasks, model.tarefasPrioridadeMedia())
        binding.totalTarefasPrioridadeBaixa.text = getString(R.string.total_low_priority_tasks, model.tarefasPrioridadeBaixa())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}