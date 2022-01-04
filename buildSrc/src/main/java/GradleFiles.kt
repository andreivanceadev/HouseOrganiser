object Apps {
    const val compileSdk = 31
    const val minSdk = 23
    const val targetSdk = 31
    const val buildTools = "30.0.3"
    fun versionCode(versionName: String) = (
        ((versionName.split('-')[0].split(".")[2].toInt()) * 1) +
            ((versionName.split('-')[0].split(".")[1].toInt()) * 100) +
            ((versionName.split('-')[0].split(".")[0].toInt()) * 10000)
        )
}

object Versions {
    const val gradle = "7.0.4"
    const val kotlin = "1.5.21"
    const val kotlinCompilerExtensionVersion = "1.0.1"
    const val gmsGoogleServices = "4.3.10"

    // Android Libs
    const val androidxCore = "1.3.2"
    const val androidxCompat = "1.2.0"
    const val material = "1.2.1"
    const val androidXActivityKotlin = "1.2.1"

    // Test Libs
    const val jUnit = "4.13.1"
    const val mockitoCore = "3.7.7"
    const val mockitoKotlin = "2.2.0"
    const val truth = "1.1"
    const val androidTestJUnit = "1.1.2"
    const val androidTestEspresso = "3.4.0"
    const val androidTestUIAutomator = "2.2.0"
    const val androidTestEspressoIntents = "3.4.0"
    const val androidTestEspressoContrib = "3.3.0"
    const val androidTestEspressoWeb = "3.1.0"
    const val androidTestOrchestrator = "1.4.0"
    const val androidTestRunner = "1.4.0"


    // Hilt
    const val hilt = "2.38.1"

    // Image Loader
    const val coilCompose = "1.4.0"

    // Coroutines
    const val coroutines = "1.3.8"

    const val javaxAnnotation = "1.3.2"

    // Room
    const val room = "2.2.6"

    //Worker
    const val worker = "2.7.0-rc01"

    //Gson
    const val gson = "2.8.6"

    //DB Debug
    const val dbDebug = "1.0.6"

    //Test Kotlin Coroutine
    const val kotlinCoroutine = "1.4.2"
    const val androidXCoreTesting = "2.1.0"

    //protobuf converter
    const val orbitMVI = "4.2.0"

    const val composeActivity = "1.3.1"
    const val compose = "1.0.1"
    const val composeViewModel = "1.0.0-alpha07"
    const val composeNavigation = "2.4.0-alpha09"
    const val composeHiltNavigation = "1.0.0-alpha03"
}

object Libs {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    const val androidXCore = "androidx.core:core-ktx:${Versions.androidxCore}"
    const val androidXCompat = "androidx.appcompat:appcompat:${Versions.androidxCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val androidXActivityKotlin = "androidx.activity:activity-ktx:${Versions.androidXActivityKotlin}"

    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    const val coilCompose = "io.coil-kt:coil-compose:${Versions.coilCompose}"

    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"

    const val javaxAnnotation = "javax.annotation:javax.annotation-api:${Versions.javaxAnnotation}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    const val worker = "androidx.work:work-runtime-ktx:${Versions.worker}"

    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    const val databaseDebug = "com.amitshekhar.android:debug-db:${Versions.dbDebug}"

    const val orbitMVI = "org.orbit-mvi:orbit-viewmodel:${Versions.orbitMVI}"
    const val orbitMVICore = "org.orbit-mvi:orbit-core:${Versions.orbitMVI}"

    // jetpackCompose
    const val composeActivity = "androidx.activity:activity-compose:${Versions.composeActivity}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val composeAnimation = "androidx.compose.animation:animation:${Versions.compose}"
    const val composeTooling = "androidx.compose.ui:ui-tooling:1.0.0-beta09"
    const val composeViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.composeViewModel}"

    const val composeTesting = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    const val composeTestingManifest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"

    const val composeNavigation = "androidx.navigation:navigation-compose:${Versions.composeNavigation}"
    const val composeHiltNavigation = "androidx.hilt:hilt-navigation-compose:${Versions.composeHiltNavigation}"
}

object UnitTestLibs {
    const val unitTestJUnit = "junit:junit:${Versions.jUnit}"

    // For mocking, mock injection, etc.
    const val mockitoCore = "org.mockito:mockito-core:${Versions.mockitoCore}"

    // Mocking helpers, matchers: verify(), eq(), any(), etc.
    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"

    // Assertions
    const val truth = "com.google.truth:truth:${Versions.truth}"

    // For Testing Coroutines
    const val kotlinCoroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinCoroutine}"
    const val androidXArchCoreTesting = "androidx.arch.core:core-testing:${Versions.androidXCoreTesting}"
}

object UiTestLibs {
    const val androidTestJUnit = "androidx.test.ext:junit:${Versions.androidTestJUnit}"
    const val androidTestEspresso = "androidx.test.espresso:espresso-core:${Versions.androidTestEspresso}"
    const val androidTestEspressoIntents =
        "androidx.test.espresso:espresso-intents:${Versions.androidTestEspressoIntents}"
    const val androidTestEspressoContrib =
        "androidx.test.espresso:espresso-contrib:${Versions.androidTestEspressoContrib}"
    const val androidTestEspressoWeb = "androidx.test.espresso:espresso-web:${Versions.androidTestEspressoWeb}"
    const val androidTestUIAutomator = "androidx.test.uiautomator:uiautomator:${Versions.androidTestUIAutomator}"
    const val androidTestOrchestrator = "androidx.test:orchestrator:${Versions.androidTestOrchestrator}"
    const val androidTestRunner = "androidx.test:runner:${Versions.androidTestRunner}"
}

object GradleFiles {

    const val commonUIDependencies = "../gradleconfigs/common-ui.gradle"
    const val commonLibDependencies = "../gradleconfigs/common-lib.gradle"
    const val commonAndroidConfig = "../gradleconfigs/common-android-ui.gradle"
    const val commonAndroidLibConfig = "../gradleconfigs/common-android-lib.gradle"

}