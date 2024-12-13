package br.com.rodrigo.nearby.ui.screen.home

import br.com.rodrigo.nearby.data.model.Category
import br.com.rodrigo.nearby.data.model.Market
import com.google.android.gms.maps.model.LatLng

data class HomeUiState(
    val markets: List<Market>? = null,
    val categories: List<Category>? = null,
    val marketLocations: List<LatLng>? = null
)