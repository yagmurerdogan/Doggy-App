plugins {
    id("com.github.ben-manes.versions") version Versions.gradleVersionsPluginVersion
}

buildscript {
    repositories {
        google()
        mavenCentral()

    }
    dependencies {
        classpath (ClassPaths.gradle)
        classpath (ClassPaths.kotlinGradlePlugin)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
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