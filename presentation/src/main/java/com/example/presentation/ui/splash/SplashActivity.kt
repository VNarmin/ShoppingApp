package com.example.presentation.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.presentation.ui.auth.AuthActivity
import com.example.presentation.ui.main.MainActivity
import com.example.presentation.ui.splash.screen.SplashScreen
import com.example.presentation.ui.theme.ShoppingAppTheme

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingAppTheme {
                SplashScreen(
                    onNavigateToAuth = {
                        startActivity(Intent(this, AuthActivity::class.java))
                        finish()
                    },
                    onNavigateToMain = {
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    }
                )
            }
        }
    }
}