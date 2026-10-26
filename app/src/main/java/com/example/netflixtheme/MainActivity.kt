package com.example.netflixtheme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.netflixtheme.model.AppUtils
import com.example.netflixtheme.ui.components.NetflixBottomNavBar
import com.example.netflixtheme.ui.screens.HomeScreen
import com.example.netflixtheme.ui.theme.NetflixTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NetflixTheme {
                val apps = remember { AppUtils.getInstalledApps(this@MainActivity) }
                
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { NetflixBottomNavBar() }
                ) { _ ->
                    HomeScreen(apps = apps)
                }
            }
        }
    }
}
