package com.example.a6r1an.lab03.domain

/**
 * Created by Josue on 25/03/2018.
 */

data class Carrera(
        var codigo: Int,
        var nombre: String,
        var titulo: String,
        var cursos: List<Curso>
)