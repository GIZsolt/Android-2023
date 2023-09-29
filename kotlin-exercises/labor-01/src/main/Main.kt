package main

fun sum(a:Int, b:Int) = a + b;
fun main(args: Array<String>) {
    //exercise 1
    val a:Int = 5;
    val b = 8
    //println("$a + $b = ${sum(a, b)}")

    //exercise 2
    val daysOfWeek = listOf("Monday", "Thuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
    for (day in daysOfWeek){
        //println(day);
    }

    val startingWithT = daysOfWeek.filter {it.startsWith("T")}
    //startingWithT.forEach{println(it)};

    val containingLetterE = daysOfWeek.filter {it.contains("e")}
    //containingLetterE.forEach{println(it)};

    val lengthOfDays = daysOfWeek.filter {it.length == 6}
    //lengthOfDays.forEach{println(it)};


    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}