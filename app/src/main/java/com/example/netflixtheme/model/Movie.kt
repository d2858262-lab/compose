package com.example.netflixtheme.model

data class Movie(
    val id: Int,
    val title: String,
    val description: String,
    val year: String,
    val rating: String,
    val duration: String,
    val genre: List<String>,
    val imageUrl: String,
    val matchPercentage: Int = 0,
    val isTopTen: Boolean = false,
    val topTenRank: Int = 0,
    val isNewEpisode: Boolean = false
)

object SampleData {
    val featuredMovie = Movie(
        id = 1, title = "Stranger Things",
        description = "Kucuk bir kasabada bir cocugun kaybolmasiyla baslayan olaylar, gizli deneyler ve dogaustu gucleri ortaya cikarir.",
        year = "2024", rating = "16+", duration = "4 Sezon",
        genre = listOf("Bilim Kurgu", "Gerilim", "Drama"),
        imageUrl = "", matchPercentage = 98
    )
    val trendingMovies = listOf(
        Movie(1, "Breaking Bad", "", "2023", "18+", "2s 15dk", listOf("Drama"), "", 97, true, 1),
        Movie(2, "Dark", "", "2023", "16+", "1s 50dk", listOf("Bilim Kurgu"), "", 95, true, 2),
        Movie(3, "The Witcher", "", "2023", "18+", "2s 5dk", listOf("Fantastik"), "", 93, true, 3),
        Movie(4, "Money Heist", "", "2023", "16+", "1s 45dk", listOf("Aksiyon"), "", 91, true, 4),
        Movie(5, "Narcos", "", "2023", "18+", "1s 55dk", listOf("Suc"), "", 89, true, 5),
    )
    val continueWatching = listOf(
        Movie(6, "Wednesday", "", "2023", "13+", "50dk", listOf("Komedi"), "", isNewEpisode = true),
        Movie(7, "Squid Game", "", "2023", "18+", "1s 2dk", listOf("Gerilim"), ""),
        Movie(8, "The Crown", "", "2023", "16+", "58dk", listOf("Drama"), ""),
        Movie(9, "Peaky Blinders", "", "2023", "18+", "1s 10dk", listOf("Drama"), ""),
    )
    val popularMovies = listOf(
        Movie(10, "Inception", "", "2010", "13+", "2s 28dk", listOf("Bilim Kurgu"), "", 96),
        Movie(11, "Interstellar", "", "2014", "13+", "2s 49dk", listOf("Bilim Kurgu"), "", 98),
        Movie(12, "The Matrix", "", "1999", "16+", "2s 16dk", listOf("Aksiyon"), "", 94),
        Movie(13, "Fight Club", "", "1999", "18+", "2s 19dk", listOf("Drama"), "", 92),
        Movie(14, "Pulp Fiction", "", "1994", "18+", "2s 34dk", listOf("Suc"), "", 90),
    )
}
