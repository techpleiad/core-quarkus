plugins {
    id("java-library-conventions")
//    id("io.quarkus.extension") version("2.13.2.Final")
    id("maven-publish")
}

group = "my-groupId"
version = "my-version"

repositories {
    mavenCentral()
}

dependencies {


    api(platform("io.quarkus:quarkus-bom:2.13.0.Final"))
    api(project(":core-quarkus-parent:platform-quarkus-anonymiser:platform-quarkus-anonymiser-mask:runtime"))
    annotationProcessor("io.quarkus:quarkus-extension-processor:2.13.0.Final")
    api("io.quarkus:quarkus-core-deployment")
    api("io.quarkus:quarkus-arc-deployment")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}