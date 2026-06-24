package com.example.presentation.ui.main.categoryDetail.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.presentation.ui.theme.ShoppingAppTheme

internal class CategoryDetailFragment : Fragment() {
    private val args: CategoryDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
        setContent {
            ShoppingAppTheme {
                CategoryDetailScreen(
                    categoryID = args.categoryID,
                    onNavigateToMore = {
                        findNavController().popBackStack()
                    },
                    onNavigateToProductDetail = { productID ->
                        findNavController().navigate(
                            directions = CategoryDetailFragmentDirections.actionCategoryDetailFragmentToProductDetailFragment(productID = productID)
                        )
                    },
                    onNavigateToHome = {
                        findNavController().navigate(
                            directions = CategoryDetailFragmentDirections.actionCategoryDetailFragmentToHomeFragment()
                        )
                    }
                )
            }
        }
    }
}