package com.example.netflixtheme.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.netflixtheme.model.Movie
import com.example.netflixtheme.ui.theme.NetflixWhite

@Composable
fun MovieRow(title: String, movies: List<Movie>, modifier: Modifier = Modifier, onMovieClick: (Movie) -> Unit = {}) {
    Column(modifier = modifier) {
        Text(title, style = MaterialTheme.typography.headlineMedium.copy(
            fontWeight = FontWeight.Bold, color = NetflixWhite),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
        LazyRow(contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(movies) { movie ->
                MovieCard(movie = movie, onClick = { onMovieClick(movie) })
            }
        }
    }
}

@Composable
fun TopTenRow(movies: List<Movie>, modifier: Modifier = Modifier, onMovieClick: (Movie) -> Unit = {}) {
    Column(modifier = modifier) {
        Text("Türkiye'de Bugün En Çok İzlenen 10",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold, color = NetflixWhite),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
        LazyRow(contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            items(movies.filter { it.isTopTen }) { movie ->
                TopTenMovieCard(movie = movie, onClick = { onMovieClick(movie) })
            }
        }
    }
}

@Composable
fun ContinueWatchingRow(movies: List<Movie>, modifier: Modifier = Modifier, onMovieClick: (Movie) -> Unit = {}) {
    Column(modifier = modifier) {
        Text("Izlemeye Devam Et",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold, color = NetflixWhite),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
        LazyRow(contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(movies) { movie ->
                ContinueWatchingCard(movie = movie, progress = (0.2f..0.8f).random(), onClick = { onMovieClick(movie) })
            }
        }
    }
}
