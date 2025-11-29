package com.example.xestortarefas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.xestortarefas.databinding.FragmentResumoTarefasBinding


class ResumoTarefasFragment : Fragment() {

    val model: TarefasViewModel by viewModels(
        ownerProducer = { this.requireActivity() }
    )

    private var _binding: FragmentResumoTarefasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentResumoTarefasBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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