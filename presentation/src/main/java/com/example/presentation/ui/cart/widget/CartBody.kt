package com.example.presentation.ui.cart.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.domain.model.CartItem
import com.example.domain.model.Category
import com.example.domain.model.Product
import com.example.presentation.base.read
import com.example.presentation.ui.cart.mvi.CartScreenState
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
fun CartBody(
    stateReader: () -> CartScreenState,
    onDeleteClick: () -> Unit,
    onAddClick: () -> Unit,
    onRemoveClick: () -> Unit,
    onClickToProceedToCheckOut: () -> Unit,
    modifier: Modifier = Modifier
) {
    val cartItems = stateReader.read { cartItems }

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F)
                .padding(horizontal = 20.dp, vertical = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(cartItems) { cartItem ->
                CartItemCard(
                    productName = cartItem.product.name,
                    productPrice = cartItem.product.price,
                    images = cartItem.product.images,
                    quantity = cartItem.quantity,
                    stockCount = cartItem.product.stockCount,
                    onDelete = onDeleteClick,
                    onAdd = onAddClick,
                    onRemove = onRemoveClick,
                )
            }
        }
        CartSummary(
            stateReader = stateReader,
            onClickProceedToCheckout = onClickToProceedToCheckOut
        )
    }
}

@Preview
@Composable
private fun CartBodyPreview() {
    val product1 = Product(
        productID = "shoes_1",
        name = "Nike Air Max 270",
        description = "The Nike Air Max 270 was designed to keep you moving from morning to night without sacrificing style. A breathable mesh upper wraps your foot in lightweight support, while the responsive Air cushioning absorbs every step and gives energy back to your stride. Whether you're commuting, running errands, or just spending long hours on your feet, these shoes deliver the kind of all-day comfort that makes you forget you're even wearing them.",
        price = 129.00,
        images = listOf("#6366F1", "#E85A4F", "#32D583"),
        category = Category(categoryID = "shoes", displayName = "Shoes", itemCount = 128),
        stockCount = 10,
        rating = 4.8,
        reviewCount = 128
    )

    val product2 = Product(
        productID = "shoes_2",
        name = "Retro Runner",
        description = "The Retro Runner takes everything you loved about classic running shoes and rebuilds it for today's streets. A vintage-inspired sole unit has been updated with modern cushioning technology so you get the look of the past without sacrificing the comfort of the present. The clean silhouette pairs easily with casual outfits, making it a shoe you'll find yourself reaching for day after day.",
        price = 99.00,
        images = listOf("#E85A4F", "#6366F1", "#32D583"),
        category = Category(categoryID = "shoes", displayName = "Shoes", itemCount = 128),
        stockCount = 5,
        rating = 4.5,
        reviewCount = 86
    )

    val product3 = Product(
        productID = "shoes_3",
        name = "Sport Sandal",
        description = "The Sport Sandal was built for people who refuse to slow down, even in warm weather. Fully adjustable straps let you dial in a secure fit whether you're hiking a trail or walking through town, and the contoured footbed supports your arch through long days on your feet. A grippy rubber outsole bites into both wet and dry surfaces, so you can move with confidence no matter where the day takes you.",
        price = 74.00,
        images = listOf("#32D583", "#6366F1", "#E85A4F"),
        category = Category(categoryID = "shoes", displayName = "Shoes", itemCount = 128),
        stockCount = 8,
        rating = 4.3,
        reviewCount = 54
    )

    val cartItems = listOf(
        CartItem(product = product1, quantity = 1),
        CartItem(product = product2, quantity = 2),
        CartItem(product = product3, quantity = 3)
    )

    val cartScreenState = CartScreenState(cartItems = cartItems)

    ShoppingAppTheme {
        CartBody(
            stateReader = { cartScreenState },
            onDeleteClick = {},
            onAddClick = {},
            onRemoveClick = {},
            onClickToProceedToCheckOut = {}
        )
    }
}