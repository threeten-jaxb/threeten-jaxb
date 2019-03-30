description = "JAXB adapters for ThreeTen-Extra"

tasks.withType<Javadoc> {
    options {
        this as StandardJavadocDocletOptions
        links("https://www.threeten.org/threeten-extra/apidocs/")
    }
}

dependencies {
    api("org.threeten:threeten-extra:1.5.0")
}
