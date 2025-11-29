package com.example.xestortarefas

class Tarea {
    private var nome: String = ""
        get() = field
        set(value) {
            field = value
        }

    private var prioridade: Int = 0
        get() = field
        set(value) {
            field = value
        }
    private var completada: Boolean = false
        get() = field
        set(value) {
            field = value
        }

    fun getNomeKt(): String = nome
    fun getPrioridadeKt(): Int = prioridade
    fun getCompletadaKt(): Boolean = completada
    fun setNomeKt(valor: String) {
        nome = valor
    }
    fun setPrioridadeKt(valor: Int) {
        prioridade = valor
    }
    fun setCompletadaKt(valor: Boolean) {
        completada = valor
    }

    constructor(completada: Boolean, prioridade: Int, nome: String) {
        this.completada = completada
        this.prioridade = prioridade
        this.nome = nome
    }
}