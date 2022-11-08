plugins {
    `java-library-conventions`
//    id("io.quarkus")
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
    implementation(enforcedPlatform("io.quarkus.platform:quarkus-bom:2.13.2.Final"))

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}