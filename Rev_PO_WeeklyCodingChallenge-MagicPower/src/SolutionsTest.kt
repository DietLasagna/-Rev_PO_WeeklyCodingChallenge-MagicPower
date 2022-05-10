import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class SolutionsTest {
    private val s = Solutions()

    @Test
    fun hasMagicIndex() {
        assertTrue { s.hasMagicIndex(arrayOf(0, 5)) == 0 }

        assertTrue { s.hasMagicIndex(arrayOf(1, 2, 3, 4, 5)) == Int.MIN_VALUE }

        assertTrue { s.hasMagicIndex(arrayOf(1, 2, 6)) == Int.MIN_VALUE }

        assertTrue { s.hasMagicIndex(arrayOf(1, 2, 2)) == 2 }
    }

    @Test
    fun subSets() {
        val set = s.makeSubSets(mutableSetOf(1, 2, 3))

        assertTrue { set.contains(mutableSetOf()) }
        assertTrue { set.contains(mutableSetOf(1, 2, 3)) }
        assertTrue { set.contains(mutableSetOf(2)) }
        assertTrue { set.contains(mutableSetOf(1, 3)) }
    }

    @Test
    fun recursiveMultiply() {
        assertEquals(s.recursiveMultiply(2, 10), 20)
        assertEquals(s.recursiveMultiply(10, 2), 20)
        assertEquals(s.recursiveMultiply(343, 2187), 750141)
        assertEquals(s.recursiveMultiply(2, 0), 0)
    }
}