package com.example.pulperia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.pulperia.ui.screens.OrderScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Usamos un tema limpio y cargamos nuestra pantalla principal
            MaterialTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    OrderScreen()
                }
            }
        }
    }
}