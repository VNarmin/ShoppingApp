package com.example.presentation.ui.productDetail.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.presentation.ui.theme.ShoppingAppTheme

internal class ProductDetailFragment : Fragment() {
    private val args : ProductDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
        setContent {
            ShoppingAppTheme {
                ProductDetailScreen(
                    productID = args.productID,
                    onNavigateBack = {
                        findNavController().popBackStack()
                    },
                    onNavigateToCart = {
                        findNavController().navigate(
                            directions = ProductDetailFragmentDirections.actionProductDetailFragmentToCartFragment()
                        )
                    },
                    onNavigateToCheckout = {
                        findNavController().navigate(
                            directions = ProductDetailFragmentDirections.actionProductDetailFragmentToCheckoutFragment()
                        )
                    },
                )
            }
        }
    }
}