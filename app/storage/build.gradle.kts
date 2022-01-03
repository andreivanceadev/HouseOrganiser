plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

apply("../../gradleconfigs/ktlint-config.gradle")
apply("../${GradleFiles.commonAndroidLibConfig}")

dependencies {

    implementation(Libs.kotlin)
    implementation(Libs.androidXCore)
    implementation(Libs.androidXCompat)
    implementation(Libs.coroutines)

    implementation(Libs.roomRuntime)
    implementation(Libs.roomKtx)
    kapt(Libs.roomCompiler)

    implementation(Libs.hilt)
    kapt(Libs.hiltCompiler)

    implementation(Libs.gson)

    testImplementation("junit:junit:4.+")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}

hilt {
    enableAggregatingTask = true
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}
