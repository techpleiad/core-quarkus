plugins {
    id("java-library-conventions")
    id("maven-publish")
    id("org.kordamp.gradle.jandex") version("1.0.0")
}

group = "my-groupId"
version = "my-version"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core-quarkus-parent:platform-quarkus-anonymiser:platform-quarkus-anonymiser-core"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}