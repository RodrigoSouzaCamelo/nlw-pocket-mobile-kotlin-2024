package br.com.rodrigo.nearby.ui.screen.market_details

import br.com.rodrigo.nearby.data.model.Rule

data class MarketDetailsUiState(
    val coupon: String? = null,
    val rules: List<Rule>? = null
)
