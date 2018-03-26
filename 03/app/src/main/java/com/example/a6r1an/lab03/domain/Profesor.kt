package com.example.a6r1an.lab03.domain

/**
 * Created by Josue on 25/03/2018.
 */
data class Profesor(
        var cedula: Int,
        var nombre: String,
        var telefono: Int,
        var email: String
) : Usuario(password = "abcd")