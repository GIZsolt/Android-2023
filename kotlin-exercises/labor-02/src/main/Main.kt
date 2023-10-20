package main

import java.time.LocalDate
import java.util.*

enum class DictionaryType{
    ARRAY_LIST,
    TREE_SET,
    HASH_SET
}

fun String.printMonogram() {
    val monogram = this.split(" ")
        .map { it.first() }
        .joinToString("")
    println(monogram)
}

fun List<String>.joinWithSeparator(separator: String): String {
    return joinToString(separator)
}

fun List<String>.findLongestString(): String? {
    return this.maxByOrNull { it.length }
}

data class Date(val year: Int, val month: Int, val day: Int) : Comparable<Date> {
    override fun compareTo(other: Date): Int {
        if (year != other.year) {
            return year - other.year
        }
        if (month != other.month) {
            return month - other.month
        }
        return day - other.day
    }
}

fun Date.isValid(): Boolean {
    return isValidYear() && isValidMonth() && isValidDay()
}

fun Int.isLeapYear():Boolean{
    return (this % 4 == 0 && this % 100 != 0) || (this % 400 == 0)
}

fun Date.isValidYear():Boolean{
    return year in 1..LocalDate.now().year
}

fun Date.isValidMonth():Boolean{
    return month in 1..12
}

fun Date.isValidDay():Boolean{
    val daysInMonth = when (month){
        4, 6, 9, 11 -> 30
        2 -> if(year.isLeapYear()) 29 else 28
        else -> 31
    }
    return day in 1..daysInMonth
}

fun generateRandomDate(random: Random): Date {
    val year = random.nextInt(2000,2030)
    val month = random.nextInt(1,13)
    val day = random.nextInt(1,32)
    return Date(year, month, day)
}

fun main(){
    //Problem 1

    /*val dict: IDictionary = DictionaryProvider.createDictionary(DictionaryType.ARRAY_LIST)
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
    }*/

    //Problem 2

    /*val name = "Gal Istvan Zsolt"
    name.printMonogram()*/

    /*val list = listOf("apple", "pear", "melon")
    val separator = ", "
    val result = list.joinWithSeparator(separator)
    println(result)*/

    /*val strings = listOf("apple", "pear", "strawberry", "melon")
    val longest = strings.findLongestString()
    println("Longest string: $longest")*/

    val random = Random()
    val validDates = mutableListOf<Date>()
    while(validDates.size < 10){
        val randomDate = generateRandomDate(random)
        if(randomDate.isValid()){
            validDates.add(randomDate)
        } else{
            println("invalid Date: $randomDate")
        }
    }

    validDates.sort()
    val reversedValidDates = validDates.reversed()


    println("Valid Dates: ")
    validDates.forEach { println(it) }
    println("Reversed Valid Dates: ")
    reversedValidDates.forEach { println(it) }

    val customDateComparator = compareBy<Date>({ it.year }, { it.month }, { it.day })
    validDates.sortWith(customDateComparator)

    println("Sorted Valid Dates (Custom Ordering):")
    validDates.forEach { println(it) }
}
