plugins {
  id("java")
  id("org.jetbrains.kotlin.jvm") version "1.8.21"
  id("org.jetbrains.intellij") version "1.15.0"
}

group = "com.jameswoo"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

// Find versions here https://plugins.jetbrains.com/docs/intellij/android-studio-releases-list.html
// Currently using Flamingo Patch 2
intellij {
    type.set("AI") // Target IDE Platform
    version.set("2022.2.1.20")

    plugins.set(listOf(
        "org.jetbrains.android"
    ))
}

tasks {
  // Set the JVM compatibility versions
  withType<JavaCompile> {
    sourceCompatibility = "17"
    targetCompatibility = "17"
  }
  withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
  }

  patchPluginXml {
    sinceBuild.set("222")
    untilBuild.set("232.*")
  }

  signPlugin {
    certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
    privateKey.set(System.getenv("PRIVATE_KEY"))
    password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
  }

  publishPlugin {
    token.set(System.getenv("PUBLISH_TOKEN"))
  }
}
