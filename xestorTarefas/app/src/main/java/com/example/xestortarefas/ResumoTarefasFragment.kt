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

        binding.totalTarefas.text = "Total tarefas: "+model.tarefasTotal().toString()
        binding.totalTarefasCompletadas.text = "Total tarefas completadas: "+model.tarefasTotalCompletadas().toString()
        binding.totalTarefasPrioridadeAlta.text = "Total tarefas prioridade alta: "+model.tarefasPrioridadeAlta()
        binding.totalTarefasPrioridadeMedia.text = "Total tarefas prioridade media: "+model.tarefasPrioridadeMedia()
        binding.totalTarefasPrioridadeBaixa.text = "Total tarefas prioridade baixa: "+model.tarefasPrioridadeBaixa()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}