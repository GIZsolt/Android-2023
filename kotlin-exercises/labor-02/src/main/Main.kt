package main

enum class DictionaryType{
    ARRAY_LIST,
    TREE_SET,
    HASH_SET
}

fun main(){
    val dict: IDictionary = DictionaryProvider.createDictionary(DictionaryType.ARRAY_LIST)
    //val dict: IDictionary = DictionaryProvider.createDictionary(DictionaryType.TREE_SET)
    //val dict: IDictionary = DictionaryProvider.createDictionary(DictionaryType.HASH_SET)
    println("Number of words: ${dict.size()}")
    var word: String?
    while(true){
        print("What to find? ")
        word = readLine()
        if( word.equals("quit")){
            break
        }
        println("Result: ${word?.let { dict.find(it) }}")
    }
}
