package com.example.presentation.ui.main.categoryDetail.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.presentation.ui.main.categoryDetail.mvi.CategoryDetailEffect
import com.example.presentation.ui.main.categoryDetail.mvi.CategoryDetailViewModel
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
internal fun CategoryDetailScreen(
    categoryID: String,
    viewModel: CategoryDetailViewModel = koinViewModel(),
    onNavigateToMore: () -> Unit,
    onNavigateToProductDetail: (String) -> Unit,
    onNavigateToHome: () -> Unit
) {
    val categoryDetailScreenState = viewModel.collectAsState().value

    LaunchedEffect(categoryID) {
        viewModel.loadScreen(categoryID = categoryID)
    }

    viewModel.collectSideEffect { effect ->
        when (effect) {
            is CategoryDetailEffect.NavigateToMore -> onNavigateToMore()
            is CategoryDetailEffect.NavigateToProductDetail -> onNavigateToProductDetail(effect.productID)
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