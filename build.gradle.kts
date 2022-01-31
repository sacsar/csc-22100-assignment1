plugins {
    application
}

val YOUR_NAME = "YOUR_NAME_HERE"

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.assertj:assertj-core:3.21.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

application {
    mainClass.set("HelloWorld")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()

    testLogging {
        events("passed", "failed")
        showExceptions = true
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
}


tasks.register<Zip>("packageAssignment") {
    archiveFileName.set("${project.name}-$YOUR_NAME.zip")
    from(layout.projectDirectory) {
        include("*.gradle.kts")
        include("src/**")
        include("gradle/**")
        include("gradlew*")
    }

    outputs.upToDateWhen{ false }

    finalizedBy(tasks.getByPath("copyZip"))
}

tasks.register<Copy>("copyZip") {
    from(tasks.getByName<Zip>("packageAssignment").outputs)

    destinationDir = layout.projectDirectory.asFile
}
