description = "JAXB adapters for Java 8 Date and Time API (JSR-310) types"

dependencies {
    api(platform("org.glassfish.jaxb:jaxb-bom:2.3.2"))
    api("jakarta.xml.bind:jakarta.xml.bind-api")

    implementation("com.google.code.findbugs:jsr305:3.0.2")

    testRuntimeOnly("org.glassfish.jaxb:jaxb-runtime")
}
