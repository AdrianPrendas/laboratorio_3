package com.example.a6r1an.lab03.domain

/**
 * Created by Josue on 25/03/2018.
 */

data class Grupo(
        var ciclo: Int,
        var curso: Int,
        var nmeroGrupo: Int,
        var horario: String,
        var profesor: Int,
        var estudiatesNotas: LinkedHashMap<Int,Int>
)