package yoon.tutorials.recipeapp

//Model Class
//API의 응답을 매핑할 데이터 클래스
//따라서 API의 응답과 동일한 구조로 데이터 클래스를 정의
data class Category (
    // 카테고리 ID
    val idCategory : String,
    // 카테고리 이름
    val strCategory : String,
    // 카테고리 이미지 URL
    val strCategoryThumb : String,
    // 카테고리 설명
    val strCategoryDescription : String
)

// Category데이터 클래스의 리스트가 담기는 데이터 클래스
data class CategoriesResponse(val categories : List<Category>)

// The meal DB API
//"idCategory": "1",
//"strCategory": "Beef",
//"strCategoryThumb": "https://www.themealdb.com/images/category/beef.png",
//"strCategoryDescription"