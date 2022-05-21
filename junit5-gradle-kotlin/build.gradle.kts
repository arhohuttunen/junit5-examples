import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.eclipse.jetty:jetty-servlet:11.0.9")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation("org.eclipse.jetty:jetty-server:11.0.9")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
