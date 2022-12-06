package com.codetron.animeku.ui.screen.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun SearchScreen(
    modifier:Modifier=Modifier,
    navController: NavController,
) {
    Column(modifier = modifier
        .fillMaxSize()) {
        Text(text = "Search screen")
    }
}