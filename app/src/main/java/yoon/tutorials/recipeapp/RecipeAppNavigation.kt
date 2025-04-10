package yoon.tutorials.recipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

// RecipeAppNavigation 함수는 레시피 앱의 네비게이션을 관리하는 함수
// NavHostController를 사용하여 네비게이션을 관리
// NavHostController는 Jetpack Compose에서 네비게이션을 관리하는 클래스

@Composable
fun RecipeAppNavigation(navHostController: NavHostController) {
    // MainViewModel 클래스의 인스턴스 생성
    // hiltViewModel() 함수를 사용하여 Hilt를 사용하여 MainViewModel을 주입받음
    val recipeViewModel: MainViewModel = hiltViewModel()
    val viewState by recipeViewModel.categoriesState
    // 1. RecipeScreen을 그리는 NavHost
    // 2. CategoryDetailScreen을 그리는 NavHost
    NavHost(
        navController = navHostController, startDestination = Screen.RecipeScreen.route
    )
    {
        // composable 함수를 사용하여 레시피 화면을 그리는 함수
        // Screen.RecipeScreen.route는 레시피 화면의 경로를 지정
        // 여러개의 composable 함수가 가지고 있는 navigateToDetail의 동작을 공통적으로 관리
        composable(route = Screen.RecipeScreen.route) {
            RecipeScreen(
                viewState = viewState,
                navigateToDetail = {
                    // 1. 각각의 레시피를 클릭했을때 해당 레시피 카테고리를 저장하는 과정
                    // 백스택은 네비게이션의 상태를 관리하는 객체
                    // currentBackStackEntry는 현재 백스택의 항목을 가져옴
                    // savedStateHandle은 현재 백스택 항목의 상태를 저장하는 객체
                    // set은 상태를 저장하는 함수
                    // "category"는 상태의 키값
                    // it은 CategoryItem의 인스턴스
                    navHostController.currentBackStackEntry?.savedStateHandle?.set("category", it)
                    // 2. 레시피 카테고리를 클릭했을때 해당 레시피 카테고리의 상세 화면으로 이동하는 과정
                    // navHostController.navigate는 네비게이션을 수행하는 함수
                    // "category_detail_screen"은 route의 String 참조값
                    //카테고리 클릭시 해당 카테고리를 저장하고
                    // Screen.DetailScreen.route로 이동을 선언
                    navHostController.navigate(Screen.DetailScreen.route)
                }
            )
        }
        // category를 클릭하면 실행되는 함수
        // 실제 상세화면을 표시
        // Screen.DetailScreen.route는 카테고리 상세 화면의 경로를 지정
        composable(route = Screen.DetailScreen.route) {
            // previousBackStackEntry로 이전 레시피 목록화면에서 클릭한 카테고리의 정보를 가져옴
            // 이전화면에서 가져온 키값의 객체가 null일 경우 Category("", "", "", "")로 초기화
            val category =
                navHostController.previousBackStackEntry?.savedStateHandle?.get<Category>("category")
                    ?: Category("", "", "", "")
            // Composable함수에 이전 백스택 엔트리에서 가져온 카테고리 객체를 전달
            CategoryDetailScreen(category = category)
        }
    }


}
