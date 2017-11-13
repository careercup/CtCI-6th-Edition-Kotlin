package Chapter01._06_string_compressor

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class StringCompressorUnitTest {

    @Test
    fun testStrCompressor() {
        assertEquals("a2b1c8d1e1F4g7h1i1", StringCompressor().compress("aabccccccccdeFFFFggggggghi"))
    }

    @Test
    fun testStrCompressorAllTheSame() {
        assertEquals("a10", StringCompressor().compress("aaaaaaaaaa"))
    }

    @Test
    fun testStrCompressorAllOnes() {
        assertEquals("pedram", StringCompressor().compress("pedram"))
    }


    @Test
    fun testStrCompressorIllegalChars() {
        assertFailsWith<IllegalArgumentException> {
            StringCompressor().compress("aa/bc")
        }
    }

}