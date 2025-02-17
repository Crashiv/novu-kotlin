

plugins {
    `java-library`
    `maven-publish`
    signing
    id("org.jlleitschuh.gradle.ktlint") version "11.3.1"

    id("java-library")
    kotlin("jvm") version "1.8.0"
}
group = "io.github.crashiv"
version = "v0.1.1"

java {
    withJavadocJar()
    withSourcesJar()
}

repositories {
    mavenCentral()
}

dependencies {

    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.10.0")

    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.7.10")

    // OkHttp3 and Retrofit2
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Kotlin coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    // Logging
    implementation("io.github.microutils:kotlin-logging-jvm:2.1.23")
    implementation("org.slf4j:slf4j-api:1.7.36")
    implementation("org.slf4j:slf4j-simple:1.7.36")
}
tasks.test {
    useJUnitPlatform()
}
tasks.jar{
    archiveFileName.set("novu-kotlin.jar")
}
kotlin {
    jvmToolchain(8)
}
extensions.findByName("buildScan")?.withGroovyBuilder {
    setProperty("termsOfServiceUrl", "https://gradle.com/terms-of-service")
    setProperty("termsOfServiceAgree", "yes")
}
publishing {
    repositories {
        maven {
            val releaseRepoUrl = "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
            val snapshotRepoUrl = "https://s01.oss.sonatype.org/content/repositories/snapshots/"
            url = uri(if (version.toString().endsWith("SNAPSHOT")) snapshotRepoUrl else releaseRepoUrl)
            credentials {
                username = "Crashiv"
                password = "xCh7bxAc&6Eq_2k"
            }
        }
    }
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = "novu-kotlin"
            from(components["java"])
            versionMapping {
                usage("java-api") {
                    fromResolutionOf("runtimeClasspath")
                }
                usage("java-runtime") {
                    fromResolutionResult()
                }
            }
            pom {
                name.set("Novu Kotlin")
                description.set("A kotlin SDK for Novu")
                url.set("https://github.com/Crashiv/novu-kotlin")
                licenses {
                    license {
                        name.set("The Apache Software License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        distribution.set("repo")
                    }
                }
                developers {
                    developer {
                        id.set("crashiv")
                        name.set("Shivam Shah")
                        email.set("crashiv2541@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/Crashiv/novu-kotlin.git")
                    developerConnection.set("scm:git:ssh://github.com/Crashiv/novu-kotlin.git")
                    url.set("https://github.com/Crashiv/novu-kotlin")
                }
            }
        }
    }
}
signing {
    sign(publishing.publications["mavenJava"])
}
tasks.javadoc {
    if (JavaVersion.current().isJava8Compatible) {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
}