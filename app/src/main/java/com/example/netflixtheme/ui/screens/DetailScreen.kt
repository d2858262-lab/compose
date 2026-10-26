package com.example.netflixtheme.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflixtheme.model.Movie
import com.example.netflixtheme.model.SampleData
import com.example.netflixtheme.ui.theme.*

@Composable
fun DetailScreen(movie: Movie = SampleData.featuredMovie, onBackClick: () -> Unit = {}) {
    Column(modifier = Modifier.fillMaxSize().background(NetflixBlack).verticalScroll(rememberScrollState())) {
        Box(modifier = Modifier.fillMaxWidth().height(250.dp).background(
            Brush.verticalGradient(colors = listOf(NetflixDarkRed.copy(alpha = 0.5f), NetflixBlack))
        )) {
            IconButton(onClick = onBackClick, modifier = Modifier.align(Alignment.TopStart).padding(16.dp).statusBarsPadding()) {
                Icon(Icons.Default.ArrowBack, "Geri", tint = NetflixWhite)
            }
            FilledIconButton(onClick = {}, modifier = Modifier.align(Alignment.Center).size(56.dp),
                colors = IconButtonDefaults.filledIconButtonColors(
                    containerColor = NetflixWhite.copy(alpha = 0.9f), contentColor = NetflixBlack)) {
                Icon(Icons.Default.PlayArrow, "Oynat", modifier = Modifier.size(36.dp))
            }
        }
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text(movie.title, style = MaterialTheme.typography.headlineLarge)
            Spacer(Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                if (movie.matchPercentage > 0)
                    Text("%${movie.matchPercentage} Eslesme", style = MaterialTheme.typography.bodyMedium.copy(color = NetflixGreen, fontWeight = FontWeight.Bold))
                Text(movie.year, style = MaterialTheme.typography.bodyMedium)
                Box(modifier = Modifier.background(NetflixLightGray, MaterialTheme.shapes.extraSmall).padding(horizontal = 6.dp, vertical = 2.dp)) {
                    Text(movie.rating, style = MaterialTheme.typography.labelSmall.copy(color = NetflixWhite, fontSize = 10.sp))
                }
                Text(movie.duration, style = MaterialTheme.typography.bodyMedium)
            }
            Spacer(Modifier.height(16.dp))
            Button(onClick = {}, modifier = Modifier.fillMaxWidth().height(42.dp),
                colors = ButtonDefaults.buttonColors(containerColor = NetflixWhite, contentColor = NetflixBlack),
                shape = MaterialTheme.shapes.small) {
                Icon(Icons.Default.PlayArrow, null, modifier = Modifier.size(24.dp))
                Spacer(Modifier.width(8.dp))
                Text("Oynat", style = MaterialTheme.typography.labelLarge.copy(color = NetflixBlack, fontWeight = FontWeight.Bold))
            }
            Spacer(Modifier.height(8.dp))
            Button(onClick = {}, modifier = Modifier.fillMaxWidth().height(42.dp),
                colors = ButtonDefaults.buttonColors(containerColor = NetflixMediumGray, contentColor = NetflixWhite),
                shape = MaterialTheme.shapes.small) {
                Icon(Icons.Outlined.Download, null, modifier = Modifier.size(20.dp))
                Spacer(Modifier.width(8.dp))
                Text("Indir", style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold))
            }
            Spacer(Modifier.height(16.dp))
            Text(movie.description, style = MaterialTheme.typography.bodyMedium.copy(color = NetflixWhite.copy(alpha = 0.9f), lineHeight = 22.sp))
            Spacer(Modifier.height(8.dp))
            Text("Tur: ${movie.genre.joinToString(", ")}", style = MaterialTheme.typography.bodySmall.copy(color = NetflixTextGray))
            Spacer(Modifier.height(24.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                ActionButton(Icons.Outlined.Add, "Listem")
                ActionButton(Icons.Outlined.ThumbUp, "Puanla")
                ActionButton(Icons.Outlined.Share, "Paylas")
                ActionButton(Icons.Outlined.Download, "Indir")
            }
            Spacer(Modifier.height(80.dp))
        }
    }
}

@Composable
fun ActionButton(icon: ImageVector, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(6.dp)) {
        Icon(icon, label, tint = NetflixWhite, modifier = Modifier.size(28.dp))
        Text(label, style = MaterialTheme.typography.labelSmall.copy(color = NetflixTextGray))
    }
}
