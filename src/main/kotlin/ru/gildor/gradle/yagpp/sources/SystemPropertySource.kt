package ru.gildor.gradle.yagpp.sources

object SystemPropertySource : PropertiesSource {
    override fun containsProp(propName: String) = System.getProperties().contains(propName)

    override fun getProp(propName: String) = System.getProperty(propName) ?:
            throw IllegalStateException("Property $propName not found in System properties")
}