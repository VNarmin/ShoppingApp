package com.example.presentation.ui.auth.login.screen

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.presentation.ui.main.MainActivity
import com.example.presentation.ui.theme.ShoppingAppTheme

internal class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
        setContent {
            ShoppingAppTheme {
                LoginScreen(
                    onNavigateToHome = {
                        requireActivity().run {
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()
                        }
                    },
                    onNavigateToRegister = {
                        findNavController().navigate(
                            directions = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
                        )
                    }
                )
            }
        }
    }
}