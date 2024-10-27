package com.example.trisnohadi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.trisnohadi.ui.theme.TrisnoHadiTheme

// Data class Artwork (jika belum ada)
data class Artwork(val imageResourceId: Int, val title: String,val year: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrisnoHadiTheme {
                TrisnoHadiApp()
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrisnoHadiApp() {
    val artworks = listOf(
        Artwork(R.drawable.t1, "Yeop Jireugi","2024"),
        Artwork(R.drawable.t2, "Arae Jireugi","2024"),
        Artwork(R.drawable.t3, "Chi Jireugi","2024"),
        Artwork(R.drawable.t4, "Pyojeok Jireugi","2024"),
        Artwork(R.drawable.t5, "Dollyeo Jireugi","2024"),
        Artwork(R.drawable.t6, "Digeutja Jireugi","2024")

        // Add more artworks here
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("GERAKAN PUKULAN TAEKWONDO", color = Color.White)
                },
                colors = topAppBarColors(
                    containerColor = Color(0xFF0000FF) // BLUE COLOR
                )
            )
        },
        bottomBar = {
            // Footer
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .padding(8.dp)
            ) {
                Text(
                    text = "Copyright @TrisnoHadi",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // 2 kolom
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF0F0F0)) // Light gray background
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(artworks) { artwork ->
                ArtworkItem(artwork)
            }
        }
    }
}

@Composable
fun ArtworkItem(artwork: Artwork) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = artwork.imageResourceId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f), // Menjaga rasio aspek gambar
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = artwork.title,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        // Menampilkan harga
        Text(
            text = artwork.year,
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center
        )
    }
}