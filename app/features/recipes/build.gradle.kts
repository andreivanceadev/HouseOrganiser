plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")

}

apply("../../../gradleconfigs/ktlint-config.gradle")

apply("../../${GradleFiles.commonAndroidConfig}")
apply("../../${GradleFiles.commonUIDependencies}")

dependencies {
    implementation(project(":app:features:common"))
    implementation(project(":app:navigation"))

    implementation(Libs.coilCompose)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}
