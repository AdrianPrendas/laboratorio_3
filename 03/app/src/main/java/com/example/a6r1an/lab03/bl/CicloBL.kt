package com.example.a6r1an.lab03.bl

import com.example.a6r1an.lab03.domain.Ciclo
import java.sql.Date
import java.util.*
/**
 * Created by Josue on 25/03/2018.
 */
class CicloBL: BaseBL<Int,Ciclo>{

    override fun create(obj: Ciclo): Ciclo {
        hashTable[obj.numero] = obj
        return obj
    }

    override fun read(key: Int): Ciclo? {
        return hashTable[key]
    }

    override fun readAll(): List<Ciclo> {
        return ArrayList(hashTable.values)
    }

    override fun update(obj: Ciclo): Ciclo? {
        hashTable[obj.numero]?.let{
            hashTable[it.numero] = obj
        }
        return hashTable[obj.numero]
    }

    override fun delete(key: Int): Ciclo?{
        return hashTable.remove(key)
    }

    init{
        hashTable[0] = Ciclo(0, 2018, Date(2018,2,10), Date(2018,6,10))
        hashTable[1] = Ciclo(1, 2018, Date(2018,6,10), Date(2018,11,10))
        hashTable[2] = Ciclo(2, 2019, Date(2019,2,10), Date(2019,6,10))
        hashTable[3] = Ciclo(3, 2019, Date(2019,6,10), Date(2019,11,10))
        hashTable[4] = Ciclo(4, 2020, Date(2020,2,10), Date(2020,6,10))
        hashTable[5] = Ciclo(5, 2020, Date(2020,6,10), Date(2020,11,10))
        hashTable[6] = Ciclo(6, 2021, Date(2021,2,10), Date(2021,6,10))
        hashTable[7] = Ciclo(7, 2021, Date(2021,6,10), Date(2021,11,10))
    }
    private object Holder { val INSTANCE = CicloBL() }
    companion object {
        val hashTable = Hashtable<Int, Ciclo>()
        val instance : CicloBL by lazy{ Holder.INSTANCE }
    }
}

