package Chapter01._01_is_unique

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class IsUniqueUnitTest {

    @Test
    fun testIsUniqueBestEmptyString() {
        assertEquals(true, IsUnique().isUniqueBest(""))
    }

    @Test
    fun testIsUniqueBestUnique(){
        assertEquals(true, IsUnique().isUniqueBest("pedram"))
    }

    @Test
    fun testIsUniqueBestNonUnique(){
        assertEquals(false, IsUnique().isUniqueBest("test"))
    }

    @Test
    fun testIsUniqueBetterEmptyString() {
        assertEquals(true, IsUnique().isUniqueBetter(""))
    }

    @Test
    fun testIsUniqueBetterUnique(){
        assertEquals(true, IsUnique().isUniqueBetter("pedram"))
    }

    @Test
    fun testIsUniqueBetterNonUnique(){
        assertEquals(false, IsUnique().isUniqueBetter("test"))
    }

    @Test
    fun testIsUniqueNormalEmptyString() {
        assertEquals(true, IsUnique().isUniqueNormal(""))
    }

    @Test
    fun testIsUniqueNormalUnique(){
        assertEquals(true, IsUnique().isUniqueNormal("pedram"))
    }

    @Test
    fun testIsUniqueNormalNonUnique(){
        assertEquals(false, IsUnique().isUniqueNormal("test"))
    }

    @Test
    fun testIsUniqueNormalNonUniqueAtEnd(){
        assertEquals(false, IsUnique().isUniqueNormal("estt"))
    }

}