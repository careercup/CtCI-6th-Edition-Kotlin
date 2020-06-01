package Chapter01._01_is_unique

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class IsUniqueUnitTest {

    @Test
    fun testIsUniqueEmptyString() {
        assertEquals(true, IsUnique().isUniqueBest(""))
        assertEquals(true, IsUnique().isUniqueBetter(""))
        assertEquals(true, IsUnique().isUniqueNormal(""))
    }

    @Test
    fun testIsUniqueUnique(){
        assertEquals(true, IsUnique().isUniqueBest("pedram"))
        assertEquals(true, IsUnique().isUniqueBetter("pedram"))
        assertEquals(true, IsUnique().isUniqueNormal("pedram"))
    }

    @Test
    fun testIsUniqueNonUnique(){
        assertEquals(false, IsUnique().isUniqueBest("test"))
        assertEquals(false, IsUnique().isUniqueBetter("test"))
        assertEquals(false, IsUnique().isUniqueNormal("test"))
    }

    @Test
    fun testIsUniqueNotUniqueAtEnd(){
        assertEquals(false, IsUnique().isUniqueBest("estt"))
        assertEquals(false, IsUnique().isUniqueBetter("estt"))
        assertEquals(false, IsUnique().isUniqueNormal("estt"))
    }

}