package com.example.a6r1an.lab03.domain

import java.util.*

/**
 * Created by Josue on 25/03/2018.
 */

data class Grupo(
        var nmeroGrupo: Int,
        var ciclo: Int,
        var curso: Int,
        var horario: String,
        var profesor: Int,
        var estudiatesNotas: Hashtable<Int, Int>
)