plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.catenri.hogwartshall.core.network"
    compileSdk = 34

    defaultConfig {
        minSdk = 28
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        buildConfig = true
    }
    testOptions {
        unitTests.all {
            it.useJUnitPlatform()
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.datetime)

    // hilt
    implementation(libs.hilt)
    ksp(libs.hilt.compiler)

    // coroutines
    implementation(libs.coroutines)

    // network
    implementation(libs.retrofit)
    implementation(libs.okhttp.interceptor)

    testImplementation(libs.coroutines)
    testImplementation(libs.coroutines.test)
    testImplementation(libs.okhttp.mockserver)
    testImplementation(libs.junit.engine)
    testImplementation(libs.junit.api)
}
