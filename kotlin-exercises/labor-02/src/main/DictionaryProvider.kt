package main

object DictionaryProvider {
    fun createDictionary(dictionaryType: DictionaryType): IDictionary{
        return when (dictionaryType){
            DictionaryType.ARRAY_LIST -> ListDictionary.instance
            DictionaryType.TREE_SET -> TreeSetDictionary.instance
            DictionaryType.HASH_SET -> HashSetDictionary.instance
        }
    }
}