package com.example.bl

import com.example.a6r1an.lab03.domain.Alumno
import java.sql.Date
import java.util.*
/**
 * Created by Josue on 25/03/2018.
 */
class AlumnoBL: BaseBl<Int,Alumno>{

    override fun create(obj: Alumno): Alumno {
        hashTable[obj.cedula] = obj
        return obj
    }

    override fun read(key: Int): Alumno? {
        return hashTable[key]
    }

    override fun readAll(): List<Alumno> {
        return ArrayList(hashTable.values)
    }

    override fun update(obj: Alumno): Alumno? {
        hashTable[obj.cedula]?.let{
            hashTable[it.cedula] = obj
        }
        return hashTable[obj.cedula]
    }

    override fun delete(key: Int): Alumno?{
        return hashTable.remove(key)
    }

    init{
        hashTable[813156487] = Alumno(813156487, "Angel Yvanes Gerardo", 67127241, "angel.yvanes.gerardo@una.ac.crr", Date(2018, 3, 25), 1)
        hashTable[908069482] = Alumno(908069482, "Carlos Asencio Ysidro", 59761445, "carlos.asencio.ysidro@una.ac.cr", Date(2018, 3, 25), 1)
        hashTable[118510669] = Alumno(118510669, "Emiliano Sepulbeda Troche", 83342208, "emiliano.sepulbeda.troche@una.ac.cr", Date(2018, 3, 25), 1)
        hashTable[494658212] = Alumno(494658212, "Santino Peredo Dongu", 50470271, "santino.peredo.dongu@una.ac.cr", Date(2018, 3, 25), 1)
        hashTable[673424513] = Alumno(673424513, "Tomas Velasco Clemente", 69144510, "tomas.velasco.clemente@una.ac.cr", Date(2018, 3, 25), 1)
        hashTable[876415060] = Alumno(876415060, "Benjamin Covos Brusiaga", 71116623, "benjamin.covos.brusiaga@una.ac.cr", Date(2018, 3, 25), 1)
        hashTable[984357664] = Alumno(984357664, "Gael Mancilla Moia", 82545857, "gael.mancilla.moia@una.ac.cr", Date(2018, 3, 25), 1)
        hashTable[964465378] = Alumno(964465378, "Emmanuel Canchola Espejo", 65883938, "emmanuel.canchola.espejo@una.ac.cr", Date(2018, 3, 25), 1)
        hashTable[769438762] = Alumno(769438762, "Dylan Montecillo Balderas", 64475384, "dylan.montecillo.balderas@una.ac.cr", Date(2018, 3, 25), 1)
        hashTable[368377663] = Alumno(368377663, "Emiliano Aguado Sifuentes", 61059469, "emiliano.aguado.sifuentes@una.ac.cr", Date(2018, 3, 25), 1)
    }
    private object Holder { val INSTANCE = AlumnoBL() }
    companion object {
        val hashTable = Hashtable<Int, Alumno>()
        val instance : AlumnoBL by lazy{ Holder.INSTANCE }
    }
}

