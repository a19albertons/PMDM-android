package com.example.xestortarefas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Clase que maneja el viewModel de la lista de tareas
 */
class TarefasViewModel : ViewModel() {
    /**
     * Maneja la lista de tareas en memoria de forma privada
     */
    private var _listaTareas = MutableLiveData<List<Tarea>>(emptyList())

    /**
     * Devuelve una copia de la lista de tareas
     */
    val listaTareas: LiveData<List<Tarea>> get() = _listaTareas

    /**
     * Maneja el añadido de una nueva tarea a la lista
     */
    fun anadirTarea(prioridade: String, nombre: String) {
        val int = when (prioridade) {
            "alto" -> 3
            "medio" -> 2
            "baixo" -> 1
            else -> 1
        }
        val anadir = Tarea(false, int, nombre)
        val lista = _listaTareas.value!!.toMutableList()
        lista.add(anadir)
        _listaTareas.value = lista

    }

    /**
     * Devuelva una copia de la lista de tareas
     */
    fun devolverTareas() : MutableList<Tarea>{
        // En teoria fuerza la devolucion de una copia
        return listaTareas.value!!.toMutableList()
    }

    /**
     * Devuelve el tamaño de ta lista de tareas
     */
    fun tarefasTotal() : Int {
        return listaTareas.value!!.toMutableList().size
    }

    /**
     * Devuelve el tamaño de la lista de tareas, pero comprobando cuales tienen el campo completadas marcado
     */
    fun tarefasTotalCompletadas(): Int {
        var devolver = 0
        listaTareas.value!!.toMutableList().forEach { tarea ->
            if (tarea.getCompletada()) {
                devolver++
            }
        }
        return devolver
    }

    /**
     * Devuelve el tamaño de la lista de tareas, pero comprobando cuales tienen el campo prioridad como alto
     */
    fun tarefasPrioridadeAlta(): Int {
        var devolver = 0
        listaTareas.value!!.toMutableList().forEach { tarea ->
            if (tarea.getPrioridade() == 3) {
                devolver++
            }
        }
        return devolver
    }
    /**
     * Devuelve el tamaño de la lista de tareas, pero comprobando cuales tienen el campo prioridad como medio
     */
    fun tarefasPrioridadeMedia(): Int {
        var devolver = 0
        listaTareas.value!!.toMutableList().forEach { tarea ->
            if (tarea.getPrioridade() == 2) {
                devolver++
            }
        }
        return devolver
    }

    /**
     * Devuelve el tamaño de la lista de tareas, pero comprobando cuales tienen el campo prioridad como baixo
     */
    fun tarefasPrioridadeBaixa(): Int {
        var devolver = 0
        listaTareas.value!!.toMutableList().forEach { tarea ->
            if (tarea.getPrioridade() == 1) {
                devolver++
            }
        }
        return devolver
    }

    /**
     * Maneja la situación de cuando estamos viendo la lista de tareas marcamos o desmarcamos una tarea como completada
     */
    fun marcoDesmarco(posicion: Int, marcoDesmarco: Boolean) {
        // 1. Obtenemos la lista actual (asumiendo que está en un MutableLiveData o similar)
        // Si tu lista 'Tareas' es una variable global o interna del VM, úsala directamente.
        val listaActual = _listaTareas.value?.toMutableList() ?: return

        // 2. Validamos que la posición exista para evitar crash (IndexOutOfBounds)
        if (posicion in listaActual.indices) {

            // 3. Modificamos el objeto en esa posición
            // NOTA: Esto asume que el objeto es mutable. Si es data class inmutable usa .copy()
            listaActual[posicion].setCompletada(marcoDesmarco)

            // 4. CUMPLE EL REQUISITO TÉCNICO:
            // Asignamos la lista al LiveData para que notifique a la UI automáticamente
            _listaTareas.value = listaActual
        }
    }



}