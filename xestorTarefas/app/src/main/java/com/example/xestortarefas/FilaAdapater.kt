package com.example.xestortarefas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


/**
 * Clase que invoca el recyclerView para dibujar cada fila de la lista de tareas
 */
class FilaAdapater(private val onCheckChange: (Int, Boolean) -> Unit  ):
    ListAdapter<Tarea, FilaAdapater.TareaViewHolder>(DIFF_CALLBACK) {

    // Crea la fila, pero no la dibuja. Guarda los campos que nos interesa modificar en el binding
    class TareaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombre: TextView = itemView.findViewById(R.id.nombre)
        val prioridade: TextView = itemView.findViewById(R.id.prioridade)
        val completada: CheckBox = itemView.findViewById(R.id.completada)// Adjust ID as needed
        // Add other views, e.g., val prioridadTextView: TextView = itemView.findViewById(R.id.prioridad_tarea)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TareaViewHolder {
        // Coge la vista anterior y la dibuja
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fila_tareas,parent,false)
        return TareaViewHolder(view)
    }

    // Maneja el contenido previo y los eventos
    override fun onBindViewHolder(holder: TareaViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.nombre.text = currentItem.getNome()
        holder.prioridade.text = intToText(currentItem.getPrioridade(), holder.itemView.context)

        holder.completada.setOnClickListener(null)
        holder.completada.isChecked = currentItem.getCompletada()
        holder.completada.setOnCheckedChangeListener { _ , isChecked ->
            val posActual = holder.adapterPosition
            if (posActual != RecyclerView.NO_POSITION) {
                onCheckChange(posActual, isChecked)
            }
        }
    }

    // Convierte el numero que usa tarea intermanente a texto (revierte el proceso de guardado)
    fun intToText(valor : Int, context: android.content.Context) : String {
        return when (valor) {
            3 -> context.getString(R.string.priority_high)
            2 -> context.getString(R.string.priority_medium)
            1 -> context.getString(R.string.priority_low)
            else -> context.getString(R.string.priority_low)
        }
    }

    // Guarda un campo de forma comun a todas las instancias
    companion object {
        // Maneja las variaciones entre una versión vieja y nueva de la lista.
        // La primera función maneja si dos objectos son identicos.
        // La segunda maneja que contenido cambia en este caso el checkbox de completada
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Tarea>() {
            override fun areItemsTheSame(oldItem: Tarea, newItem: Tarea): Boolean {
                return oldItem.getNome() == newItem.getNome() && oldItem.getPrioridade() == newItem.getPrioridade()
            }

            override fun areContentsTheSame(oldItem: Tarea, newItem: Tarea): Boolean {
                return oldItem.getCompletada() == newItem.getCompletada()
            }
        }
    }
}