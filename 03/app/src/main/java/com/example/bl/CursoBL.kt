package com.example.bl

import com.example.a6r1an.lab03.domain.Curso
import java.sql.Date
import java.util.*
/**
 * Created by Josue on 26/03/2018.
 */
class CursoBL: BaseBL<Int,Curso>{

    override fun create(obj: Curso): Curso {
        hashTable[obj.codigo] = obj
        return obj
    }

    override fun read(key: Int): Curso? {
        return hashTable[key]
    }

    override fun readAll(): List<Curso> {
        return ArrayList(hashTable.values)
    }

    override fun update(obj: Curso): Curso? {
        hashTable[obj.codigo]?.let{
            hashTable[it.codigo] = obj
        }
        return hashTable[obj.codigo]
    }

    override fun delete(key: Int): Curso?{
        return hashTable.remove(key)
    }

    init{
        hashTable[200] = Curso(200, "FUNDAMENTOS DE INFORMATICA", 3, 2)
        hashTable[203] = Curso(203, "ESTRUCTURAS DISCRETAS", 3, 2)
        hashTable[204] = Curso(204, "PROGRAMACION II", 4, 2)
        hashTable[208] = Curso(208, "COMUNICACION y REDES", 3, 2)
        hashTable[210] = Curso(210, "INGENIERIA EN SISTEMAS I", 4, 4)
        hashTable[400] = Curso(400, "PROBLEMAS FILOSOFICOS DE LA ANTIGUEDAD", 3, 3)
        hashTable[401] = Curso(401, "INTRODUCCION A LA EVALUACION LOGICA DE LOS RAZONAM", 3, 3)
        hashTable[402] = Curso(402, "INTRODUCCION A LOS PROBLEMAS DE LA METAFISICA", 3, 3)
        hashTable[406] = Curso(406, "PROBLEMAS FILOSOFICOS DE LA EPOCA MODERNA", 4, 4)
        hashTable[408] = Curso(408, "INTRODUCCION A LOS PROBLEMAS DE LA ETICA", 3, 3)
        hashTable[320] = Curso(320, "Gestión y Administración de Proyectos", 4, 4)
        hashTable[321] = Curso(321, "Taller de Investigación    ", 4, 4)
        hashTable[332] = Curso(332, "Economía Latinoamericana", 3, 3)
        hashTable[338] = Curso(338, "Teorías del Estado", 3, 3)
        hashTable[339] = Curso(339, "Planificación Financiera", 3, 3)
        hashTable[101] = Curso(101, "Zoología General I", 4, 3)
        hashTable[102] = Curso(102, "Botánica General", 4, 3)
        hashTable[109] = Curso(109, "Biología de Microorganismos", 3, 2)
        hashTable[107] = Curso(107, "Genética General", 4, 3)
        hashTable[108] = Curso(108, "Fisiología Animal", 4, 3)
        hashTable[500] = Curso(500, "Principios de Administración", 3, 3)
        hashTable[502] = Curso(502, "Sistemas Informáticos para Administradores ", 4, 3)
        hashTable[505] = Curso(505, "Estado y Administración Pública", 3, 2)
        hashTable[506] = Curso(506, "La Investigación Aplicada a la Administración", 3, 3)
        hashTable[509] = Curso(509, "Contabilidad General", 3, 3)
    }
    private object Holder { val INSTANCE = CursoBL() }
    companion object {
        val hashTable = Hashtable<Int, Curso>()
        val instance : CursoBL by lazy{ Holder.INSTANCE }
    }
}

