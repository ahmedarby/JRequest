plugins {
    java
    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation("org.assertj:assertj-core:3.22.0")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

/** Project Property's and Variables **/
val mainClass: String = "JRequest"
val mainPackage: String = "org.http.request"
val mainPackageClass: String = "$mainPackage.$mainClass"

group = "org.http.request"
version = "1.0-SNAPSHOT"
project.description = "JRequest is a library for handle http requests in java."

/** Plugins and Tasks configurations **/
application {
    mainClass.set(mainPackageClass)
    mainModule.set(mainPackage)
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.getByName<Jar>("jar") {
    manifest {
        attributes["Main-Class"] = mainPackageClass
    }
}