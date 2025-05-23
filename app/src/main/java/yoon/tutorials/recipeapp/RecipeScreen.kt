package yoon.tutorials.recipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
// Coil 라이브러리의 rememberAsyncImagePainter 함수를 사용하기 위해 import
import coil.compose.rememberAsyncImagePainter

// 레시피 화면을 그리는 UI 함수
// UI호출의 작동흐름은 MainActivity에서 RecipeScreen을 호출하고
// RecipeScreen에서 MainViewModel을 호출하여 API를 호출하고
// API의 응답을 받아서 RecipeState를 업데이트하고
// RecipeState를 사용하여 UI를 그리는 구조
// @Composable함수의 동작 흐름은 RecipeScreen -> CategoryScreen -> CategoryItem
// navigateToDetail 함수로 연결되어있음
@Composable
fun RecipeScreen(
    modifier: Modifier = Modifier,
    viewState: MainViewModel.RecipeState
    , navigateToDetail: (Category) -> Unit
) {
    // MainViewModel 클래스의 인스턴스 생성
//    val recipeViewModel: MainViewModel = viewModel()
    // data 클래스의 상태를 변경할수있는
    // categoriesState 변수를 상태를 관리
    // categoriesState 변수는 State<RecipeState> 타입이므로
    // by 키워드로 viewState가 자동으로 업데이트 되도록 함
    // viewState 변수는 표시하려는 데이터를 로드 했는지에 대한 정보를 제공
//    val viewState by recipeViewModel.categoriesState
    // Box 함수를 사용하여 로딩중일때, 에러일때, 데이터가 있을때의 UI를 그림
    Box(modifier = Modifier.fillMaxSize()) {
        when {
            // 로딩중일때
            viewState.loading -> {
                // CircularProgressIndicator를 그리는데, align을 사용하여 중앙에 위치하도록 함
                // CircularProgressIndicator는 로딩중일때 동그라미가 돌아가는 UI 컴포넌트
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }
            // 에러가 발생했을때
            viewState.error != null -> {
                Text(text = "Error!")
            }
            // 데이터가 있을때
            else -> {
                // CategoryScreen 함수를 사용하여 카테고리 화면을 그림
                // CategoryScreen 함수는 Category 데이터 클래스의 리스트를 받아서 화면을 그림
                CategoryScreen(
                    categories = viewState.list, navigateToDetail = navigateToDetail
                )
            }
        }
    }
}

// API호출이 되었을때 카테고리 화면을 그리는 UI 함수
@Composable
// CategoryScreen 함수는 Category 데이터 클래스의 리스트를 받아서 화면을 그림
// categories 속성은 Category 데이터 클래스의 리스트
// navigateToDetail 속성은 카테고리 아이템을 클릭했을때 상세 화면으로 이동하는 함수를 받음
// navigateToDetail 속성은 Category 데이터 클래스를 인자로 받는 함수
fun CategoryScreen(
    categories: List<Category>?, navigateToDetail: (Category) -> Unit
) {
    // LazyVerticalGrid 함수를 사용하여 그리드 형태의 리스트를 그림
    // columns 속성을 사용하여 그리드의 열의 개수를 지정
    // GridCells.Fixed(2)를 사용하여 2열로 그리드를 그림
    // modifier 속성을 사용하여 LazyVerticalGrid의 크기를 화면에 꽉 채우도록 함
    // LazyVerticalGrid는 세로 방향으로 스크롤이 가능한 그리드 형태의 리스트를 그림
    // LazyVerticalGrid는 스마트폰에서 스크롤을 내리면서 화면에 따라 데이터를 렌더링한다
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), modifier = Modifier.fillMaxSize()
    ) {
        // JetpackComose items 함수를 사용하여 categories 리스트의 아이템을 그림
        // categories 리스트가 null일 경우 빈 리스트를 전달
        // null이 아니면 categories 리스트를 전달
        items(categories ?: emptyList()) {
            // 각 항목에 대해서 CategoryItem 함수를 호출하는 람다함수
            category ->
            // CategoryItem 함수를 사용하여 카테고리 아이템을 그림
            //navigateToDetail 속성을 사용하여 카테고리 아이템을 클릭했을때 상세 화면으로 이동하는 함수를 받음
            CategoryItem(
                category = category, navigateToDetail = navigateToDetail
            )
        }
    }
}


// 카테고리 아이템을 그리는 UI 함수
@Composable
// CategoryItem 함수는 Category 데이터 클래스를 받아서 카테고리 아이템을 그림
// navigateToDetail 속성을 사용하여 카테고리 아이템을 클릭했을때 상세 화면으로 이동하는 함수를 받음
// navigateToDetail 속성은 Category 데이터 클래스를 인자로 받는 함수
// navigateToDetail 속성은 카테고리 아이템을 클릭했을때 상세 화면으로 이동하는 함수를 받음
fun CategoryItem(
    category: Category,
    navigateToDetail: (Category) -> Unit
) {
    // Column 함수를 사용하여 세로 방향으로 UI를 그림
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .clickable {
                // 카테고리 아이템을 클릭했을때 navigateToDetail 함수를 호출
                navigateToDetail(category)
            }, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Image 함수를 사용하여 이미지를 그림
        Image(
            // rememberAsyncImagePainter 함수를 사용하여 이미지를 로드
            // model 속성을 사용하여 이미지 URL을 지정
            painter = rememberAsyncImagePainter(model = category.strCategoryThumb),
            // contentDescription 속성을 사용하여 이미지에 대한 설명을 추가
            contentDescription = null,
            // modifier 속성을 사용하여 이미지의 크기를 조정
            // fillMaxSize 함수를 사용하여 이미지가 화면을 꽉 채우도록 함
            // aspectRatio 함수를 사용하여 이미지의 가로세로 비율을 1:1로 설정
            // 가로세로 비율을 1:1로 설정하면 이미지가 정사각형 모양으로 보임
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
        )

        // Category 데이터 클래스의 strCategory 속성을 사용하여 카테고리 이름을 표시
        Text(
            // 텍스트 속성을 사용하여 텍스트를 표시
            // category.strCategory 속성을 사용하여 카테고리 이름을 표시
            text = category.strCategory,
            color = Color.Black,
            style = TextStyle(fontWeight = FontWeight.Bold),
            // padding을 사용하여 텍스트의 상단에 여백을 추가
            modifier = Modifier.padding(top = 4.dp)
        )

    }
}

