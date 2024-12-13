package br.com.rodrigo.nearby.core.network

import br.com.rodrigo.nearby.core.network.KtorHttpClient.httpClientAndroid
import br.com.rodrigo.nearby.data.model.Category
import br.com.rodrigo.nearby.data.model.Coupon
import br.com.rodrigo.nearby.data.model.Market
import br.com.rodrigo.nearby.data.model.MarketDetails
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.patch

object NearbyRemoteDataSource {

    private const val LOCAL_HOST_EMULATOR_BASE_URL = "http://192.168.1.15:3333"

    private const val BASE_URL = LOCAL_HOST_EMULATOR_BASE_URL

    suspend fun getCategories(): Result<List<Category>> = try {
        val categories = httpClientAndroid.get("${BASE_URL}/categories")

        Result.success(categories.body())
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun getMarkets(categoryId: String): Result<List<Market>> = try {
        val markets = httpClientAndroid.get("${BASE_URL}/markets/category/$categoryId")

        Result.success(markets.body())
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun getMarketDetails(marketId: String): Result<MarketDetails> = try {
        val markets = httpClientAndroid.get("${BASE_URL}/markets/$marketId")

        Result.success(markets.body())
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun patchCoupon(marketId: String): Result<Coupon> = try {
        val markets = httpClientAndroid.patch("${BASE_URL}/coupons/$marketId")

        Result.success(markets.body())
    } catch (e: Exception) {
        Result.failure(e)
    }
}