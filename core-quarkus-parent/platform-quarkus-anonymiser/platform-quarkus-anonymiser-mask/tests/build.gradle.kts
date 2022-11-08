plugins {
    id("java-library-conventions")
    id("io.quarkus")
}

group = "my-groupId"
version = "my-version"

repositories {
    mavenCentral()
}

dependencies {
    implementation(enforcedPlatform("io.quarkus.platform:quarkus-bom:2.13.2.Final"))
    implementation(project(":core-quarkus-parent:platform-quarkus-anonymiser:platform-quarkus-anonymiser-core"))
//    implementation(project(":core-quarkus-parent:platform-quarkus-anonymiser:platform-quarkus-anonymiser-mask:runtime"))
    testImplementation("io.quarkus:quarkus-junit5:2.13.2.Final")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}