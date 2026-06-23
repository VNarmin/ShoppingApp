package com.example.presentation.ui.categoryDetail.screen

import androidx.compose.runtime.Composable
import com.example.presentation.ui.categoryDetail.mvi.CategoryDetailEffect
import com.example.presentation.ui.categoryDetail.mvi.CategoryDetailViewModel
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
internal fun CategoryDetailScreen(
    viewModel: CategoryDetailViewModel = koinViewModel(),
    onNavigateToMore: () -> Unit,
    onNavigateToProductDetail: () -> Unit,
    onNavigateToHome: () -> Unit
) {
    val categoryDetailScreenState = viewModel.collectAsState().value

    viewModel.collectSideEffect { effect ->
        when (effect) {
            is CategoryDetailEffect.NavigateToMore -> onNavigateToMore()
            is CategoryDetailEffect.NavigateToProductDetail -> onNavigateToProductDetail()
            is CategoryDetailEffect.NavigateToHome -> onNavigateToHome()
            is CategoryDetailEffect.Error -> {}
        }
    }

    CategoryDetailScreenContent(
        stateProvider = { categoryDetailScreenState },
        onBackClick = viewModel::onBackClick,
        onHomeClick = viewModel::onHomeClick,
        onProductClick = viewModel::onProductClick
    )
}