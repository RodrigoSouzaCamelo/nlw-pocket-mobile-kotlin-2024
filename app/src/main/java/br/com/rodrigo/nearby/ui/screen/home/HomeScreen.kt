package br.com.rodrigo.nearby.ui.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rodrigo.nearby.data.model.Market
import br.com.rodrigo.nearby.ui.component.category.NearbyCategoryFilterChipList
import br.com.rodrigo.nearby.ui.component.home.NearbyGoogleMap
import br.com.rodrigo.nearby.ui.component.market.NearbyMarketCardList
import br.com.rodrigo.nearby.ui.theme.Gray100

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onEvent: (HomeUiEvent) -> Unit,
    modifier: Modifier = Modifier,
    onNavigateToMarketDetails: (Market) -> Unit
) {
    val bottomSheetState = rememberBottomSheetScaffoldState()

    val configuration = LocalConfiguration.current

    LaunchedEffect(true) {
        onEvent(HomeUiEvent.OnFetchCategories)
    }

    BottomSheetScaffold(
        modifier = modifier,
        scaffoldState = bottomSheetState,
        sheetContainerColor = Gray100,
        sheetPeekHeight = configuration.screenHeightDp.dp * 0.5f,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetContent = {
            if (!uiState.markets.isNullOrEmpty()) {
                NearbyMarketCardList(
                    markets = uiState.markets,
                    onClick = { selectedMarket -> onNavigateToMarketDetails(selectedMarket) },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                )
            }
        }
    ) { paddingValues ->


        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    bottom = paddingValues
                        .calculateBottomPadding()
                        .minus(8.dp)
                )
        ) {
            NearbyGoogleMap(uiState)

            if (!uiState.categories.isNullOrEmpty()) {
                NearbyCategoryFilterChipList(
                    categories = uiState.categories,
                    onSelectedCategoryChanged = { selectedCategory ->
                        onEvent(HomeUiEvent.OnFetchMarkets(selectedCategory.id))
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp)
                        .align(Alignment.TopStart)
                )
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(
        onEvent = {},
        uiState = HomeUiState(),
        onNavigateToMarketDetails = {}
    )
}