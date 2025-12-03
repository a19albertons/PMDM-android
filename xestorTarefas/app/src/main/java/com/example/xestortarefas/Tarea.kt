package com.example.xestortarefas

/**
 * Clase que maneja una entidad llamada tarea para la aplicación xestor Tarefas
 */
class Tarea {
    /**
     * Nombre de la tarea
     */
    private var nome: String = ""

    /**
     * Grado de la prioridad se procesa con un numero entre 1-3
     */
    private var prioridade: Int = 0

    /**
     * Define si la esta completa o no la tarea
     */
    private var completada: Boolean = false


    /**
     * Permite obtener el nombre
     */
    fun getNome(): String = nome

    /**
     * Permite obtener la prioridad
     */
    fun getPrioridade(): Int = prioridade

    /**
     * Permite el estado de la tarea
     */
    fun getCompletada(): Boolean = completada

    /**
     * Permite cambiar el nombre de la tarea
     */
    fun setNome(valor: String) {
        nome = valor
    }

    /**
     * Permite cambiar la prioridad
     */
    fun setPrioridade(valor: Int) {
        prioridade = valor
    }

    /**
     * Permite cambiar el estado de la tarea
     */
    fun setCompletada(valor: Boolean) {
        completada = valor
    }

    /**
     * Construye la tarea requieres todos los campos
     */
    constructor(completada: Boolean, prioridade: Int, nome: String) {
        this.completada = completada
        this.prioridade = prioridade
        this.nome = nome
    }
}