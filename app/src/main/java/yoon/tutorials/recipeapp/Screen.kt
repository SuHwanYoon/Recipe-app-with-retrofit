package yoon.tutorials.recipeapp

// Navigation을 위한 Screen 객체
// Screen 객체는 네비게이션을 위한 경로를 정의하는 객체
// route문자열을 직접 참조하는 대신 객체이름.route로 참조
sealed class Screen(val route: String) {
    object RecipeScreen : Screen("recipe_screen")
    object DetailScreen : Screen("category_detail_screen")

}