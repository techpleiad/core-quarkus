plugins {
    java
    id("io.quarkus") version libs.versions.quarkusio
}

version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core-quarkus-parent:platform-quarkus-anonymiser:platform-quarkus-anonymiser-core"))
    compileOnly(libs.lombok)
    testImplementation("io.quarkus:quarkus-junit5:2.13.2.Final")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}