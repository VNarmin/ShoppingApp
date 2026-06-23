package com.example.presentation.ui.more.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.presentation.ui.more.mvi.MoreEffect
import com.example.presentation.ui.more.mvi.MoreViewModel
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
internal fun MoreScreen(
    viewModel: MoreViewModel = koinViewModel(),
    onNavigateToCategoryDetail: (String) -> Unit,
    onNavigateToHome: () -> Unit
) {
    val moreScreenState = viewModel.collectAsState().value

    LaunchedEffect(Unit) {
        viewModel.loadScreen()
    }

    viewModel.collectSideEffect { effect ->
        when (effect) {
            is MoreEffect.NavigateToCategoryDetail -> onNavigateToCategoryDetail(effect.categoryID)
            is MoreEffect.NavigateToHome -> onNavigateToHome()
            is MoreEffect.Error -> {}
        }
    }

    MoreScreenContent(
        stateProvider = { moreScreenState },
        onCategoryClick = viewModel::onCategoryClick,
        onHomeClick = viewModel::onHomeClick
    )
}