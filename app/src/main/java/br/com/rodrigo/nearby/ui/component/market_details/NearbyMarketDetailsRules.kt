package br.com.rodrigo.nearby.ui.component.market_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.rodrigo.nearby.data.model.Rule
import br.com.rodrigo.nearby.data.model.mock.mockRules
import br.com.rodrigo.nearby.ui.theme.Gray400
import br.com.rodrigo.nearby.ui.theme.Gray500
import br.com.rodrigo.nearby.ui.theme.Typography

@Composable
fun NearbyMarketDetailsRules(
    rules: List<Rule>,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        Text(
            text = "Regulamento",
            style = Typography.headlineSmall,
            color = Gray400
        )

        Text(
            text = rules.joinToString(separator = "\n", transform = { "• ${it.description}" }),
            style = Typography.labelMedium,
            lineHeight = 24.sp,
            color = Gray500,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Preview
@Composable
private fun NearbyMarketDetailsRulesPreview() {
    NearbyMarketDetailsRules(
        rules = mockRules,
        modifier = Modifier.fillMaxWidth()
    )
}