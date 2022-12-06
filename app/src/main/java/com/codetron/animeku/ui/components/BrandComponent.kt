package com.codetron.animeku.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.codetron.animeku.R
import com.codetron.animeku.ui.theme.AnimeKuTheme
import com.codetron.animeku.ui.theme.Blue
import com.codetron.animeku.ui.theme.White


@Composable
fun FullLogo(
    modifier: Modifier = Modifier,
    color: Color = White,
    fontSize: TextUnit = MaterialTheme.typography.h5.fontSize
) {
    Text(
        text = stringResource(id = R.string.app_name),
        style = MaterialTheme.typography.h5.copy(
            color = color,
            fontSize = fontSize,
        ),
        modifier = modifier
    )
}

@Composable
fun ShortLogo(
    modifier: Modifier = Modifier,
    color: Color = White,
    fontSize: TextUnit = MaterialTheme.typography.h5.fontSize
) {
    Text(
        text = stringResource(id = R.string.app_name).take(2),
        style = MaterialTheme.typography.h5.copy(
            color = color,
            fontSize = fontSize,
        ),
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Blue)
            .padding(8.dp)
    )
}

@Preview(showBackground = true, backgroundColor = 1)
@Composable
fun FullLogo_Preview() {
    AnimeKuTheme {
        FullLogo()
    }
}

@Preview(showBackground = true, backgroundColor = 1)
@Composable
fun ShortLogo_Preview() {
    AnimeKuTheme {
        ShortLogo()
    }
}