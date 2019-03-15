description = "JAXB adapters for Java 8 Date and Time API (JSR-310) types"

dependencies {
    api(platform("org.glassfish.jaxb:jaxb-bom:2.3.2"))
    api("jakarta.xml.bind:jakarta.xml.bind-api")

    testRuntimeOnly("org.glassfish.jaxb:jaxb-runtime")
}
