package com.example.xestortarefas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class FilaAdapater(private var Tareas : MutableList<Tarea>, private val onCheckChange: (Int, Boolean) -> Unit  ):
    RecyclerView.Adapter<FilaAdapater.TareaViewHolder>() {

    class TareaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombre: TextView = itemView.findViewById(R.id.nombre)
        val prioridade: TextView = itemView.findViewById(R.id.prioridade)
        val completada: CheckBox = itemView.findViewById(R.id.completada)// Adjust ID as needed
        // Add other views, e.g., val prioridadTextView: TextView = itemView.findViewById(R.id.prioridad_tarea)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FilaAdapater.TareaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fila_tareas,parent,false)
        return TareaViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilaAdapater.TareaViewHolder, position: Int) {
        val currentItem = Tareas[position]
        holder.nombre.text = currentItem.getNomeKt()
        holder.prioridade.text = intToText(currentItem.getPrioridadeKt())

        holder.completada.setOnClickListener(null)
        holder.completada.isChecked = currentItem.getCompletadaKt()
        holder.completada.setOnCheckedChangeListener { _ , isChecked ->
            val posActual = holder.position
            if (posActual != RecyclerView.NO_POSITION) {
                onCheckChange(posActual, isChecked)
            }
        }
    }

    override fun getItemCount(): Int {
        return Tareas.size
    }

    fun actualizarLista(nuevasTareas: MutableList<Tarea>) {
        this.Tareas = nuevasTareas
        notifyDataSetChanged() // O idealmente usar DiffUtil
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

}