package com.example.bl

/**
 * Created by Josue on 25/03/2018.
 */
interface BaseBl<K,T>{
    fun create(obj: T): T
    fun read(key: K): T?
    fun readAll(): List<T>
    fun update(obj: T): T?
    fun delete(key: K): T?
}