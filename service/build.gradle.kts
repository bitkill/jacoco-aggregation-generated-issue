plugins {
    id("jacoco")
    id("io.freefair.lombok") version "8.6"
    id("jvm-test-suite")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

jacoco {
    version = "0.8.12"
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.11.0-M2")
}

testing {
    suites {
        @Suppress("UnstableApiUsage")
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter()
            targets.configureEach {
                testTask.configure {
                    testLogging {
                        showStandardStreams = true
                    }
                    finalizedBy(tasks.named("jacocoTestReport"))
                }
            }
        }
    }
}
