package ru.gildor.gradle.yagpp.sources

class StaticPropertiesSource(private val map: Map<String, String>) : PropertiesSource {
    override fun containsProp(propName: String) = map.containsKey(propName)

    override fun getProp(propName: String) = map[propName]
            ?: throw IllegalArgumentException("Property $propName not found in $map")
}