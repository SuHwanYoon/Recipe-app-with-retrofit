package yoon.tutorials.recipeapp

//Model Class
data class Category (
    val idCategory : String,
    val strCategory : String,
    val strCategoryThumb : String,
    val strCategoryDescription : String
)

data class CategoriesResponse(val categories : List<Category>)

// The meal DB API
//"idCategory": "1",
//"strCategory": "Beef",
//"strCategoryThumb": "https://www.themealdb.com/images/category/beef.png",
//"strCategoryDescription"