package ru.gildor.gradle.yagpp.sources

class PropertiesFileSource(private val propsFile: java.io.File, required: Boolean) : PropertiesSource {
    private val props by lazy {
        java.util.Properties().apply {
            if (propsFile.exists() && propsFile.canRead()) {
                load(propsFile.reader())
            } else if (required) {
                throw org.gradle.api.GradleException("Properties file $propsFile not found or cannot be read")
            }
        }
    }

    override fun containsProp(propName: String) = props.containsKey(propName)

    override fun getProp(propName: String) = props.getProperty(propName) ?:
            throw IllegalStateException("Property $propName not found in properties file ${propsFile.absoluteFile}")
}
