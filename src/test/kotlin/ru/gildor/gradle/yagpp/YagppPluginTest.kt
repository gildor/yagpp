package ru.gildor.gradle.yagpp

import org.junit.Assert.assertTrue
import org.junit.Test
import ru.gildor.gradle.testutils.GradleBaseTest

class YagppPluginTest : GradleBaseTest() {
    val pluginId = "ru.gildor.gradle.yapp"
    val propMarker = "printProp >>>"
    fun printPropTask(propName: String) = """
        task("printProp") {
            doLast {
                println("$propMarker " + yagpp.get("$propName"))
            }
        }
    """

    @Test
    fun testInit() {
        createBuildFile("""
            plugins { id "$pluginId" }

            ${printPropTask("hi")}
        """)
                .withArguments(":printProp", "-Phi=hello")
                .build()
                .apply {
                    println(output)
                    assertTrue(output.contains("$propMarker hello"))
                }
    }
}