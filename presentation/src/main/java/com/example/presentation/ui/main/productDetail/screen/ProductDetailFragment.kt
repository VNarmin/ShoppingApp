package com.example.presentation.ui.main.productDetail.screen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.presentation.ui.theme.ShoppingAppTheme

internal class ProductDetailFragment : Fragment() {
    private val args: ProductDetailFragmentArgs by navArgs()

    companion object {
        private const val TAG = "ProductDetailFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "onCreateView — productID = '${args.productID}'")

        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                ShoppingAppTheme {
                    ProductDetailScreen(
                        productID = args.productID,
                        onNavigateBack = {
                            Log.d(TAG, "onNavigateBack clicked")
                            findNavController().popBackStack()
                        },
                        onNavigateToCart = {
                            Log.d(TAG, "onNavigateToCart clicked")
                            findNavController().navigate(
                                directions = ProductDetailFragmentDirections.actionProductDetailFragmentToCartFragment()
                            )
                        },
                        onNavigateToCheckout = {
                            Log.d(TAG, "onNavigateToCheckout clicked")
                            findNavController().navigate(
                                directions = ProductDetailFragmentDirections.actionProductDetailFragmentToCheckoutFragment()
                            )
                        },
                    )
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView")
    }
}