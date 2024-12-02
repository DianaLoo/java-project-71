plugins {
    id("application")
    id("checkstyle")
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
application {
    mainClass = "hexlet.code.App"
}
dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation ("info.picocli:picocli:4.7.6")
    implementation ("com.fasterxml.jackson.core:jackson-core:2.17.2")
    implementation ("com.fasterxml.jackson.core:jackson-core:2.17.2")
    implementation ("com.fasterxml.jackson.core:jackson-annotations:2.17.2")
    implementation ("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.17.2")


}

tasks.test {
    useJUnitPlatform()
}