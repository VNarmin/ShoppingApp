package com.example.presentation.ui.more.screen

import androidx.compose.runtime.Composable
import com.example.presentation.ui.more.mvi.MoreEffect
import com.example.presentation.ui.more.mvi.MoreViewModel
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
internal fun MoreScreen(
    viewModel : MoreViewModel = koinViewModel(),
    onNavigateToCategoryDetail: () -> Unit,
    onNavigateToHome: () -> Unit
) {
    val moreScreenState = viewModel.collectAsState().value

    viewModel.collectSideEffect { effect ->
        when (effect) {
            is MoreEffect.NavigateToCategoryDetail -> onNavigateToCategoryDetail()
            is MoreEffect.NavigateToHome -> onNavigateToHome()
            is MoreEffect.Error -> {}
        }
    }
}