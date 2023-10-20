package main

import java.io.File
import java.util.HashSet

class HashSetDictionary() : IDictionary {
    private val dict = HashSet<String>()

    init {
        val file = File("words.txt")
        if (file.exists()){
            file.forEachLine { line -> add(line.trim()) }
        }
    }
    companion object {
        public val instance: HashSetDictionary by lazy { HashSetDictionary() }

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