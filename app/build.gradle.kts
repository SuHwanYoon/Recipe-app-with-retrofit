plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
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
    // ViewModel과 Compose를 통합하여 사용할 수 있게 해주는 라이브러리
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")

    // 네트워크 호출을 위한 Retrofit 라이브러리
    implementation("com.squareup.retrofit2:retrofit:2.9.0")

    // JSON 데이터를 Kotlin 객체로 변환하기 위한 Gson 컨버터
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // 이미지 로딩을 위한 Coil 라이브러리
    implementation("io.coil-kt:coil-compose:2.4.0")

    // Android 코어 라이브러리의 Kotlin 확장 기능을 추가합니다.
    implementation("androidx.core:core-ktx:1.12.0")

    // androidx.lifecycle 라이브러리의 런타임 KTX 확장 기능을 추가합니다.
    // 이 라이브러리는 LifecycleOwner 및 LifecycleObserver와 같은 컴포넌트를 더 쉽게 사용할 수 있게 합니다.
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")

    // Jetpack Compose와 Activity를 통합하는 기능을 제공합니다.
    implementation("androidx.activity:activity-compose:1.8.0")

    // Compose BOM (Bill of Materials)으로 Compose 라이브러리의 버전을 관리합니다.
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))

    // Compose UI 라이브러리
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")

    // Material Design 3를 위한 Compose 라이브러리
    implementation("androidx.compose.material3:material3")

    // JUnit을 사용한 단위 테스트 라이브러리
    testImplementation("junit:junit:4.13.2")

    // AndroidX 테스트 확장 라이브러리와 Espresso를 사용한 UI 테스트 라이브러리
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Compose BOM을 사용한 UI 테스트 라이브러리
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")

    // 디버그 모드에서만 사용되는 Compose UI 도구 및 테스트 매니페스트
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}