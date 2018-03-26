package com.example.a6r1an.lab03.domain


import java.util.Date
/**
 * Created by Josue on 25/03/2018.
 * see:
 *      https://medium.com/@DarrenAtherton/intro-to-data-classes-in-kotlin-7f956d54365c
 */
data class Alumno(
        var cedula: Int,
        var nombre: String,
        var telefono: Int,
        var email: String,
        var fechaNacimiento: Date,
        var carrera: Int
): Usuario(password = "abcd")