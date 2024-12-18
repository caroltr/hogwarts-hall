plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.catenri.hogwartshall.core.network"
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
    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.datetime)

    // hilt
    implementation(libs.hilt)
    ksp(libs.hilt.compiler)

    // coroutines
    implementation(libs.coroutines)

    // room
    implementation(libs.room)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)

    testImplementation(libs.coroutines)
    testImplementation(libs.coroutines.test)
}
