package yoon.tutorials.recipeapp

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// API 통신을 위한 Retrofit 설정과 서비스 인터페이스 정의
// @Module로 이 객체를 Hilt가 의존성주입에 사용하는 모듈로 정의
// SingletonComponent: 애플리케이션 전체에서 단일 인스턴스로 사용됨
// InstallIn: 이 모듈이 SingletonComponent에 설치됨을 나타냄
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    // Retrofit 인스턴스를 생성하는 함수
    // 이 함수를 사용해서 Retrofit 인스턴스를 생성
    // @Provides: Hilt에 의해 의존성 주입을 위한 함수로 사용됨
    // @Singleton: 이 함수가 제공하는 객체는 애플리케이션 전체에서 단일 인스턴스로 사용됨
    // GsonConverterFactory: JSON 응답을 Kotlin 객체로 변환하기 위한 컨버터 추가
    // recipeRetrofit() 함수는 Retrofit 인스턴스를 생성하고 반환
    @Provides
    @Singleton
    fun recipeRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // ApiService 인터페이스의 구현체를 제공하는 함수
    // @Provides: Hilt에 의해 의존성 주입을 위한 함수로 사용됨
    // @Singleton: 이 함수가 제공하는 객체는 애플리케이션 전체에서 단일 인스턴스로 사용됨
    @Provides
    @Singleton
    fun ApiService(apiRetrofit: Retrofit): ApiService {
        return apiRetrofit.create(ApiService::class.java)
    }
}