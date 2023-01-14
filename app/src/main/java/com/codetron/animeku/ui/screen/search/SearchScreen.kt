package com.codetron.animeku.ui.screen.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.codetron.animeku.R
import com.codetron.animeku.router.ScreenPath
import com.codetron.animeku.ui.UiState
import com.codetron.animeku.ui.components.AnimeMovieItem
import com.codetron.animeku.ui.components.SearchInput
import com.codetron.animeku.ui.theme.Blue
import com.codetron.animeku.viewmodel.search.SearchViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
) {
    val vm = koinViewModel<SearchViewModel>()
    val movieState by vm.movies.collectAsState()
    val query by vm.query.collectAsState()
    val focusRequester = FocusRequester()

    LaunchedEffect(true) {
        focusRequester.requestFocus()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = null,
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colors.primary)
                    .clickable { navController.popBackStack() }
                    .padding(8.dp))

            Spacer(modifier = Modifier.width(8.dp))

            SearchInput(
                value = query,
                onValueChange = {
                    vm.setQuery(it)
                },
                leadingIcon = null,
                focusRequester = focusRequester,
                keyboardActions = KeyboardActions(onSearch = {
                    vm.searchMovies()
                })
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
                    if (data.isEmpty()) {
                        Text(
                            text = stringResource(id = R.string.no_movies),
                            style = MaterialTheme.typography.h5.copy(
                                fontSize = 18.sp,
                                color = Blue
                            ),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                    LazyColumn {
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