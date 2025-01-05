package yoon.tutorials.recipeapp

//Model Class
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