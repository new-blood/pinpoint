/*
 * This file was generated by the Gradle 'init' task.
 *
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    id("pinpoint.java11-conventions")
    id("pinpoint.hbase-conventions")
    id("pinpoint.curator-conventions")
}

dependencies {
    api(project(":pinpoint-commons-hbase"))
    api(project(":pinpoint-commons-server"))
    api(project(":pinpoint-commons-server-cluster"))
    api(project(":pinpoint-thrift"))
    api(project(":pinpoint-rpc"))
    api(project(":pinpoint-grpc"))
    implementation("org.apache.thrift:libthrift:0.15.0")
    api(project(":pinpoint-web"))
    api(project(":pinpoint-collector"))
    implementation("org.springframework:spring-core")
    implementation("org.springframework:spring-context")
    implementation("org.springframework:spring-context-support:${Versions.spring}")
    implementation("com.github.ben-manes.caffeine:caffeine:2.9.2")
    implementation("org.apache.logging.log4j:log4j-api:${Versions.log4jJDK8}")
    implementation("io.dropwizard.metrics:metrics-core:3.2.6")
    implementation("io.dropwizard.metrics:metrics-jvm:3.2.6")
    implementation("io.dropwizard.metrics:metrics-servlets:3.2.6")
    implementation("org.apache.zookeeper:zookeeper:${Versions.zookeeper}")
    runtimeOnly("org.slf4j:slf4j-api:1.7.30")
    testImplementation("org.apache.logging.log4j:log4j-jcl:${Versions.log4jJDK8}")
    testImplementation("org.apache.logging.log4j:log4j-slf4j-impl:${Versions.log4jJDK8}")
    testImplementation("org.apache.logging.log4j:log4j-core:${Versions.log4jJDK8}")
    testImplementation("org.springframework:spring-test:${Versions.spring}")
    compileOnly("org.apache.flink:flink-java:1.14.2")
    compileOnly("org.apache.flink:flink-streaming-java_2.11:1.14.2")
    compileOnly("org.apache.flink:flink-clients_2.11:1.14.2")
}

description = "pinpoint-flink"
