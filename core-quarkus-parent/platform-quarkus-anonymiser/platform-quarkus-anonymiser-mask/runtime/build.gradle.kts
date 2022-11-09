plugins {
    id("java-library-conventions")
    id("maven-publish")
//    id("org.kordamp.gradle.jandex") version("1.0.0")
}

group = "my-groupId"
version = "my-version"

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {

    api(platform("io.quarkus:quarkus-bom:2.13.0.Final"))
    annotationProcessor("io.quarkus:quarkus-extension-processor:2.13.0.Final")

    implementation("io.quarkus:quarkus-core")
    implementation("io.quarkus:quarkus-arc")

    api(project(":core-quarkus-parent:platform-quarkus-anonymiser:platform-quarkus-anonymiser-core"))

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}