package com.example.a6r1an.lab03.bl

import com.example.a6r1an.lab03.domain.Carrera
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by Josue on 26/03/2018.
 */
class CarreraBL private constructor(): BaseBL<Int, Carrera>{
    override fun create(obj: Carrera): Carrera {
        hashTable[obj.codigo] = obj
        return obj
    }

    override fun read(key: Int): Carrera? {
        return hashTable[key]
    }

    override fun readAll(): List<Carrera> {
        return ArrayList(hashTable.values)
    }

    override fun update(obj: Carrera): Carrera? {
        hashTable[obj.codigo]?.let{
            hashTable[it.codigo] = obj
        }
        return hashTable[obj.codigo]
    }

    override fun delete(key: Int): Carrera?{
        return hashTable.remove(key)
    }

    init{
        hashTable[0] = Carrera(0, "Informatica", "Bachillerato", listOf(200,203,204,208,210))
        hashTable[1] = Carrera(1, "Filosofia", "Bachillerato", listOf(400,401,402,406,408))
        hashTable[2] = Carrera(2, "Economia", "Licenciatura", listOf(320,321,332,338,339))
        hashTable[3] = Carrera(3, "Biologia", "Licenciatura", listOf(101,102,109,107,108))
        hashTable[4] = Carrera(4, "Administracion", "Bachillerato", listOf(500,502,505,506,509))
    }

    private object Holder { val INSTANCE = CarreraBL() }

    companion object {
        val hashTable = Hashtable<Int, Carrera>()
        val instance : CarreraBL by lazy{ Holder.INSTANCE }
    }
}
