description = "Root project of the threeten-jaxb JAXB adapters for the ThreeTen date and time API for Java"

subprojects {
    apply(plugin = "java-library")
    apply(plugin = "maven-publish")
    apply(plugin = "signing")

    group = "io.github.threeten-jaxb"
    version = "2.1.0-pai.0"

    repositories {
        mavenCentral()
    }

    configure<JavaPluginConvention> {
        sourceCompatibility = JavaVersion.VERSION_1_9
        targetCompatibility = JavaVersion.VERSION_1_9
    }

    task<Jar>("sourcesJar") {
        from(project.the<SourceSetContainer>()["main"].allJava)
        archiveClassifier.set("sources")
    }

    task<Jar>("javadocJar") {
        dependsOn(tasks.named<Javadoc>("javadoc"))
        from(tasks.named<Javadoc>("javadoc").get().destinationDir)
        archiveClassifier.set("javadoc")
    }

    tasks.withType<Jar> {
        manifest {
            attributes(
                    mapOf("Implementation-Title" to project.name,
                            "Implementation-Version" to project.version)
            )
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    tasks.withType<Javadoc> {
        options {
            this as StandardJavadocDocletOptions
            links("https://javadoc.io/doc/jakarta.xml.bind/jakarta.xml.bind-api/3.0.1/")
        }
    }

    dependencies {
        "api"("jakarta.xml.bind:jakarta.xml.bind-api:3.0.1")

        "testRuntimeOnly"("com.sun.xml.bind:jaxb-impl:3.0.2")

        "testImplementation"(platform("org.junit:junit-bom:5.8.2"))
        "testImplementation"("org.junit.jupiter:junit-jupiter-api")
        "testRuntimeOnly"("org.junit.jupiter:junit-jupiter-engine")
    }

    afterEvaluate {
        configure<PublishingExtension> {
            publications {
                create<MavenPublication>("mavenJava") {
                    from(components["java"])
                    artifact(tasks["sourcesJar"])
                    artifact(tasks["javadocJar"])

                    pom {
                        name.set(project.name)
                        description.set(project.description)
                        url.set("https://github.com/threeten-jaxb/threeten-jaxb")

                        licenses {
                            license {
                                name.set("The Apache License, Version 2.0")
                                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                            }
                        }

                        developers {
                            developer {
                                id.set("mkroening")
                                name.set("Martin Kröning")
                                url.set("https://github.com/mkroening")
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

        configure<SigningExtension> {
            sign(the<PublishingExtension>().publications["mavenJava"])
        }
    }
}
