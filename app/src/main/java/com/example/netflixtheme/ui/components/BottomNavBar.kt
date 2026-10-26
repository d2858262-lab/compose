package com.example.netflixtheme.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.netflixtheme.ui.theme.*

data class BottomNavItem(val label: String, val icon: ImageVector, val selectedIcon: ImageVector)

@Composable
fun NetflixBottomNavBar(modifier: Modifier = Modifier) {
    var selectedIndex by remember { mutableIntStateOf(0) }
    val items = listOf(
        BottomNavItem("Ana Sayfa", Icons.Outlined.Home, Icons.Filled.Home),
        BottomNavItem("Oyunlar", Icons.Outlined.SportsEsports, Icons.Outlined.SportsEsports),
        BottomNavItem("Yeni", Icons.Outlined.VideoLibrary, Icons.Outlined.VideoLibrary),
        BottomNavItem("Listem", Icons.Outlined.Download, Icons.Outlined.Download),
    )
    NavigationBar(
        modifier = modifier.height(64.dp),
        containerColor = NetflixBlack.copy(alpha = 0.95f),
        contentColor = NetflixWhite,
        tonalElevation = 0.dp
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedIndex == index,
                onClick = { selectedIndex = index },
                icon = {
                    Icon(
                        if (selectedIndex == index) item.selectedIcon else item.icon,
                        contentDescription = item.label
                    )
                },
                label = { Text(item.label, style = MaterialTheme.typography.labelSmall) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = NetflixWhite, unselectedIconColor = NetflixTextGray,
                    selectedTextColor = NetflixWhite, unselectedTextColor = NetflixTextGray,
                    indicatorColor = NetflixBlack.copy(alpha = 0f)
                )
            )
        }
    }
}
