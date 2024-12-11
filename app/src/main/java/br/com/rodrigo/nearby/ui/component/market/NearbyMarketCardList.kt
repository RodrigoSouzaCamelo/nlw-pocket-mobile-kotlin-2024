package br.com.rodrigo.nearby.ui.component.market

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rodrigo.nearby.data.model.Market
import br.com.rodrigo.nearby.data.model.mock.mockMarkets
import br.com.rodrigo.nearby.ui.theme.Typography

@Composable
fun NearbyMarketCardList(
    markets: List<Market>,
    onClick: (Market) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        item {
            Text(
                text = "Explore locais perto de você",
                style = Typography.bodyLarge
            )
        }

        items(items = markets, key = { it.id }) { market ->
            NearbyMarketCard(
                market = market, 
                onClick = { onClick(market) }
            )
        }
    }
}

@Preview
@Composable
private fun NearbyMarketCardListPreview() {
    NearbyMarketCardList(
        markets = mockMarkets,
        onClick = {}
    )
}