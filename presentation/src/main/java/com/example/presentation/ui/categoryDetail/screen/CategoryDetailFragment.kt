package com.example.presentation.ui.categoryDetail.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import com.example.presentation.ui.theme.ShoppingAppTheme

internal class CategoryDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
        setContent {
            ShoppingAppTheme {
                CategoryDetailScreen(
                    categoryID = "", // should come from the previous screen
                    onNavigateToMore = {},
                    onNavigateToProductDetail = {},
                    onNavigateToHome = {}
                )
            }
        }
    }
}