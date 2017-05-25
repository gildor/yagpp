package ru.gildor.gradle.yagpp.sources

import org.junit.Assert.*
import org.junit.Test

class StaticPropertiesSourceTest {
    fun source() = StaticPropertiesSource(mapOf(
            "foo" to "bar",
            "one" to "1"
    ))

    @Test
    fun containsProp() {
        assertTrue(source().containsProp("foo"))
        assertFalse(source().containsProp("bar"))
        assertFalse(source().containsProp(""))
    }

    @Test
    fun getProp() {
        assertEquals("bar", source().getProp("foo"))
        assertEquals("1", source().getProp("one"))
    }

    @Test(expected = IllegalArgumentException::class)
    fun getUnexcitingProp() {
        source().getProp("bar")
    }
}