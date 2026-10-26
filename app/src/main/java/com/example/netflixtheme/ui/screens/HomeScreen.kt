package com.example.netflixtheme.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.netflixtheme.model.AppInfo
import com.example.netflixtheme.model.AppUtils
import com.example.netflixtheme.ui.theme.*

@Composable
fun HomeScreen(apps: List<AppInfo>, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var searchQuery by remember { mutableStateOf("") }
    var isSearching by remember { mutableStateOf(false) }

    val filteredApps = remember(searchQuery, apps) {
        if (searchQuery.isEmpty()) apps
        else apps.filter { it.name.contains(searchQuery, ignoreCase = true) }
    }

    val featuredApp = remember(apps) { apps.firstOrNull() }

    Box(modifier = modifier.fillMaxSize().background(NetflixBlack)) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            
            // Arama yapılmıyorsa Öne Çıkan Uygulama (Hero Banner)
            if (!isSearching && featuredApp != null) {
                item {
                    FeaturedAppBanner(featuredApp) {
                        AppUtils.launchApp(context, featuredApp.packageName)
                    }
                }
            }

            // Arama Modu
            if (isSearching) {
                item {
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        placeholder = { Text("Uygulama Ara...", color = NetflixTextGray) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .statusBarsPadding(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = NetflixRed,
                            unfocusedBorderColor = NetflixLightGray,
                            focusedTextColor = NetflixWhite
                        )
                    )
                }
            }

            // Uygulama Satırları
            if (isSearching) {
                item {
                    Text(
                        "Arama Sonuçları (${filteredApps.size})",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(16.dp)
                    )
                }
                item {
                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(filteredApps) { app ->
                            AppCard(app = app) { AppUtils.launchApp(context, app.packageName) }
                        }
                    }
                }
            } else {
                // Katman 1: Sık Kullanılanlar
                item {
                    AppRow(title = "🔥 Sık Kullanılan Uygulamalar", apps = apps.take(8))
                }
                
                // Katman 2: Tümü (Netflix Satırı)
                item {
                    Spacer(Modifier.height(16.dp))
                    AppRow(title = "📱 Tüm Uygulamalarım", apps = apps)
                }

                // Katman 3: Karışık Öneriler
                item {
                    Spacer(Modifier.height(16.dp))
                    AppRow(title = "⚡ Hızlı Erişim", apps = apps.shuffled())
                }
            }

            item { Spacer(Modifier.height(80.dp)) }
        }

        // Top Bar
        LauncherTopBar(
            onSearchClick = { isSearching = !isSearching }
        )
    }
}

@Composable
fun FeaturedAppBanner(app: AppInfo, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(360.dp)
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        NetflixDarkRed.copy(alpha = 0.5f),
                        NetflixBlack
                    )
                )
            )
            .clickable(onClick = onClick)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(Modifier.height(60.dp))
            app.icon?.let { icon ->
                Image(
                    painter = rememberAsyncImagePainter(icon),
                    contentDescription = app.name,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(20.dp))
                )
            }
            Spacer(Modifier.height(12.dp))
            Text(
                app.name,
                style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(16.dp))
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(containerColor = NetflixRed, contentColor = NetflixWhite),
                shape = MaterialTheme.shapes.small
            ) {
                Icon(Icons.Default.PlayArrow, null)
                Spacer(Modifier.width(8.dp))
                Text("Uygulamayı Aç", fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun AppRow(title: String, apps: List<AppInfo>) {
    val context = LocalContext.current
    Column {
        Text(
            title,
            style = MaterialTheme.typography.titleLarge.copy(color = NetflixWhite),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(apps) { app ->
                AppCard(app = app) { AppUtils.launchApp(context, app.packageName) }
            }
        }
    }
}

@Composable
fun AppCard(app: AppInfo, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(100.dp)
            .clickable(onClick = onClick)
    ) {
        Box(
            modifier = Modifier
                .size(90.dp)
                .clip(MaterialTheme.shapes.medium)
                .background(NetflixDarkGray)
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            app.icon?.let { icon ->
                Image(
                    painter = rememberAsyncImagePainter(icon),
                    contentDescription = app.name,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        Spacer(Modifier.height(6.dp))
        Text(
            app.name,
            style = MaterialTheme.typography.bodySmall.copy(color = NetflixWhite),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun LauncherTopBar(onSearchClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "B",
            style = MaterialTheme.typography.displayLarge.copy(
                fontSize = 38.sp, fontWeight = FontWeight.Black, color = NetflixRed
            )
        )
        IconButton(onClick = onSearchClick) {
            Icon(Icons.Default.Search, "Ara", tint = NetflixWhite, modifier = Modifier.size(28.dp))
        }
    }
}
