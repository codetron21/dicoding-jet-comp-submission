package com.codetron.animeku.ui.screen.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.codetron.animeku.R

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
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

            Spacer(modifier = modifier.width(16.dp))

            Text(
                text = stringResource(id = R.string.favorite_movie),
                style = MaterialTheme.typography.h5.copy(
                    color = Color.White,
                    fontSize = 24.sp,
                ),
            )

        }
    }
}