package com.codetron.animeku.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.codetron.animeku.R
import com.codetron.animeku.data.model.MovieItem
import com.codetron.animeku.ui.theme.AnimeKuTheme
import com.codetron.animeku.ui.theme.Blue
import com.codetron.animeku.ui.theme.White

@Composable
fun AnimeMovieItem(modifier: Modifier = Modifier, model: MovieItem) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(White)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        AsyncImage(
            model = model.image, contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(80.dp)
                .height(120.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(Blue)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            model.title,
            style = MaterialTheme.typography.h5.copy(
                color = Blue,
                fontSize = 16.sp,
            ),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .fillMaxWidth()
        )

        Text(
            text = stringResource(
                id = R.string.format_item,
                model.type,
                model.episodes.toString(),
                model.score.toString(),
                model.members.toString(),
            ), modifier = Modifier
                .align(Alignment.CenterVertically)
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun AnimeMovieItem_Preview() {
    AnimeKuTheme {
        AnimeMovieItem(model = MovieItem(id = 1, "Title", "type", 10, 10, 10F))
    }
}