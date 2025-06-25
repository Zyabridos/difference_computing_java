plugins {
    application
    java
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("io.hexlet.Application")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}
