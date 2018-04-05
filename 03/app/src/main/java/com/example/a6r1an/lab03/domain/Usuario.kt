package com.example.a6r1an.lab03.domain

/**
 * Created by Josue on 25/03/2018.
 */
open class Usuario(var password: String,var tipo: Int){
    companion object {
        val ADMIN = 0
        val STUDENT = 1
        val PROFESOR = 2
    }
}
