package main

object DictionaryProvider {
    fun createDictionary(dictionaryType: DictionaryType): IDictionary{
        return when (dictionaryType){
            DictionaryType.ARRAY_LIST -> ListDictionary.getInstance()
            DictionaryType.TREE_SET -> TreeSetDictionary.getInstance()
            DictionaryType.HASH_SET -> HashSetDictionary.getInstance()
        }
    }
}