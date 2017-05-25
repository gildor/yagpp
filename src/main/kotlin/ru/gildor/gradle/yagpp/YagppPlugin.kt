/*
 * Copyright 2017 Andrey Mischenko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@file:Suppress("unused")

package ru.gildor.gradle.yagpp

import org.gradle.api.Plugin
import org.gradle.api.Project
import ru.gildor.gradle.yagpp.sources.ProjectPropertiesSource
import ru.gildor.gradle.yagpp.sources.PropertiesFileSource
import ru.gildor.gradle.yagpp.sources.SystemEnvSource

class YagppPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.extensions.create("yagpp", YagppExtension::class.java, project)
    }

}

open class YagppExtension(private val project: Project) {
    var sources = mutableListOf(
            SystemEnvSource,
            PropertiesFileSource(project.file("local.properties"), required = false),
            ProjectPropertiesSource(project)
    )

    operator fun get(prop: String): String? {
        return sources.firstOrNull { it.containsProp(prop) }?.getProp(prop)
    }

    operator fun get(prop: String, default: String) = this[prop] ?: default

    fun getOrThrow(prop: String) = this[prop] ?: throw IllegalStateException("Property $prop not found in $sources of project $project")
}

