package br.com.rodrigo.nearby.ui.component.category

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rodrigo.nearby.data.model.Category
import br.com.rodrigo.nearby.ui.theme.Gray300
import br.com.rodrigo.nearby.ui.theme.Gray400
import br.com.rodrigo.nearby.ui.theme.GreenBase
import br.com.rodrigo.nearby.ui.theme.Typography

@Composable
fun NearbyCategoryFilterChip(
    isSelected: Boolean,
    onClick: (isSelected: Boolean) -> Unit,
    category: Category,
    modifier: Modifier = Modifier
) {
    FilterChip(
        modifier = modifier
            .padding(2.dp)
            .heightIn(min = 36.dp),
        selected = isSelected,
        onClick = { onClick(!isSelected) },
        elevation = FilterChipDefaults.filterChipElevation(
            elevation = 8.dp
        ),
        border = FilterChipDefaults.filterChipBorder(
            enabled = false,
            selected = isSelected,
            disabledBorderColor = Gray300,
            borderWidth = 1.dp,
            selectedBorderWidth = 0.dp,
            selectedBorderColor = Color.Transparent
        ),
        colors = FilterChipDefaults.filterChipColors(
            containerColor = Color.White,
            selectedContainerColor = GreenBase
        ),
        leadingIcon = {
            category.icon?.let {
                Icon(
                    painter = painterResource(id = it),
                    tint = if(isSelected) Color.White else Gray400,
                    contentDescription = "Ícone de filtro de categoria",
                    modifier = Modifier.size(16.dp)
                )
            }
        },
        label = {
            Text(
                text = category.name,
                style = Typography.bodyMedium,
                color = if(isSelected) Color.White else Gray400
            )
        }
    )
}

@Preview
@Composable
private fun NearbyCategoryFilterChipPreview() {
    NearbyCategoryFilterChip(
        onClick = {},
        isSelected = true,
        category = Category(id = "", name = "Alimentação")
    )
}

@Preview
@Composable
private fun NearbyCategoryFilterChipNotSelectedPreview() {
    NearbyCategoryFilterChip(
        onClick = {},
        isSelected = false,
        category = Category(id = "", name = "Alimentação")
    )
}