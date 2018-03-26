package com.example.bl

import com.example.a6r1an.lab03.domain.Profesor
import java.util.*

/**
 * Created by Josue on 26/03/2018.
 */
class ProfesorBL private constructor():BaseBL<Int, Profesor>{
    override fun create(obj: Profesor): Profesor {
        hashTable[obj.cedula] = obj
        return obj
    }

    override fun read(key: Int): Profesor? {
        return hashTable[key]
    }

    override fun readAll(): List<Profesor> {
        return ArrayList(hashTable.values)
    }

    override fun update(obj: Profesor): Profesor? {
        hashTable[obj.cedula]?.let{
            hashTable[it.cedula] = obj
        }
        return hashTable[obj.cedula]
    }

    override fun delete(key: Int): Profesor?{
        return hashTable.remove(key)
    }
    init{
        hashTable[476576973] = Profesor(476576973, "Manuel Varajas Cholico", 87107189, "manuel.varajas.cholico@una.ac.cr")
        hashTable[647037832] = Profesor(647037832, "Lucas Valentin Carlin", 647037832, "lucas.valentin.carlin@una.ac.cr")
        hashTable[329680749] = Profesor(329680749, "Iker Messa Cilva", 329680749, "iker.messa.cilva@una.ac.cr")
        hashTable[806474265] = Profesor(806474265, "Dante Cos Cayetano", 806474265, "dante.cos.cayetano@una.ac.cr")
        hashTable[465596530] = Profesor(465596530, "Thiago Hydalgo Calzada",465596530, "thiago.hydalgo.calzada@una.ac.cr")
        hashTable[359435244] = Profesor(359435244, "Samuel Huitzil Briones", 359435244, "samuel.huitzil.briones@una.ac.cr")
        hashTable[473420434] = Profesor(473420434, "Nicolas Orsua Sains", 473420434, "nicolas.orsua.sains@una.ac.cr")
        hashTable[867263211] = Profesor(867263211, "Javier Barientos Harris", 867263211, "javier.barientos.harris@una.ac.cr")
        hashTable[386748361] = Profesor(386748361, "Adrian Belasques Natividad", 386748361, "adrian.belasques.natividad@una.ac.cr")
        hashTable[863171876] = Profesor(863171876, "Maximiliano Santos Santellan", 51007477, "maximiliano.santos.santellan@una.ac.cr")
    }
    private object Holder { val INSTANCE = ProfesorBL() }
    companion object {
        val hashTable = Hashtable<Int, Profesor>()
        val instance : ProfesorBL by lazy{ Holder.INSTANCE }
    }
}
