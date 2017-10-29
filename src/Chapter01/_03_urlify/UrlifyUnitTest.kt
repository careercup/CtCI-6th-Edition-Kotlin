package Chapter01._03_urlify

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class UrlifyUnitTest {

    @Test
    fun testUriflyMiddleSpace(){
        assertEquals("Ped%20ram", Urlify().urlify("Ped ram  ".toCharArray(), 7))
        assertEquals("Ped%20ram", Urlify().urlifyAlt("Ped ram  ", 7))
    }

    @Test
    fun testUriflyLeadingSpace(){
        assertEquals("%20Pedram", Urlify().urlify(" Pedram  ".toCharArray(), 7))
        assertEquals("%20Pedram", Urlify().urlifyAlt(" Pedram  ", 7))
    }

    @Test
    fun testUriflyTrailingSpace(){
        assertEquals("Pedram%20%20", Urlify().urlify("Pedram      ".toCharArray(), 8))
        assertEquals("Pedram%20%20", Urlify().urlifyAlt("Pedram      ", 8))
    }

    @Test
    fun testUriflyNoSpace(){
        assertEquals("Pedram", Urlify().urlify("Pedram".toCharArray(), 6))
        assertEquals("Pedram", Urlify().urlifyAlt("Pedram", 6))
    }

    @Test
    fun testUriflyExtraSpaces(){
        assertEquals("Ped%20ram     ", Urlify().urlify("Ped ram       ".toCharArray(), 7))
        assertEquals("Ped%20ram", Urlify().urlifyAlt("Ped ram       ", 7))
    }

    @Test
    fun testUriflyAllTheSpaces(){
        assertEquals("P%20e%20d%20r%20a%20m", Urlify().urlify("P e d r a m          ".toCharArray(), 11))
        assertEquals("P%20e%20d%20r%20a%20m", Urlify().urlifyAlt("P e d r a m          ", 11))
    }


}