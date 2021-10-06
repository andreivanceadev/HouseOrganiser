plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

apply("../../../gradleconfigs/ktlint-config.gradle")

apply("../../${GradleFiles.commonAndroidUI}")
apply("../../${GradleFiles.commonUIDependencies}")

dependencies {
    implementation(project(":app:storage"))
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}
