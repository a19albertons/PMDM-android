package com.example.xestortarefas

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xestortarefas.databinding.FragmentEngadeTarefasBinding
import com.example.xestortarefas.databinding.FragmentListaTarefasBinding


class ListaTarefasFragment : Fragment() {

    val model: TarefasViewModel by viewModels(
        ownerProducer = { this.requireActivity() }
    )

    private var _binding: FragmentListaTarefasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentListaTarefasBinding.inflate(inflater, container, false)
        val view = binding.root

        return  view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Crea al completo la lista dinamica
        val tareas = model.devolverTareas()

        val recyclerView = binding.filaRecyclerView

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val adapter = FilaAdapater(
            tareas,
            onCheckChange = { posicion, nuevoEstado ->
                // Le decimos al ViewModel: "Cambia el estado del ítem en la fila 'posicion'"
                model.marcoDesmarco(posicion, nuevoEstado)
            }
        )

        recyclerView.adapter = adapter

        model.listaTareas.observe(viewLifecycleOwner) { tareasActualizadas ->
            // SOLUCIÓN AL CRASH:
            // Usamos 'post' para asegurar que el RecyclerView no esté ocupado
            // calculando el layout cuando le mandamos actualizar.
            binding.filaRecyclerView.post {
                (binding.filaRecyclerView.adapter as? FilaAdapater)?.actualizarLista(
                    tareasActualizadas as MutableList<Tarea>
                )
            }
        }


        // Listener
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
