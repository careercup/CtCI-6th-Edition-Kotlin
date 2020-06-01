plugins {
    kotlin("jvm") version "1.3.71"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.6.2")
}

tasks {
    withType<Test>() {
        useJUnitPlatform()
    }
}
