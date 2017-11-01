package Chapter01._05_one_away

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class OneAwayUnitTest {

    @Test
    fun testOneAwayIdentical() {
        assertEquals(true, OneAway().oneAway("pedram", "pedram"))
    }

    @Test
    fun testOneAwayInsertStart() {
        assertEquals(true, OneAway().oneAway("pedram", "edram"))
    }

    @Test
    fun testOneAwayInsertMiddle() {
        assertEquals(true, OneAway().oneAway("pedram", "peram"))
    }

    @Test
    fun testOneAwayInsertEnd() {
        assertEquals(true, OneAway().oneAway("pedram", "pedra"))
    }

    @Test
    fun testOneAwayModifyStart() {
        assertEquals(true, OneAway().oneAway("pedram", "nedram"))
    }

    @Test
    fun testOneAwayModifyMiddle() {
        assertEquals(true, OneAway().oneAway("pedram", "pedpam"))
    }

    @Test
    fun testOneAwayModifyEnd() {
        assertEquals(true, OneAway().oneAway("pedram", "pedran"))
    }

    @Test
    fun testOneAwayTwoAwayStart() {
        assertEquals(false, OneAway().oneAway("ppeedram", "pedram"))
    }

    @Test
    fun testOneAwayTwoAwayStartAndEnd() {
        assertEquals(false, OneAway().oneAway("ppedram", "pedran"))
    }

    @Test
    fun testOneAwayTwoAwayEnd() {
        assertEquals(false, OneAway().oneAway("pedram", "pedrann"))
    }

}