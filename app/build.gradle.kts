plugins {
    id("java")
    id("org.sonarqube") version "6.2.0.5505"
    id("jacoco")
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jacoco:org.jacoco.core:0.8.11")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

sonar {
    properties {
        property("sonar.projectKey", "egyxh_java-project-78")
        property("sonar.organization", "egyxh")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}

tasks.withType<JavaCompile>() {
    options.compilerArgs.add("-Xlint:unchecked")
}

jacoco {
    toolVersion = "0.8.11"
    reportsDirectory.set(layout.buildDirectory.dir("reports/jacoco"))
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required.set(true)
        html.required.set(true)
        csv.required.set(false)
    }
}