package main

import java.io.File
import java.util.TreeSet

class TreeSetDictionary : IDictionary {
    private val dict = TreeSet<String>()

    companion object {
        private val instance: TreeSetDictionary by lazy { TreeSetDictionary() }

        fun getInstance(): TreeSetDictionary {
            return instance
        }
    }

    constructor(){
        val file = File("words.txt")
        if (file.exists()){
            file.forEachLine { line -> add(line.trim()) }
        }
    }

    override fun add(word: String) {
        dict.add(word)
    }

    override fun find(word: String): Boolean {
        return dict.contains(word)
    }

    override fun size(): Int {
        return dict.size
    }

    fun getWordsString(): String{
        return dict.joinToString(" ")
    }
}