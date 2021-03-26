enum class SearchStrategy(private val label: String) {
    ALL("ALL"),
    ANY("ANY"),
    NONE("NONE"),
    FAST("FAST");

    companion object {
        fun getStrategy(action: String): SearchStrategy? {
            for (strategy in values()) {
                if (action.equals(strategy.label, ignoreCase = true)) return strategy
            }
            return null
        }
    }
}