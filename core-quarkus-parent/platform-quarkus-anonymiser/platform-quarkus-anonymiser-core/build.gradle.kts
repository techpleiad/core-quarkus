plugins {
    `java-library-conventions`
    id("org.kordamp.gradle.jandex") version("0.9.0")
}

version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    api(libs.quarkus.resteasy)
    implementation(libs.quarkus.yaml)
    compileOnly(libs.lombok)
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}