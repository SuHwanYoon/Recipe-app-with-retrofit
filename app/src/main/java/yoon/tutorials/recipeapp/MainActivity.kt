package yoon.tutorials.recipeapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import yoon.tutorials.recipeapp.ui.theme.RecipeAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // rememberNavController() 함수를 사용하여 NavHostController를 생성
            // NavHostController는 Jetpack Compose에서 네비게이션을 관리하는 클래스
            // 전역으로 선언된 navigation함수에 NavHostController를 전달
            // RecipeAppNavigation 함수가 가장 먼저 호출됨
            val navHostController = rememberNavController()
            RecipeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // RecipeAppNavigation 함수를 사용하여 레시피 앱의 네비게이션을 관리
                    // RecipeAppNavigation 함수는 NavHostController를 사용하여 네비게이션을 관리
                    RecipeAppNavigation(navHostController = navHostController)
                    // RecipeScreen 함수를 사용하여 레시피 화면을 그림
                    // RecipeScreen 함수는 레시피 화면을 그리는 UI 함수
//                    RecipeScreen()
                }
            }
        }
    }
}

