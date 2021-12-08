plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

apply("../../../gradleconfigs/ktlint-config.gradle")

apply("../../${GradleFiles.commonAndroidLibConfig}")

dependencies {
    implementation(Libs.kotlin)
    implementation(Libs.androidXCore)
    implementation(Libs.material)
    implementation(Libs.androidXCompat)

    // Compose Material Design
    implementation(Libs.composeMaterial)
    // Animations
    implementation(Libs.composeAnimation)
    // Tooling support (Previews, etc.)
    implementation(Libs.composeTooling)
    // Integration with ViewModels
    implementation(Libs.composeViewModel)
}

kapt {
    correctErrorTypes = true
}