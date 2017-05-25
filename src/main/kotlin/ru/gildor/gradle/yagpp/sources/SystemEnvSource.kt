package ru.gildor.gradle.yagpp.sources

object SystemEnvSource : PropertiesSource {
    override fun containsProp(propName: String) = System.getenv().containsKey(propName)

    override fun getProp(propName: String) = System.getenv()[propName] ?:
            throw IllegalStateException("Property $propName not found in System properties")
}