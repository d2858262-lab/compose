package com.example.netflixtheme.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflixtheme.ui.theme.*

@Composable
fun NetflixTopBar(isScrolled: Boolean = false, modifier: Modifier = Modifier) {
    val backgroundColor = animateColorAsState(
        targetValue = if (isScrolled) NetflixBlack else Color.Transparent,
        label = "topBarBg"
    )
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(backgroundColor.value)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "B",
                style = MaterialTheme.typography.displayLarge.copy(
                    fontSize = 40.sp, fontWeight = FontWeight.Black, color = NetflixRed
                )
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { }) {
                    Icon(Icons.Default.Search, "Ara", tint = NetflixWhite, modifier = Modifier.size(28.dp))
                }
                IconButton(onClick = { }) {
                    Icon(Icons.Outlined.Notifications, "Bildirimler", tint = NetflixWhite, modifier = Modifier.size(28.dp))
                }
                Box(
                    modifier = Modifier.size(28.dp).background(NetflixRed, MaterialTheme.shapes.small),
                    contentAlignment = Alignment.Center
                ) {
                    Text("K", style = MaterialTheme.typography.labelSmall.copy(color = NetflixWhite, fontWeight = FontWeight.Bold))
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CategoryChip("Diziler")
            CategoryChip("Filmler")
            CategoryChip("Kategoriler")
        }
    }
}

@Composable
fun CategoryChip(text: String) {
    Box(
        modifier = Modifier
            .background(NetflixWhite.copy(alpha = 0.08f), MaterialTheme.shapes.extraLarge)
            .padding(horizontal = 14.dp, vertical = 6.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text, style = MaterialTheme.typography.labelLarge.copy(fontSize = 13.sp, color = NetflixWhite))
    }
}
