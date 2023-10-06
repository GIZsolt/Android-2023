package main

interface IDictionary {
    fun add(word: String)
    fun find(word: String): Boolean
    fun size(): Int
}