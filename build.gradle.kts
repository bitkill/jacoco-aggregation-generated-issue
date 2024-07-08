plugins {
    id("java-library")
    id("jacoco-report-aggregation")
}

allprojects {
    group = "org.ruifernandes"

    repositories {
        mavenLocal()
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "idea")

}

dependencies {
    jacocoAggregation(project("service"))
}

reporting {
    reports {
        val testReport by creating(JacocoCoverageReport::class) {
            testType = TestSuiteType.UNIT_TEST
        }
    }
}


tasks.named("check") {
    dependsOn(tasks.named("testReport"))
}
