package main

import java.io.File
class ListDictionary : IDictionary {
    private val dict = mutableListOf<String>()

    companion object {
        public val instance: ListDictionary by lazy { ListDictionary() }
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