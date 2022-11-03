plugins {
    `kotlin-dsl`
}

dependencies {
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.8.0")
}

val javaVersionValue = JavaLanguageVersion.of(17)

java {
    toolchain.languageVersion.set(javaVersionValue)
}