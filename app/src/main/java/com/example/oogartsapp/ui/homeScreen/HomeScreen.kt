package com.example.oogartsapp.ui.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.oogartsapp.R
import com.example.oogartsapp.model.Article

// private val appContainer = DefaultAppContainer()
//
// val articles = runBlocking { appContainer.getArticle() }

@Preview(showBackground = true, widthDp = 300, heightDp = 600)
@Composable
fun BlogPreview() {
    // BlogCard(article = articles[0], modifier = Modifier)
    // BlogColumn(articles = articles, modifier = Modifier)
    // Welcome(modifier = Modifier)

    HomeScreen(innerPadding = PaddingValues(0.dp))
}

@Composable
fun HomeScreen(
    innerPadding: PaddingValues,
    homeScreenViewModel: HomeScreenViewModel = viewModel(factory = HomeScreenViewModel.Factory),
) {
    val homeScreenState by homeScreenViewModel.uiState.collectAsState()
    val homeApiState = homeScreenViewModel.homeApiState

    Column (
        modifier = Modifier.padding(innerPadding)
    ){
        Spacer(modifier = Modifier.height(30.dp))
        Welcome(modifier = Modifier)
        Spacer(modifier = Modifier.height(30.dp))
        when (homeApiState) {
            is HomeApiState.Error -> {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Text(text = "De data kon niet geladen worden.")
                }
            }
            is HomeApiState.Loading -> {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Text(text = "Laden...")
                }
            }
            is HomeApiState.Success -> {
                BlogColumn(modifier = Modifier, homeScreenState = homeScreenState)
            }
        }
    }
}

@Composable
fun Welcome(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .size(65.dp),
            contentScale = ContentScale.Crop,
        )
        Text(
            text = "Welkom bij\nOogcentrum Vision",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp),
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun BlogColumn(modifier: Modifier, homeScreenState: HomeScreenState) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Text(
            text = "Nieuws",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp),
        )
        Spacer(modifier = Modifier.height(6.dp))
        Divider(color = Color.LightGray, thickness = 1.dp)
        Spacer(modifier = Modifier.height(25.dp))
        LazyColumn {
            items(homeScreenState.articles) { article ->
                BlogCard(article = article, modifier = Modifier)
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun BlogCard(article: Article, modifier: Modifier) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(85.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp,
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFE2F8F8),
        ),
    ) {
        Box(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally),
        ) {
            Row(verticalAlignment = Alignment.Top) {
                val painter: Painter = rememberImagePainter(
                    data = article.imageUrl,
                    builder = {
                        transformations(CircleCropTransformation())
                    },
                )

                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier
                        .size(75.dp)
                        .clip(MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop,
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = article.title,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(4.dp),
                )
            }
        }
    }
}
