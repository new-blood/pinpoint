/*
 * This file was generated by the Gradle 'init' task.
 *
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    id("pinpoint.java11-conventions")
}

dependencies {
    api(project(":pinpoint-web"))
    implementation("org.apache.hbase:hbase-client:2.4.2")
}

description = "pinpoint-hbase2-web"
