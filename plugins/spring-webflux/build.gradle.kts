/*
 * This file was generated by the Gradle 'init' task.
 *
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    id("com.navercorp.pinpoint.java-conventions")
}

dependencies {
    providedCompile(project(":pinpoint-bootstrap-core"))
    compileOnly("org.springframework:spring-webflux:5.3.13")
    compileOnly("org.springframework:spring-web:5.3.13")
}

description = "pinpoint-spring-webflux-plugin"
