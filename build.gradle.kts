/*
 * This file was generated by the Gradle 'init' task.
 *
 * This is a general purpose Gradle build.
 * Learn more about Gradle by exploring our samples at https://docs.gradle.org/7.4.2/samples
 */

println("corequarkus version : " + libs.versions.corequarkus.get())

val versionTxt = libs.versions.corequarkus.get()

plugins {
    java
//    id("io.quarkus")
    id("io.quarkus.extension") version("2.13.2.Final")
}

allprojects {
    group = "my-groupId"
    version = "my-version"
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation("io.quarkus:quarkus-arc")
    annotationProcessor("io.quarkus:quarkus-extension-processor:2.13.0.Final")
//    implementation("io.quarkus:quarkus-resteasy-reactive")
    testImplementation("io.quarkus:quarkus-junit5")
    testImplementation("io.rest-assured:rest-assured")
}

subprojects {
    project.version = versionTxt
}