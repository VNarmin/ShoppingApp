package com.example.presentation.ui.main.home.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.presentation.ui.theme.ShoppingAppTheme

internal class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
        setContent {
            ShoppingAppTheme {
                HomeScreen(
                    onNavigateToCart = {
                        findNavController().navigate(
                            directions = HomeFragmentDirections.actionHomeFragmentToCartFragment()
                        )
                    },
                    onNavigateToProductDetail = { productID ->
                        findNavController().navigate(
                            directions = HomeFragmentDirections.actionHomeFragmentToProductDetailFragment(productID = productID)
                        )
                    },
                    onNavigateToMore = {
                        findNavController().navigate(
                            directions = HomeFragmentDirections.actionHomeFragmentToMoreFragment()
                        )
                    }
                )
            }
        }
    }
}