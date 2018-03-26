package com.example.a6r1an.lab03.domain

import java.util.Date

/**
 * Created by Josue on 25/03/2018.
 */

data class Ciclo(
        var numero: Int,
        var anno: Int,
        var fechaInicio: Date,
        var fechaFinal: Date
        )