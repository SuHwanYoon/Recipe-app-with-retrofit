package yoon.tutorials.recipeapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


// API 통신을 위한 Retrofit 설정과 서비스 인터페이스 정의

// Retrofit 인스턴스 생성
// baseUrl: API의 기본 URL 설정
// GsonConverterFactory: JSON 응답을 Kotlin 객체로 변환하기 위한 컨버터 추가
private val retrofit = Retrofit.Builder()
    .baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

// Retrofit을 사용하여 ApiService 인터페이스의 구현체 생성
val recipeService: ApiService = retrofit.create(ApiService::class.java)

// API 엔드포인트를 정의하는 인터페이스
interface ApiService {
    // GET 요청으로 카테고리 목록을 가져오는 함수
    // suspend: 코루틴 내에서 비동기적으로 실행 가능
    // CategoriesResponse: API 응답을 매핑할 데이터 클래스
    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse
}