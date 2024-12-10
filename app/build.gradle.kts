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

    //Jetpack Compose에서 ViewModel을 쉽게 사용할 수 있게 해주는 라이브러리
    //Compose UI와 ViewModel 간의 통합을 지원
    //UI 상태 관리와 생명주기 처리를 단순화
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")

    //REST API 통신을 위한 HTTP 클라이언트 라이브러리
    //네트워크 호출을 인터페이스 형태로 정의
    //HTTP 요청/응답을 쉽게 처리
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")

    //JSON 데이터를 Kotlin/Java 객체로 변환
    //Retrofit과 함께 사용되어 API 응답을 객체로 자동 변환
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    //Jetpack Compose를 위한 이미지 로딩 라이브러리
    //네트워크 이미지를 효율적으로 로드하고 캐싱
    //메모리 최적화와 이미지 다운샘플링 지원
    //Compose UI와 완벽하게 통합되는 AsyncImage 컴포넌트 제공
    implementation("io.coil-kt.coil3:coil-compose:2.4.0")

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.6")
    implementation("androidx.activity:activity-compose:1.9.3")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}