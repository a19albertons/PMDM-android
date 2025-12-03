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


/**
 * Maneja la lista de tareas
 */
class ListaTarefasFragment : Fragment() {

    /**
     * Invoca el modelo de forma compartida entre otros fragmentos para la actual actividad
     */
    val model: TarefasViewModel by viewModels(
        ownerProducer = { this.requireActivity() }
    )

    // Almacena el binding de forma privada
    private var _binding: FragmentListaTarefasBinding? = null

    // Permite recuperar el binding privado
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // Obtiene todas las referencias del layout
        _binding = FragmentListaTarefasBinding.inflate(inflater, container, false)

        // Obtiene una vista del binding y la envia
        val view = binding.root

        return  view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtiene la referencia al recyclerView del scroll
        val recyclerView = binding.filaRecyclerView

        // Indica que plantilla layout debe usar en este caso la más basica
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Configura la invocación de la lista dinamica llamando a la clase FilaAdapater y su constructor para que haga la fila
        // y un elemento en el constructor para poder tener un listener del cambio cuando clickemos en el checkbox
        val adapter = FilaAdapater(
            onCheckChange = { posicion, nuevoEstado ->
                // Le decimos al ViewModel: "Cambia el estado del ítem en la fila 'posicion'"
                model.marcoDesmarco(posicion, nuevoEstado)
            }
        )

        // Termina de configurar el recyclerView
        recyclerView.adapter = adapter

        // Manda y controla los cambios en la lista a visualizar en el recyclerView
        model.listaTareas.observe(viewLifecycleOwner) { tareasActualizadas ->

            (binding.filaRecyclerView.adapter as? FilaAdapater)?.submitList(tareasActualizadas)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
