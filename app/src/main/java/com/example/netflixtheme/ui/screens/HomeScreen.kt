package com.example.netflixtheme.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflixtheme.model.SampleData
import com.example.netflixtheme.ui.components.*
import com.example.netflixtheme.ui.theme.*

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val listState = rememberLazyListState()
    val isScrolled by remember { derivedStateOf { listState.firstVisibleItemScrollOffset > 0 } }

    Box(modifier = modifier.fillMaxSize().background(NetflixBlack)) {
        LazyColumn(state = listState, modifier = Modifier.fillMaxSize()) {
            item { FeaturedContent() }
            item { Spacer(Modifier.height(16.dp)); ContinueWatchingRow(SampleData.continueWatching) }
            item { Spacer(Modifier.height(24.dp)); TopTenRow(SampleData.trendingMovies) }
            item { Spacer(Modifier.height(24.dp)); MovieRow("Populer Filmler", SampleData.popularMovies) }
            item { Spacer(Modifier.height(24.dp)); MovieRow("Aksiyon & Macera", SampleData.popularMovies.shuffled()) }
            item { Spacer(Modifier.height(24.dp)); MovieRow("Bilim Kurgu & Fantastik", SampleData.trendingMovies.shuffled()) }
            item { Spacer(Modifier.height(24.dp)); MovieRow("Odullu Filmler", SampleData.popularMovies.reversed()) }
            item { Spacer(Modifier.height(80.dp)) }
        }
        NetflixTopBar(isScrolled = isScrolled, modifier = Modifier.align(Alignment.TopCenter))
    }
}

@Composable
fun FeaturedContent() {
    val movie = SampleData.featuredMovie
    Box(
        modifier = Modifier.fillMaxWidth().height(500.dp).background(
            Brush.verticalGradient(colors = listOf(
                NetflixDarkRed.copy(alpha = 0.4f), NetflixMediumGray.copy(alpha = 0.3f), NetflixBlack
            ))
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(top = 120.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(Modifier.weight(1f))
            Text(movie.title.uppercase(),
                style = MaterialTheme.typography.displayLarge.copy(
                    fontSize = 36.sp, fontWeight = FontWeight.Black, letterSpacing = 4.sp, color = NetflixWhite),
                textAlign = TextAlign.Center, modifier = Modifier.padding(horizontal = 32.dp))
            Spacer(Modifier.height(8.dp))
            Text(movie.genre.joinToString(" - "),
                style = MaterialTheme.typography.bodyMedium.copy(color = NetflixTextGray, letterSpacing = 1.sp))
            Spacer(Modifier.height(20.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier.padding(horizontal = 24.dp)) {
                Button(onClick = {}, colors = ButtonDefaults.buttonColors(
                    containerColor = NetflixWhite, contentColor = NetflixBlack),
                    shape = MaterialTheme.shapes.small,
                    modifier = Modifier.weight(1f).height(42.dp)) {
                    Icon(Icons.Default.PlayArrow, null, modifier = Modifier.size(24.dp))
                    Spacer(Modifier.width(4.dp))
                    Text("Oynat", style = MaterialTheme.typography.labelLarge.copy(color = NetflixBlack, fontWeight = FontWeight.Bold))
                }
                Button(onClick = {}, colors = ButtonDefaults.buttonColors(
                    containerColor = NetflixLightGray.copy(alpha = 0.7f), contentColor = NetflixWhite),
                    shape = MaterialTheme.shapes.small,
                    modifier = Modifier.weight(1f).height(42.dp)) {
                    Icon(Icons.Default.Add, null, modifier = Modifier.size(20.dp))
                    Spacer(Modifier.width(4.dp))
                    Text("Listem", style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold))
                }
            }
            Spacer(Modifier.height(24.dp))
        }
    }
}
