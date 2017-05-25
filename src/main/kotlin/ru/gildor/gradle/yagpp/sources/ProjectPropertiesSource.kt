package ru.gildor.gradle.yagpp.sources

class ProjectPropertiesSource(private val project: org.gradle.api.Project) : PropertiesSource {
    override fun containsProp(propName: String) = project.hasProperty(propName)

    override fun getProp(propName: String) = project.property(propName) as String
}