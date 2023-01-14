package com.codetron.animeku.ui.screen.detail

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.codetron.animeku.R
import com.codetron.animeku.data.model.MovieDetail
import com.codetron.animeku.extension.data
import com.codetron.animeku.helper.GeneralHelper
import com.codetron.animeku.ui.UiState
import com.codetron.animeku.ui.theme.Blue
import com.codetron.animeku.viewmodel.detail.DetailViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
    id: Int?,
) {
    val vm = koinViewModel<DetailViewModel>()
    val movieState by vm.movie.collectAsState()

    LaunchedEffect(true) {
        vm.getMovie(id)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        TopBar(navController = navController, title = movieState.data()?.title.orEmpty())

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
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
                    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                        val data = (movieState as UiState.Success).data
                        HeaderSection(movie = data)

                        Spacer(modifier = Modifier.height(16.dp))

                        BodySection(movie = data, modifier = Modifier.background(Color.White))
                    }
                }
            }
        }
    }
}

@Composable
private fun HeaderSection(modifier: Modifier = Modifier, movie: MovieDetail) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {

        AsyncImage(
            model = movie.image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(140.dp)
                .height(200.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(Blue)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier.weight(1F)) {
            Text(
                text = movie.title,
                style = MaterialTheme.typography.h5.copy(
                    color = Color.Black,
                    fontSize = 20.sp,
                ),
            )

            LabelItem(
                label = stringResource(id = R.string.label_type),
                content = movie.type,
            )

            LabelItem(
                label = stringResource(id = R.string.label_episodes),
                content = movie.episodes.toString(),
            )

            LabelItem(
                label = stringResource(id = R.string.label_duration),
                content = movie.duration,
            )

            LabelItem(
                label = stringResource(id = R.string.label_rating),
                content = movie.rating,
            )

            LabelItem(
                label = stringResource(id = R.string.label_rank),
                content = movie.rank.toString(),
            )
        }
    }
}

@Composable
private fun BodySection(modifier: Modifier = Modifier, movie: MovieDetail) {
    Column(modifier = modifier.fillMaxSize()) {

        Text(
            text = stringResource(id = R.string.info),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Start
        )

        LabelItem(
            label = stringResource(id = R.string.label_status),
            content = movie.status,
        )

        val dates = movie.aired.split(",")
        val startDate = GeneralHelper.formatDateStr(dates[0])
        val endDate = GeneralHelper.formatDateStr(dates[1])
        LabelItem(
            label = stringResource(id = R.string.label_aired),
            content = stringResource(
                id = R.string.format_aired,
                startDate.orEmpty(),
                endDate.orEmpty()
            ),
        )

        LabelItem(
            label = stringResource(id = R.string.label_members),
            content = movie.members.toString(),
        )

        LabelItem(
            label = stringResource(id = R.string.label_score),
            content = movie.score.toString(),
        )

        LabelItem(
            label = stringResource(id = R.string.label_scored_by),
            content = movie.scoredBy.toString(),
        )


        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(id = R.string.description),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Start
        )

        Text(
            text = movie.synopsis,
            fontSize = 16.sp,
            color = Color.DarkGray,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
private fun LabelItem(modifier: Modifier = Modifier, label: String, content: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Text(
            text = label, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.DarkGray,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.weight(1F))
        Text(text = content, fontSize = 14.sp, color = Color.Gray, textAlign = TextAlign.End)
    }
}

@Composable
private fun TopBar(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
    title: String,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.primary)
            .height(56.dp)
            .padding(horizontal = 16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_back),
            colorFilter = ColorFilter.tint(Color.White),
            contentDescription = null,
            modifier = Modifier.clickable {
                navController.popBackStack()
            }
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = title,
            style = MaterialTheme.typography.h5.copy(
                color = Color.White,
                fontSize = 24.sp,
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}