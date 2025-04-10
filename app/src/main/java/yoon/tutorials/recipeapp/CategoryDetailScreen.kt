package yoon.tutorials.recipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun CategoryDetailScreen(category: Category) {
    // Column 함수를 사용하여 카테고리 상세 화면을 그리는데, Column은 세로로 나열되는 UI 컴포넌트
    // Column 함수는 Modifier를 사용하여 UI 컴포넌트의 크기와 위치를 조정할수있음
    // Modifier.fillMaxSize()를 사용하여 화면 전체를 차지하도록 함
    // Modifier.padding(16.dp)를 사용하여 UI 컴포넌트의 여백을 설정함
    // horizontalAlignment를 사용하여 UI 컴포넌트의 정렬을 설정할수있음
    Column(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
    ) {
        // Text 함수를 사용하여 카테고리 이름을 표시
        // text 속성을 사용하여 표시할 텍스트를 지정
        // textAlign 속성을 사용하여 텍스트의 정렬을 설정
        // fontWeight 속성을 사용하여 텍스트의 두께를 설정
        // fontSize 속성을 사용하여 텍스트의 크기를 설정
        // color 속성을 사용하여 텍스트의 색상을 설정
        Text(
            text = category.strCategory,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )
        // image 함수를 사용하여 카테고리 이미지를 표시
        // image 함수는 Coil 라이브러리의 rememberAsyncImagePainter 함수를 사용하여 이미지를 로드
        // rememberAsyncImagePainter 함수를 사용하여 이미지를 로드
        // model 속성을 사용하여 이미지 URL을 지정
        // contentDescription 속성을 사용하여 이미지에 대한 설명을 추가
        // modifier 속성을 사용하여 이미지의 크기를 조정
        // wrapContentSize 함수는 이미지의 크기를 내용에 맞게 조정함
        // aspectRatio 함수를 사용하여 이미지의 가로세로 비율을 1:1로 설정
        // 가로세로 비율을 1:1로 설정하면 이미지가 정사각형 모양으로 보임
        // contentDescription 속성을 사용하여 이미지에 대한 설명을 추가
        Image(
            painter = rememberAsyncImagePainter(model = category.strCategoryThumb),
            contentDescription = "${category.strCategory} Thumbail",
            modifier = Modifier
                .wrapContentSize()
                .aspectRatio(1f)
        )
        // Text 함수를 사용하여 카테고리 설명을 표시
        // text 속성을 사용하여 표시할 텍스트를 지정
        // textAlign 속성을 사용하여 텍스트의 정렬을 설정
        // verticalScroll 함수를 사용하여 스크롤이 가능하도록 설정
        // rememberScrollState 함수를 사용하여 스크롤 상태를 기억함
        Text(
            text = category.strCategoryDescription,
            textAlign = TextAlign.Justify,
            modifier = Modifier.verticalScroll(rememberScrollState())
        )
    }
}