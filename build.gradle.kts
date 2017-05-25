group = "ru.gildor.gradle.yagpp"
version = "0.1"
description = "Yet Another Properties Plugin for Gradle"

plugins {
    `maven-publish`
    `java-gradle-plugin`
    id("org.jetbrains.kotlin.jvm") version "1.1.2-2"
    id("com.gradle.plugin-publish") version "0.9.7"
}

repositories {
    jcenter()
}

gradlePlugin {
    plugins.invoke {
        "yagpp" {
            id = project.group as String
            implementationClass = "ru.gildor.gradle.yagpp.YagppPlugin"
        }
    }
}

pluginBundle {
    website = "https://github.com/gildor/yagpp"
    vcsUrl = "$website.git"
    description = project.description
    tags = listOf("properties", "configuration", "environment variables")

    plugins.invoke {
        "yagpp" {
            id = project.group as String
            displayName = "Yet Another Properties Plugin for Gradle"
        }
    }
}

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib:1.1.2-2")
    compile(gradleScriptKotlinApi())
    testCompile("junit:junit:4.12")
}
