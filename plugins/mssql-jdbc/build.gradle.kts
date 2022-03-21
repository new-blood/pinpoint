/*
 * This file was generated by the Gradle 'init' task.
 *
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    id("pinpoint.java7-conventions")
}

dependencies {
    testImplementation("org.apache.logging.log4j:log4j-api:2.12.4")
    testImplementation("org.apache.logging.log4j:log4j-slf4j-impl:2.12.4")
    testImplementation("org.apache.logging.log4j:log4j-core:2.12.4")
    testImplementation(project(":pinpoint-commons-profiler"))
    testImplementation(project(":pinpoint-plugins-loader"))
    compileOnly(project(":pinpoint-bootstrap-core"))
}

description = "pinpoint-mssql-jdbc-driver-plugin"
