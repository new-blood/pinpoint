/*
 * This file was generated by the Gradle 'init' task.
 *
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    id("pinpoint.java7-conventions")
}

dependencies {
    api(project(":pinpoint-plugin-it-utils"))
    testImplementation("log4j:log4j:1.2.17")
}

description = "pinpoint-log4j-plugin-it"
