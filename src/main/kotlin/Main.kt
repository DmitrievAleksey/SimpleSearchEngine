import java.io.File
import kotlin.system.exitProcess
import ResponseToPrint.*

fun main(args: Array<String>) {
    val file = File(args[args.indexOf("--data") + 1])
    for (line in file.readLines()) {
        Archive.add(line)
    }

    println(Menu.message)
    var action = readLine()!!.toInt()
    while (action != 0) {
        when (action) {
            1 -> {
                println(StrategyList.message)
                when(SearchStrategy.getStrategy(readLine()!!)) {
                    SearchStrategy.ALL -> Archive.findAll()
                    SearchStrategy.ANY -> Archive.findAny()
                    SearchStrategy.NONE -> Archive.findNone()
                    SearchStrategy.FAST -> Archive.find()
                    else -> println(Error.message)
                }
            }
            2 -> Archive.print()
            0 -> {
                println(Bye.message)
                exitProcess(1)
            }
            else -> println(Error.message)
        }
        println(Menu.message)
        action = readLine()!!.toInt()
    }
    println(Bye.message)
}