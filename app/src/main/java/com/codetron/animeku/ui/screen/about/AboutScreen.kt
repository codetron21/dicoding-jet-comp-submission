package com.codetron.animeku.ui.screen.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.codetron.animeku.R
import com.codetron.animeku.data.model.Profile

@Composable
fun AboutScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
    profile: Profile = Profile(
        nameRes = R.string.user_name,
        emailRes = R.string.user_email,
        photoRes = R.drawable.img_ada_photo,
    ),
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

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = stringResource(id = R.string.about),
                style = MaterialTheme.typography.h5.copy(
                    color = Color.White,
                    fontSize = 24.sp,
                ),
            )

        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(
                    color = Color.White,
                    shape = MaterialTheme.shapes.large
                )
        ) {

            Image(
                painter = painterResource(id = profile.photoRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier =
                Modifier
                    .size(140.dp)
                    .clip(CircleShape)
                    .border(2.dp, MaterialTheme.colors.primary, CircleShape)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = stringResource(id = profile.nameRes),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = stringResource(id = profile.emailRes),
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colors.primary,
                fontSize = 18.sp
            )
        }

    }
}