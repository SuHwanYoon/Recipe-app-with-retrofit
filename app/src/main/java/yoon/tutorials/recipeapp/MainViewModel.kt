package yoon.tutorials.recipeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {

    // 상태를 관리할 때 사용할 변수
    // mutableStateOf 함수를 사용하여 상태를 관리
    // mutableStateOf 함수는 상태를 변경할 수 있는 변수를 생성
    // RecipeState 클래스는 로딩 중인지 여부, 레시피 목록, 에러 메시지를 관리
    private val _categorieState = mutableStateOf(RecipeState())

    // State 변수는 상태를 가져오기만 하고 변경을 할수가 없음
    // State 변수는 RecipeState 클래스를 사용하여 상태를 가져옴
    // 외부로 노출할 변수 State로 변하지않는 상태의 변수를 선언
    val categoriesState: State<RecipeState> = _categorieState

    // MainViewModel 클래스가 생성될때 자동으로 fetchCategories()가 실행되는 초기화 블록
    init {
        fetchCategories()
    }

    // ApiService 인터페이스를 사용하여 API 요청을 보내기 위한 변수
    private fun fetchCategories() {
        // viewModelScope.launch 함수를 사용하여 코루틴을 실행
        // viewModelScope.launch 함수는 ViewModel이 제거될 때 코루틴을 취소
        viewModelScope.launch {
            // 코루틴 내에서 비동기 작업을 수행
            try {
                // recipeService.getCategories() 함수를 호출하여 카테고리 목록을 가져옴
                // recipeService.getCategories() 함수는 API 요청을 보내고 응답을 받음
                val response = recipeService.getCategories()
                // 카테고리 목록을 가져오면 상태를 변경
                // _categorieState.value 변수에 copy 함수를 사용하여 상태를 변경
                // copy 함수로 기존 데이터 클래스 객체를 복사하고 특정 속성만 변경
                _categorieState.value = _categorieState.value.copy(
                    // API 응답에서 카테고리 목록을 가져와서 상태를 변경
                    list = response.categories,
                    loading = false,
                    error = null
                )
            }catch (e: Exception) {
                // 에러가 발생하면 상태를 변경
                // _categorieState.value 변수에 copy 함수를 사용하여 상태를 변경
                // copy 함수는 RecipeState 클래스의 복사본을 생성
                // copy 함수는 변경된 값을 전달하여 새로운 RecipeState 객체를 생성
                // copy 함수는 변경된 값을 전달하지 않으면 기존 객체를 그대로 반환
                _categorieState.value = _categorieState.value.copy(
                    loading = false,
                    error = "Error fetching Categories ${e.message}"
                )
            }
        }
    }

    // RecipeState 클래스를 사용하여 상태를 관리
    // RecipeState 클래스는 로딩 중인지 여부, 레시피 목록, 에러 메시지를 관리
    data class RecipeState(
        // 로딩 중인지 여부
        // 초기값은 true로 설정하여 로딩중임을 표시
        val loading: Boolean = true,
        // 레시피 목록
        // 초기값은 빈 리스트
        // 레시피 목록을 가져오지 못하면 빈 리스트로 초기화
        val list: List<Category> = emptyList(),
        val error: String? = null
    )
}