package Chapter01._04_palindrome_perm

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class IsPalindromePermUnitTest {

    @Test
    fun testIsPalindromePermTrue() {
        assertEquals(true, IsPalindromePerm().isPalindromePerm("pdepdrremama"))
    }

    @Test
    fun testIsPalindromePermFalse() {
        assertEquals(false, IsPalindromePerm().isPalindromePerm("pedram"))
    }

    @Test
    fun testIsPalindromePermTrueWithSpaces() {
        assertEquals(true, IsPalindromePerm().isPalindromePerm("pdepdrremama"))
    }


    @Test
    fun testIsPalindromePermFalseWithSpaces() {
        assertEquals(false, IsPalindromePerm().isPalindromePerm("ped ram"))
    }

    @Test
    fun testIsPalindromePermTrueWithJunkChars() {
        assertEquals(true, IsPalindromePerm().isPalindromePerm("pde  pd6rr--emam%a"))
    }

}