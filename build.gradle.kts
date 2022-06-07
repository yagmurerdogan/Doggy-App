plugins {
    id("com.github.ben-manes.versions") version Versions.gradleVersionsPluginVersion
}

buildscript {
    repositories {
        google()
        mavenCentral()

    }
    dependencies {
        classpath(ClassPaths.gradle)
        classpath(ClassPaths.kotlinGradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven("https://jitpack.io")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}