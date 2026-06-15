package com.example.presentation.ui.productDetail.widget

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import com.example.presentation.ui.theme.ShoppingAppTheme

@Composable
fun ProductImagePager(
    productImages: List<String>,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState(pageCount = { productImages.size })

    val animatedShadowColor by animateColorAsState(
        targetValue = Color(productImages[pagerState.currentPage]
            .toColorInt()).copy(alpha = 0.20F),
        animationSpec = tween(400),
        label = "shadowColor"
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(6F / 5F)
            .dropShadow(
                shape = RoundedCornerShape(20.dp),
                shadow = Shadow(
                    radius = 24.dp,
                    spread = 2.dp,
                    color = animatedShadowColor,
                    offset = DpOffset(0.dp, 8.dp)
                )
            )
            .clip(RoundedCornerShape(20.dp))
    ) {
        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            state = pagerState,
            flingBehavior = PagerDefaults.flingBehavior(
                state = pagerState,
                snapAnimationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
        ) { page ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(productImages[page].toColorInt()))
            )
        }
        // the dots indicator
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(times = productImages.size) { index ->
                val selected = pagerState.currentPage == index

                val dotWidth by animateDpAsState(
                    targetValue = if (selected) 20.dp else 8.dp,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessMedium
                    ),
                    label = "dotWidth"
                )

                val dotShape = if (selected) RoundedCornerShape(4.dp)
                else CircleShape

                val dotBackground = if (selected) Color(0xFFFFFFFF)
                else Color(0xFFFFFFFF).copy(alpha = 0.40F)

                Box(
                    modifier = Modifier
                        .height(8.dp)
                        .width(dotWidth)
                        .clip(dotShape)
                        .background(dotBackground)
                )
            }
        }
    }
}

@Preview
@Composable
private fun Product1ImagePagerPreview() {
    ShoppingAppTheme {
        ProductImagePager(
            productImages = listOf("#6366F1", "#E85A4F", "#32D583")
        )
    }
}

@Preview
@Composable
private fun Product2ImagePagerPreview() {
    ShoppingAppTheme {
        ProductImagePager(
            productImages = listOf("#E85A4F", "#6366F1", "#32D583")
        )
    }
}