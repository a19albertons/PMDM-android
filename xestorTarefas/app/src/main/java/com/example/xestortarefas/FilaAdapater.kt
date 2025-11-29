package com.example.xestortarefas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView



class FilaAdapater(private val onCheckChange: (Int, Boolean) -> Unit  ):
    ListAdapter<Tarea, FilaAdapater.TareaViewHolder>(DIFF_CALLBACK) {

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
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fila_tareas,parent,false)
        return TareaViewHolder(view)
    }

    override fun onBindViewHolder(holder: TareaViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.nombre.text = currentItem.getNomeKt()
        holder.prioridade.text = intToText(currentItem.getPrioridadeKt())

        holder.completada.setOnClickListener(null)
        holder.completada.isChecked = currentItem.getCompletadaKt()
        holder.completada.setOnCheckedChangeListener { _ , isChecked ->
            val posActual = holder.adapterPosition
            if (posActual != RecyclerView.NO_POSITION) {
                onCheckChange(posActual, isChecked)
            }
        }
    }

    fun intToText(valor : Int) : String {
        var String = ""
        when (valor) {
            3 -> String = "alto"
            2 -> String = "medio"
            1 -> String = "baixo"
            else -> String = "baixo"
        }
        return String
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Tarea>() {
            override fun areItemsTheSame(oldItem: Tarea, newItem: Tarea): Boolean {
                return oldItem.getNomeKt() == newItem.getNomeKt() && oldItem.getPrioridadeKt() == newItem.getPrioridadeKt()
            }

            override fun areContentsTheSame(oldItem: Tarea, newItem: Tarea): Boolean {
                return oldItem.getCompletadaKt() == newItem.getCompletadaKt()
            }
        }
    }
}