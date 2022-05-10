class Solutions {
    /**
     * Finds the first "magic index" of a sorted array. If none exists, returns -2147483648.
     * Works the same if values of array are disctinct or not.
     *
     * @return: Index that matches its value, else MIN_VALUE
     */
    fun hasMagicIndex(A: Array<Int>): Int {
        var magicInt = Int.MIN_VALUE
        var i: Int = 0
        val length = A.size

        while (i < length) {
            if (i == A[i]) {
                magicInt = i
                break
            }

            i = if (i < A[i]) A[i] else i + 1
        }

        return magicInt
    }

    /**
     * Recursively builds a powerset
     *
     * @return: Set of all possible subsets
     */
    fun <E> makeSubSets(set: Set<E>): Set<Set<E>> {

        return if (set.isEmpty()) {
            setOf(set)

        } else {
            val saved = set.first()
            val filteredSet = set.minus(saved)
//            println("saved: $saved\nOriginal set after remove: $filteredSet")   // DEBUG

            val subSets = makeSubSets(filteredSet)
            val newSet: MutableSet<Set<E>> = mutableSetOf(setOf())

            subSets.forEach { newSet.add(it.plus(saved)) }
//            println("subsets: $subSets  newSet: $newSet")       // DEBUG
            subSets + newSet
        }
    }

    /**
     * Uses Russian Peasant multiplication
     *
     * @return: Product of original two args
     */
    fun recursiveMultiply(a: Int, b: Int): Int {
        return if (b > 0) {
            recursiveMultiply(a shl 1, b shr 1).plus(if (b and 1 != 0) a else 0)
        } else {
            0
        }
    }
}