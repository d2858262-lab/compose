package com.example.netflixtheme.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflixtheme.model.Movie
import com.example.netflixtheme.ui.theme.*

@Composable
fun MovieCard(movie: Movie, width: Dp = 120.dp, height: Dp = 170.dp, onClick: () -> Unit = {}) {
    Column(modifier = Modifier.width(width).clickable(onClick = onClick)) {
        Box(
            modifier = Modifier
                .width(width).height(height)
                .clip(MaterialTheme.shapes.small)
                .background(NetflixDarkGray)
        ) {
            Box(modifier = Modifier.fillMaxSize().background(
                Brush.verticalGradient(colors = listOf(NetflixMediumGray, NetflixDarkGray))
            ))
            Box(
                modifier = Modifier.fillMaxSize().background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.8f)), startY = 100f
                    )
                ),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    movie.title,
                    style = MaterialTheme.typography.bodySmall.copy(color = NetflixWhite, fontWeight = FontWeight.Medium),
                    maxLines = 2, overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(8.dp)
                )
            }
            if (movie.isNewEpisode) {
                Box(
                    modifier = Modifier.align(Alignment.TopCenter).fillMaxWidth()
                        .background(NetflixRed).padding(vertical = 2.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Yeni Bolum", style = MaterialTheme.typography.labelSmall.copy(
                        color = NetflixWhite, fontWeight = FontWeight.Bold, fontSize = 9.sp
                    ))
                }
            }
        }
    }
}

@Composable
fun TopTenMovieCard(movie: Movie, onClick: () -> Unit = {}) {
    Row(
        modifier = Modifier.clickable(onClick = onClick).height(180.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "${movie.topTenRank}",
            style = MaterialTheme.typography.displayLarge.copy(
                fontSize = 80.sp, fontWeight = FontWeight.Black, color = NetflixWhite.copy(alpha = 0.3f)
            ),
            modifier = Modifier.width(60.dp)
        )
        Box(
            modifier = Modifier.width(120.dp).height(170.dp)
                .clip(MaterialTheme.shapes.small)
                .background(Brush.verticalGradient(
                    colors = listOf(NetflixDarkRed.copy(alpha = 0.6f), NetflixDarkGray)
                )),
            contentAlignment = Alignment.BottomStart
        ) {
            Text(movie.title, style = MaterialTheme.typography.titleSmall,
                maxLines = 2, overflow = TextOverflow.Ellipsis, modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun ContinueWatchingCard(movie: Movie, progress: Float = 0.3f, onClick: () -> Unit = {}) {
    Column(modifier = Modifier.width(140.dp).clickable(onClick = onClick)) {
        Box(
            modifier = Modifier.width(140.dp).height(80.dp)
                .clip(MaterialTheme.shapes.small).background(NetflixDarkGray)
        ) {
            Box(modifier = Modifier.fillMaxSize().background(
                Brush.horizontalGradient(colors = listOf(NetflixMediumGray, NetflixLightGray.copy(alpha = 0.5f)))
            ))
            Box(modifier = Modifier.fillMaxSize().background(Color.Black.copy(alpha = 0.4f)),
                contentAlignment = Alignment.Center) {
                Text(movie.title, style = MaterialTheme.typography.bodySmall.copy(
                    color = NetflixWhite, fontWeight = FontWeight.Bold), maxLines = 1)
            }
        }
        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier.fillMaxWidth().height(3.dp),
            color = NetflixRed, trackColor = NetflixLightGray,
        )
        Row(
            modifier = Modifier.fillMaxWidth().background(NetflixDarkGray)
                .padding(horizontal = 8.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(movie.duration, style = MaterialTheme.typography.labelSmall)
            Icon(Icons.Default.PlayArrow, "Oynat", tint = NetflixWhite, modifier = Modifier.size(20.dp))
        }
    }
}
