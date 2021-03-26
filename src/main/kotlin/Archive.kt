import ResponseToPrint.*

object Archive {
    private val archive = mutableListOf<String>()
    private val invertedArchive = invertedIndex()

    fun add(str: String) {
        archive.add(str)
    }

    /* If the strategy is ALL, the program should print lines containing all the words from the query */
    fun  findAll() {
        println(DataSearchRequest.message)
        val dataSearch = readLine()!!.split(" ")
        var dataResponse = ""
        var count = 0
        if (archive.any { str: String -> dataSearch.all { it.toLowerCase() in str.toLowerCase() } }) {
            for (data in archive) {
                if (dataSearch.all { it.toLowerCase() in data.toLowerCase() }) {
                    dataResponse += data + "\n"
                    count++
                }
            }
            println("\n$count persons found:")
            print(dataResponse)
        } else {
            println(SearchResponse.message)
        }
    }

    /* If the strategy is ANY, the program should print the lines containing at least one word from the query */
    fun  findAny() {
        println(DataSearchRequest.message)
        val dataSearch = readLine()!!.split(" ")
        var dataResponse = ""
        var count = 0
        if (archive.any { str: String ->  dataSearch.any { it.toLowerCase() in str.toLowerCase() } }) {
            for (data in archive) {
                if (dataSearch.any { it.toLowerCase() in data.toLowerCase() }) {
                    dataResponse += data + "\n"
                    count++
                }
            }
            println("\n$count persons found:")
            print(dataResponse)
        } else {
            println(SearchResponse.message)
        }
    }

    /* If the strategy is NONE, the program should print lines that do not contain words from the query at all */
    fun  findNone() {
        println(DataSearchRequest.message)
        val dataSearch = readLine()!!.split(" ")
        var dataResponse = ""
        var count = 0
        if (archive.any { str: String -> dataSearch.none { it.toLowerCase() in str.toLowerCase() } }) {
            for (data in archive) {
                if (dataSearch.none { it.toLowerCase() in data.toLowerCase() }) {
                    dataResponse += data + "\n"
                    count++
                }
            }
            println("\n$count persons found:")
            print(dataResponse)
        } else {
            println(SearchResponse.message)
        }
    }

    /*  using the inverted index for searching operations */
    fun find() {
        println(DataSearchRequest.message)
        val dataSearch = readLine()!!
        if (dataSearch.toLowerCase() in invertedArchive) {
            println("\n${invertedArchive[dataSearch.toLowerCase()]?.size} persons found:")
            for (i in invertedArchive[dataSearch.toLowerCase()]!!) {
                println(archive[i])
            }
        } else {
            println(SearchResponse.message)
        }
    }

    fun print() {
        println(PrintList.message)
        for (data in archive) {
            println(data)
        }
    }

    /* building a data structure called Inverted Index. It maps each word to all positions/lines/documents
    * in which the word occurs. */
    private fun invertedIndex(): MutableMap<String,MutableSet<Int>> {
        val invertedArchive = mutableMapOf<String,MutableSet<Int>>()
        for (data in archive) {
            for (word in data.split(" ")) {
                for (line in archive) {
                    if (word in line) {
                        if (word.toLowerCase() in invertedArchive) {
                            invertedArchive[word.toLowerCase()]?.add(archive.indexOf(line))
                        } else {
                            invertedArchive[word.toLowerCase()] = mutableSetOf(archive.indexOf(line))
                        }
                    }
                }
            }
        }
        return invertedArchive
    }
}