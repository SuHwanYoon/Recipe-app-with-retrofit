package yoon.tutorials.recipeapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//Model Class
//API의 응답을 매핑할 데이터 클래스
//따라서 API의 응답과 동일한 구조로 데이터 클래스를 정의
// Parcelable 인터페이스를 구현하여 안드로이드에서 객체를 직렬화할 수 있도록 함
// deserialization: 바이트 스트림을 다시 객체로 변환하여 사용할 수 있도록 함
// Server Json Response -> Gson deserialization ->  Kotlin 객체로 변환
// serialization: 객체를 바이트 스트림으로 변환하여 저장하거나 전송할 수 있도록 함
// Kotlin 객체 -> Gson serialization -> Json으로 변환
@Parcelize
data class Category (
    // 카테고리 ID
    val idCategory : String,
    // 카테고리 이름
    val strCategory : String,
    // 카테고리 이미지 URL
    val strCategoryThumb : String,
    // 카테고리 설명
    val strCategoryDescription : String
) : Parcelable

// Category데이터 클래스의 리스트가 담기는 데이터 클래스
data class CategoriesResponse(val categories : List<Category>)

// API 응답의 예시
// The meal DB API
//"idCategory": "1",
//"strCategory": "Beef",
//"strCategoryThumb": "https://www.themealdb.com/images/category/beef.png",
//"strCategoryDescription"