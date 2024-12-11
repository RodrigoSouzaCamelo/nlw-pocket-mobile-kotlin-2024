package br.com.rodrigo.nearby.ui.component.market_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rodrigo.nearby.R
import br.com.rodrigo.nearby.ui.theme.Gray400
import br.com.rodrigo.nearby.ui.theme.GreenBase
import br.com.rodrigo.nearby.ui.theme.GreenExtraLight
import br.com.rodrigo.nearby.ui.theme.Typography

@Composable
fun NearbyMarketDetailsCoupons(
    coupons: List<String>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Utilize esse cupom",
            style = Typography.headlineSmall,
            color = Gray400
        )

        coupons.forEach { coupon ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(GreenExtraLight)
                    .padding(8.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_ticket),
                    tint = GreenBase,
                    contentDescription = "Ícone de cupons",
                    modifier = Modifier.size(24.dp)
                )

                Text(
                    text = coupon,
                    style = Typography.labelMedium
                )
            }
        }
    }
}

@Preview
@Composable
private fun NearbyMarketDetailsCouponsPreview() {
    NearbyMarketDetailsCoupons(
        coupons = listOf("FM4345T5", "FM4345T6"),
        modifier = Modifier.fillMaxWidth()
    )
}