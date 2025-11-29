package com.example.xestortarefas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TarefasViewModel : ViewModel() {
    private var _listaTareas = MutableLiveData<List<Tarea>>(emptyList())
    val listaTareas: LiveData<List<Tarea>> get() = _listaTareas


    fun anadirTarea(prioridade: String, nombre: String) {
        var int = 0
        when (prioridade) {
            "alto" -> int = 3
            "medio" -> int = 2
            "baixo" -> int = 1
            else -> int = 1
        }
        var anadir = Tarea(false, int, nombre)
        val lista = _listaTareas.value.toMutableList()
        lista.add(anadir)
        _listaTareas.value = lista

    }
    fun devolverTareas() : MutableList<Tarea>{
        // En teoria fuerza la devolucion de una copia
        return listaTareas.value.toMutableList()
    }
    fun tarefasTotal() : Int {
        return listaTareas.value.toMutableList().size
    }
    fun tarefasTotalCompletadas(): Int {
        var devolver = 0
        listaTareas.value.toMutableList().forEach { tarea ->
            if (tarea.getCompletadaKt()) {
                devolver++
            }
        }
        return devolver
    }
    fun tarefasPrioridadeAlta(): Int {
        var devolver = 0
        listaTareas.value.toMutableList().forEach { tarea ->
            if (tarea.getPrioridadeKt() == 3) {
                devolver++
            }
        }
        return devolver
    }
    fun tarefasPrioridadeMedia(): Int {
        var devolver = 0
        listaTareas.value.toMutableList().forEach { tarea ->
            if (tarea.getPrioridadeKt() == 2) {
                devolver++
            }
        }
        return devolver
    }
    fun tarefasPrioridadeBaixa(): Int {
        var devolver = 0
        listaTareas.value.toMutableList().forEach { tarea ->
            if (tarea.getPrioridadeKt() == 1) {
                devolver++
            }
        }
        return devolver
    }

    fun marcoDesmarco(posicion: Int, marcoDesmarco: Boolean) {
        // 1. Obtenemos la lista actual (asumiendo que está en un MutableLiveData o similar)
        // Si tu lista 'Tareas' es una variable global o interna del VM, úsala directamente.
        val listaActual = _listaTareas.value?.toMutableList() ?: return

        // 2. Validamos que la posición exista para evitar crash (IndexOutOfBounds)
        if (posicion in listaActual.indices) {

            // 3. Modificamos el objeto en esa posición
            // NOTA: Esto asume que el objeto es mutable. Si es data class inmutable usa .copy()
            listaActual[posicion].setCompletadaKt(marcoDesmarco)

            // 4. CUMPLE EL REQUISITO TÉCNICO:
            // Asignamos la lista al LiveData para que notifique a la UI automáticamente
            _listaTareas.value = listaActual
        }
    }



}