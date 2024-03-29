plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
}

apply("../gradleconfigs/ktlint-config.gradle")

hilt {
    enableAggregatingTask = true
}

android {
    compileSdk = Apps.compileSdk
    buildToolsVersion = Apps.buildTools

    buildFeatures {
        compose = true
    }

    val versionFromGradleProperty = project.property("VERSION_NAME") as String

    defaultConfig {
        applicationId = "com.andreivanceadev.houseorganiser"
        minSdk = Apps.minSdk
        targetSdk = Apps.targetSdk
        versionCode = Apps.versionCode(versionFromGradleProperty)
        versionName = versionFromGradleProperty
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            isMinifyEnabled = false
        }
    }
    packagingOptions {
        resources.excludes.add("META-INF/*")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.kotlinCompilerExtensionVersion
    }
}

dependencies {
    implementation(project(":app:features:kitchen"))
    implementation(project(":app:features:recipes"))
    implementation(project(":app:features:common"))

    implementation(Libs.kotlin)
    implementation(Libs.androidXCore)
    implementation(Libs.material)
    implementation(Libs.androidXCompat)

    implementation(Libs.orbitMVI)
    implementation(Libs.orbitMVICore)

    implementation(Libs.hilt)
    kapt(Libs.hiltCompiler)

    testImplementation(UnitTestLibs.unitTestJUnit)
    testImplementation(UnitTestLibs.mockitoCore)
    testImplementation(UnitTestLibs.mockitoKotlin)
    testImplementation(UnitTestLibs.truth)

    androidTestImplementation(UiTestLibs.androidTestJUnit)
    androidTestImplementation(UiTestLibs.androidTestEspresso)

    implementation(Libs.coroutinesCore)
    implementation(Libs.coroutines)

    // Integration with activities
    implementation(Libs.composeActivity)
    // Compose Material Design
    implementation(Libs.composeMaterial)
    // Animations
    implementation(Libs.composeAnimation)
    // Tooling support (Previews, etc.)
    implementation(Libs.composeTooling)
    // Integration with ViewModels
    implementation(Libs.composeViewModel)

    implementation(Libs.composeNavigation)
    implementation(Libs.composeHiltNavigation)

    // UI Tests
    androidTestImplementation(Libs.composeTesting)
    debugImplementation(Libs.composeTestingManifest)

    implementation(UiTestLibs.androidTestRunner)
    implementation(UiTestLibs.androidTestEspresso)
    implementation(UiTestLibs.androidTestEspressoIntents)
    implementation(UiTestLibs.androidTestEspressoContrib)
    implementation(UiTestLibs.androidTestEspressoWeb)
    implementation(UiTestLibs.androidTestUIAutomator)

    androidTestUtil(UiTestLibs.androidTestOrchestrator)
}

kapt {
    correctErrorTypes = true
}