plugins {
    id("com.android.library")
    id("kotlin-android")
}

apply("../../gradleconfigs/ktlint-config.gradle")
apply("../${GradleFiles.commonAndroidLibConfig}")

dependencies {

    implementation(Libs.kotlin)
    implementation(Libs.androidXCore)
    implementation(Libs.androidXCompat)
    implementation(Libs.coroutines)
    testImplementation("junit:junit:4.+")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}