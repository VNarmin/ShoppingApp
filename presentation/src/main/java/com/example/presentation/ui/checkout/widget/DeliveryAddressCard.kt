package com.example.presentation.ui.checkout.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.model.CartItem
import com.example.domain.model.Category
import com.example.domain.model.Order
import com.example.domain.model.Product
import com.example.presentation.base.read
import com.example.presentation.ui.checkout.mvi.CheckoutScreenState
import com.example.presentation.ui.theme.DMSansFontFamily
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
internal fun DeliveryAddressCard(
    stateReader: () -> CheckoutScreenState,
    modifier : Modifier = Modifier
) {
    val username = stateReader.read { username }

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Delivery Address",
            style = TextStyle(
                color = Color(0xFFFAFAF9),
                fontFamily = DMSansFontFamily,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Start
            )
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFF16161A))
                .border(
                    color = Color(0xFF2A2A2E),
                    shape = RoundedCornerShape(16.dp),
                    width = 1.dp
                )
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFF1A1A1E)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = Color(0xFF6366F1)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1F),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = username,
                    style = TextStyle(
                        color = Color(0xFFFAFAF9),
                        fontFamily = DMSansFontFamily,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Start
                    )
                )
                Text(
                    text = "12 Nizami St · Baku 1000",
                    style = TextStyle(
                        color = Color(0xFF6B6B70),
                        fontFamily = DMSansFontFamily,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Start
                    )
                )
            }
            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = Color(0xFF6B6B70)
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun DeliveryAddressPreview() {
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

    val order = Order(
        orderID = "56875687",
        cartItems = cartItems,
        shippingCost = 5.0
    )

    val checkoutScreenState = CheckoutScreenState(order = order)

    ShoppingAppTheme {
        DeliveryAddressCard(stateReader = { checkoutScreenState} )
    }
}