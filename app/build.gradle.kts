plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

android {
    namespace = "yoon.tutorials.recipeapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "yoon.tutorials.recipeapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Dagger Hilt Android 라이브러리
    implementation(testLibs.hilt.android)
    // Hilt Android Gradle 플러그인
    kapt(testLibs.hilt.compiler)

    // ViewModel과 Compose를 통합하여 사용할 수 있게 해주는 라이브러리
    implementation(testLibs.lifecycle.viewmodel.compose)

    // 네트워크 호출을 위한 Retrofit 라이브러리
    implementation(testLibs.retrofit)

    // JSON 데이터를 Kotlin 객체로 변환하기 위한 Gson 컨버터
    implementation(testLibs.converter.gson)

    // 이미지 로딩을 위한 Coil 라이브러리
    implementation(testLibs.coil.compose)

    // Android 코어 라이브러리의 Kotlin 확장 기능을 추가합니다.
    implementation(testLibs.core.ktx)

    // androidx.lifecycle 라이브러리의 런타임 KTX 확장 기능을 추가합니다.
    // 이 라이브러리는 LifecycleOwner 및 LifecycleObserver와 같은 컴포넌트를 더 쉽게 사용할 수 있게 합니다.
    implementation(testLibs.lifecycle.runtime.ktx)

    // Jetpack Compose와 Activity를 통합하는 기능을 제공합니다.
    implementation(testLibs.activity.compose)

    // Compose BOM (Bill of Materials)으로 Compose 라이브러리의 버전을 관리합니다.
    implementation(platform(testLibs.compose.bom))

    // Compose UI 라이브러리
    implementation(testLibs.compose.ui)
    implementation(testLibs.compose.ui.graphics)
    implementation(testLibs.compose.ui.tooling.preview)

    // Material Design 3를 위한 Compose 라이브러리
    implementation(testLibs.material3)

    // JUnit을 사용한 단위 테스트 라이브러리
    testImplementation(testLibs.junit)

    // AndroidX 테스트 확장 라이브러리와 Espresso를 사용한 UI 테스트 라이브러리
    androidTestImplementation(testLibs.test.ext.junit)
    androidTestImplementation(testLibs.espresso.core)

    // Compose BOM을 사용한 UI 테스트 라이브러리
    androidTestImplementation(platform(testLibs.compose.bom))
    androidTestImplementation(testLibs.ui.test.junit4)

    // 디버그 모드에서만 사용되는 Compose UI 도구 및 테스트 매니페스트
    debugImplementation(testLibs.ui.tooling)
    debugImplementation(testLibs.ui.test.manifest)
}


kapt {
    correctErrorTypes = true
}