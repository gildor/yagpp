package ru.gildor.gradle.yagpp.sources

interface PropertiesSource {
    fun containsProp(propName: String): Boolean

    fun getProp(propName: String): String
}

