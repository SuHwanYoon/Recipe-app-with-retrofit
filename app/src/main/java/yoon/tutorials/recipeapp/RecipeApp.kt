package yoon.tutorials.recipeapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// HiltAndroidApp 어노테이션을 사용하여 Hilt가 이 Application 클래스를 관리하도록 함
@HiltAndroidApp
class RecipeApp : Application()