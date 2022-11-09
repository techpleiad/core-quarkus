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
    api(enforcedPlatform("io.quarkus.platform:quarkus-bom:2.13.2.Final"))
    api(project(":core-quarkus-parent:platform-quarkus-anonymiser:platform-quarkus-anonymiser-mask:runtime"))
    api(project(":core-quarkus-parent:platform-quarkus-anonymiser:platform-quarkus-anonymiser-mask:deployment"))

    implementation("io.quarkus:quarkus-core")
    implementation("io.quarkus:quarkus-arc")
    implementation("io.quarkus:quarkus-resteasy")
    implementation("io.quarkus:quarkus-resteasy-jackson")

    implementation(project(":core-quarkus-parent:platform-quarkus-anonymiser:platform-quarkus-anonymiser-core"))
//    implementation(project(":core-quarkus-parent:platform-quarkus-anonymiser:platform-quarkus-anonymiser-mask:runtime"))
    testImplementation("io.quarkus:quarkus-junit5:2.13.2.Final")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}