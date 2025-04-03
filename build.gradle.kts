// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    // Dagger Hilt Android 라이브러리 추가
    // apply false는 플러그인을 적용하지 않고, 플러그인을 적용한 후에 플러그인을 설정하려는 경우에 사용합니다.
    id("com.google.dagger.hilt.android") version "2.48" apply false
}

tasks.register("cleanBuildCache") {
    doLast {
        delete(rootProject.buildDir)
        delete(rootProject.file(".gradle"))
    }
}