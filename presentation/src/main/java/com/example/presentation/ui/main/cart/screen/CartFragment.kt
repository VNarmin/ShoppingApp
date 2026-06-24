package com.example.presentation.ui.main.cart.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.presentation.ui.theme.ShoppingAppTheme

internal class CartFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
        setContent {
            ShoppingAppTheme {
                CartScreen(
                    onNavigateBack = {
                        findNavController().popBackStack()
                    },
                    onNavigateToCheckout = {
                        findNavController().navigate(
                            directions = CartFragmentDirections.actionCartFragmentToCheckoutFragment()
                        )
                    }
                )
            }
        }
    }
}