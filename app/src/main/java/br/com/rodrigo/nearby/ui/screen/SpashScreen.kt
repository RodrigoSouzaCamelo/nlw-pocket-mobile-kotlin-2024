package br.com.rodrigo.nearby.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.rodrigo.nearby.R
import br.com.rodrigo.nearby.ui.theme.GreenLight
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onNavigateToWelcome: () -> Unit,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(key1 = Unit) {
        delay(3_000)
        onNavigateToWelcome()
    }

    Box(
        modifier = modifier
            .background(GreenLight)
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_logo_logo_logo_text),
            contentDescription = "Imagem logo",
            modifier = Modifier.align(Alignment.Center)
        )

        Image(
            painter = painterResource(id = R.drawable.bg_splash_screen),
            contentDescription = "Imagem background",
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    SplashScreen(onNavigateToWelcome = {})
}