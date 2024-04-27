plugins {
    java
    id("org.springframework.boot") version "3.2.4"
    id("io.spring.dependency-management") version "1.1.4"
    id("org.pkl-lang") version ("0.25.3")
}

group = "ua.lviv.javaclub"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
//    implementation("org.pkl-lang:pkl-config-java:0.25.3")
    implementation("org.pkl-lang:pkl-spring:0.15.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

pkl {
    javaCodeGenerators {
        register("genConfig") {
            sourceModules.set(
                files(
                    "src/main/resources/pkl/MeetingClub.pkl",
                    "src/main/resources/pkl/Lviv.pkl",
                    "src/main/resources/pkl/JavaClub.pkl"
                )
            )
            generateJavadoc.set(true)
        }
//        register("serverconfig") {
//            sourceModules.set(
//                files(
//                    "src/main/resources/AppConfig.pkl"
//                )
//            )
//            generateSpringBootConfig.set(true)
//        }
    }
    pkldocGenerators {
        register("pkldoc") {
            sourceModules.set(
                files(
                    "src/main/resources/pkl/MeetingClub.pkl",
                    "src/main/resources/pkl/doc-package-info.pkl"
                )
            )
        }
    }
}

//tasks["serverconfig"].dependsOn(tasks["genConfig"])
