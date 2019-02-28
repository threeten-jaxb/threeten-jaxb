plugins {
    `java-library`
    `maven-publish`
    signing
}

group = "io.github.threeten-jaxb"
version = "1.1.4-SNAPSHOT"

repositories {
    jcenter()
}

dependencies {
    api(platform("org.glassfish.jaxb:jaxb-bom:2.3.2"))
    api("jakarta.xml.bind:jakarta.xml.bind-api")

    implementation("com.google.code.findbugs:jsr305:3.0.2")

    testImplementation("org.junit.jupiter:junit-jupiter:5.4.0")
    testImplementation("org.glassfish.jaxb:jaxb-runtime")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

task<Jar>("sourcesJar") {
    from(sourceSets.main.get().allJava)
    archiveClassifier.set("sources")
}

task<Jar>("javadocJar") {
    from(tasks.javadoc.get().destinationDir)
    archiveClassifier.set("javadoc")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            artifact(tasks["sourcesJar"])
            artifact(tasks["javadocJar"])
            pom {
                name.set("threeten-jaxb")
                description.set("JAXB adapters for Java 8 Date and Time API (JSR-310) types")
                url.set("https://github.com/threeten-jaxb/threeten-jaxb")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("mwkroening")
                        name.set("Martin Kröning")
                        url.set("https://github.com/mwkroening")
                    }
                    developer {
                        id.set("migesok")
                        name.set("Mikhail Sokolov")
                        url.set("https://github.com/migesok")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/threeten-jaxb/threeten-jaxb.git")
                    developerConnection.set("scm:git:ssh://github.com/threeten-jaxb/threeten-jaxb.git")
                    url.set("https://github.com/threeten-jaxb/threeten-jaxb")
                }
            }
        }
    }
    repositories {
        maven {
            val releasesRepoUrl = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2")
            val snapshotsRepoUrl = uri("https://oss.sonatype.org/content/repositories/snapshots")
            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
            credentials {
                val ossrhUsername: String? by project
                username = ossrhUsername
                val ossrhPassword: String? by project
                password = ossrhPassword
            }
        }
    }
}

signing {
    sign(publishing.publications["mavenJava"])
}

tasks {
    jar {
        manifest {
            attributes(
                    mapOf("Implementation-Title" to project.name,
                            "Implementation-Version" to project.version)
            )
        }
    }
    test {
        useJUnitPlatform()
    }
}
