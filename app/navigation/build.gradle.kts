plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

apply("../../gradleconfigs/ktlint-config.gradle")

apply("../${GradleFiles.commonAndroidLibConfig}")
apply("../${GradleFiles.commonLibDependencies}")

dependencies {
    implementation(Libs.composeNavigation)
    implementation(Libs.composeHiltNavigation)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}
