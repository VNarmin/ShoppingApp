package com.example.presentation.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.presentation.ui.theme.DMSansFontFamily
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
fun ProductCard(
    productName: String,
    productPrice: Double,
    images: List<String>,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFF16161A))
            .border(
                color = Color(0xFF2A2A2E),
                shape = RoundedCornerShape(16.dp),
                width = 1.dp
            )
            .clickable(onClick = onClick)
    ) {
        AsyncImage(
            model = images,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
        )
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.padding(12.dp)
        ) {
            Text(
                text = productName,
                style = TextStyle(
                    color = Color(0xFFFAFAF9),
                    fontFamily = DMSansFontFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Start
                )
            )
            Text(
                text = "$${"%.2f".format(productPrice)}",
                style = TextStyle(
                    color = Color(0xFF32D583),
                    fontFamily = DMSansFontFamily,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start
                )
            )
        }
    }
}

@Preview
@Composable
private fun ProductCardPreview() {
    ShoppingAppTheme {
        ProductCard(
            productName = "Nike Air Max",
            productPrice = 129.00,
            images = listOf(),
            onClick = {}
        )
    }
}