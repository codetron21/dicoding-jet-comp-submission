package com.codetron.animeku.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.codetron.animeku.R
import com.codetron.animeku.router.ScreenPath
import com.codetron.animeku.ui.UiState
import com.codetron.animeku.ui.components.AnimeMovieItem
import com.codetron.animeku.ui.components.SearchInput
import com.codetron.animeku.ui.components.ShortLogo
import com.codetron.animeku.ui.theme.AnimeKuTheme
import com.codetron.animeku.ui.theme.Blue
import com.codetron.animeku.viewmodel.home.HomeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
) {

    val vm = koinViewModel<HomeViewModel>()
    val listState = rememberLazyListState()
    val movieState by vm.movies.collectAsState()

    LaunchedEffect(true) {
        vm.getTopMovies()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(Blue)
                .padding(horizontal = 8.dp, vertical = 8.dp)
        ) {
            ShortLogo()

            Spacer(modifier = modifier.width(8.dp))

            SearchInput(
                value = "",
                onValueChange = {},
                enabled = false,
                onClick = {
                    navController.navigate(ScreenPath.search)
                },
                modifier = Modifier.weight(1F)
            )

            Spacer(modifier = modifier.width(8.dp))

            Image(
                painter = painterResource(id = R.drawable.ic_account),
                colorFilter = ColorFilter.tint(Color.White),
                contentDescription = stringResource(id = R.string.about_screen),
                modifier = Modifier
                    .clickable {
                        navController.navigate(ScreenPath.about)
                    }
            )

        }

        Box(modifier = Modifier.fillMaxSize()) {
            when (movieState) {
                is UiState.Error -> {
                    Text(
                        text = (movieState as UiState.Error).exception.message
                            ?: stringResource(id = R.string.general_error),
                        style = MaterialTheme.typography.h5.copy(
                            fontSize = 18.sp,
                            color = Blue
                        ),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                UiState.Loading -> CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                is UiState.Success -> {
                    val data = (movieState as UiState.Success).data
                    LazyColumn(state = listState) {
                        items(data, key = { it.id }) { anime ->
                            AnimeMovieItem(model = anime, modifier = Modifier.clickable {
                                navController.navigate(
                                    ScreenPath.detail + ScreenPath.addBackSlash(
                                        anime.id.toString()
                                    )
                                )
                            })
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreen_Preview() {
    AnimeKuTheme {
        HomeScreen()
    }
}