package com.codetron.animeku.ui.screen.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.codetron.animeku.router.ScreenPath
import com.codetron.animeku.ui.components.FullLogo
import com.codetron.animeku.ui.theme.AnimeKuTheme
import com.codetron.animeku.ui.theme.White
import com.codetron.animeku.viewmodel.splash.SplashViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
) {
    val vm = koinViewModel<SplashViewModel>()

    LaunchedEffect(true) {
        vm.doDelayNavigation()

        vm.doNavigate.collect { isNavigate ->
            if (isNavigate) {
                navController.navigate(ScreenPath.home) {
                    popUpTo(ScreenPath.splash) {
                        inclusive = true
                    }
                }
            }
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)
    ) {
        FullLogo(
            modifier = Modifier.align(Alignment.Center),
            color = White,
            fontSize = 48.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreen_Preview() {
    AnimeKuTheme {
        SplashScreen()
    }
}