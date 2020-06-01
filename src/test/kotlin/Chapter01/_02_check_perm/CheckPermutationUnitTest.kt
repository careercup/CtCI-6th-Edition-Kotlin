package Chapter01._02_check_perm

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CheckPermutationUnitTest {

    @Test
    fun testCheckPermEmptyString() {
        assertEquals(true, CheckPermutation().checkPermNormal("", ""))
        assertEquals(true, CheckPermutation().checkPermBetter("", ""))
    }

    @Test
    fun testCheckPermUnequalLengths() {
        assertEquals(false, CheckPermutation().checkPermNormal("a", "aa"))
        assertEquals(false, CheckPermutation().checkPermBetter("a", "aa"))
    }

    @Test
    fun testCheckPerm() {
        assertEquals(true, CheckPermutation().checkPermNormal("pedram", "adepmr"))
        assertEquals(true, CheckPermutation().checkPermBetter("pedram", "adepmr"))
    }

    @Test
    fun testCheckPermCaseSensitivity() {
        assertEquals(false, CheckPermutation().checkPermNormal("pEdram", "adepmr"))
        assertEquals(false, CheckPermutation().checkPermBetter("pEdram", "adepmr"))
    }

    @Test
    fun testCheckPermNotPerm() {
        assertEquals(false, CheckPermutation().checkPermNormal("pedram", "pedaam"))
        assertEquals(false, CheckPermutation().checkPermBetter("pedram", "pedaam"))
    }

    @Test
    fun testCheckPermSpaceIncluded() {
        assertEquals(false, CheckPermutation().checkPermNormal("pedram", "pedram "))
        assertEquals(false, CheckPermutation().checkPermBetter("pedram", "pedram "))
    }

}