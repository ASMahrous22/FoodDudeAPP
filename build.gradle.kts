// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    dependencies {

    }
    repositories {
        google()
        mavenCentral()
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
}
