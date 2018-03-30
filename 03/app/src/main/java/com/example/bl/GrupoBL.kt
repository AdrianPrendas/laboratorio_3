package com.example.bl

import com.example.a6r1an.lab03.domain.Grupo
import java.util.*

/**
 * Created by a6r1a on 30/3/2018.
 */
class GrupoBL: BaseBL<Int,Grupo>{

    override fun create(obj: Grupo): Grupo {
        hashTable[obj.nmeroGrupo] = obj
        return obj
    }

    override fun read(key: Int): Grupo? {
        return hashTable[key]
    }

    override fun readAll(): List<Grupo> {
        return ArrayList(hashTable.values)
    }

    override fun update(obj: Grupo): Grupo? {
        hashTable[obj.nmeroGrupo]?.let{
            hashTable[it.nmeroGrupo] = obj
        }
        return hashTable[obj.nmeroGrupo]
    }

    override fun delete(key: Int): Grupo?{
        return hashTable.remove(key)
    }
    init{
        var nE = Hashtable<Int,Int>()
        nE[813156487] = 100
        nE[908069482] = 90
        nE[118510669] = 80
        nE[494658212] = 70
        nE[673424513] = 70
        nE[876415060] = 60
        nE[984357664] = 50
        nE[964465378] = 40
        nE[769438762] = 30
        nE[368377663] = 67
        hashTable[0] = Grupo(0, 0, 200,"LUNES Y JUEVES 8AM - 10AM",476576973, nE)
        hashTable[1] = Grupo(1, 0, 203,"LUNES Y JUEVES 2PM - 4:40PM",647037832, nE)
    }
    private object Holder { val INSTANCE = GrupoBL() }
    companion object {
        val hashTable = Hashtable<Int, Grupo>()
        val instance : GrupoBL by lazy{ Holder.INSTANCE }
    }
}

