plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.catenri.hogwartshall.core.data"
    compileSdk = 34

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(project(":core:network"))
    implementation(project(":core:database"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.datetime)

    // hilt
    implementation(libs.hilt)
    ksp(libs.hilt.compiler)

    // network
    implementation(libs.retrofit)
    implementation(libs.okhttp.interceptor)

    // coroutines
    implementation(libs.coroutines)

    testImplementation(libs.coroutines)
    testImplementation(libs.coroutines.test)
    testImplementation(libs.okhttp.mockserver)
}