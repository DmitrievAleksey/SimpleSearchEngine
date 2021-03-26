enum class ResponseToPrint(val message: String) {
    DataSearchRequest("\nEnter a name or email to search all suitable people."),
    SearchResponse("No matching people found."),
    PrintList("\n=== List of people ==="),
    Menu("\n=== Menu ===\n1. Find a person\n2. Print all people\n0. Exit"),
    StrategyList("\nSelect a matching strategy: ALL, ANY, NONE, FAST"),
    Bye("\nBye!"),
    Error("\nIncorrect option! Try again.")
}