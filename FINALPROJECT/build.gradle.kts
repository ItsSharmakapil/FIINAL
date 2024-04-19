// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()  // Google's Maven repository
        mavenCentral()
    }
    dependencies {
        classpath "com.android.tools.build:gradle:7.0.4"  // Android Gradle Plugin
        classpath "com.google.gms:google-services:4.4.1"  // Google Services plugin
    }
}

plugins {
    id("com.android.application") version "8.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.gms.google-services") version "4.4.1" apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}
