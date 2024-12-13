package br.com.rodrigo.nearby.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rodrigo.nearby.R
import br.com.rodrigo.nearby.data.model.Market
import br.com.rodrigo.nearby.data.model.mock.mockMarkets
import br.com.rodrigo.nearby.ui.component.button.NearbyButton
import br.com.rodrigo.nearby.ui.component.market_details.NearbyMarketDetailsCoupons
import br.com.rodrigo.nearby.ui.component.market_details.NearbyMarketDetailsInfos
import br.com.rodrigo.nearby.ui.component.market_details.NearbyMarketDetailsRules
import br.com.rodrigo.nearby.ui.theme.Typography
import coil3.compose.AsyncImage

@Composable
fun MarketDetailsScreen(
    market: Market,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            //model = market.cover,
            painter = painterResource(id = R.drawable.img_burger),
            contentScale = ContentScale.Crop,
            contentDescription = "Imagem do local ",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
        )

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp))
                .fillMaxWidth()
                .fillMaxHeight(0.75f)
                .align(Alignment.BottomCenter)
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(36.dp)
            ) {
                Column {
                    Text(text = market.name, style = Typography.headlineLarge)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = market.description, style = Typography.bodyLarge)
                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(rememberScrollState())
                ) {
                    Spacer(modifier = Modifier.height(48.dp))

                    NearbyMarketDetailsInfos(market = market)

                    HorizontalDivider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 24.dp)
                    )

                    if (market.rules.isNotEmpty()) {
                        NearbyMarketDetailsRules(rules = market.rules)

                        HorizontalDivider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 24.dp)
                        )
                    }

                    NearbyMarketDetailsCoupons(coupons = listOf("ABC12345"))
                }

                NearbyButton(
                    text = "Ler QR Code",
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp)
                )
            }
        }

        NearbyButton(
            iconRes = R.drawable.ic_arrow_left,
            onClick = { onNavigateBack() },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(24.dp)
        )
    }
}

@Preview
@Composable
private fun MarketDetailsScreenPreview() {
    MarketDetailsScreen(
        market = mockMarkets.first(),
        onNavigateBack = {}
    )
}