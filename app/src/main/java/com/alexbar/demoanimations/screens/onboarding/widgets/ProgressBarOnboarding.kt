package com.alexbar.demoanimations.screens.onboarding.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.alexbar.demoanimations.ui.theme.Dimens.dimen_10_dp

@Composable
fun ProgressBarOnboarding(progressBarWidth: Dp) {
    Box(modifier = Modifier
        .clip(RoundedCornerShape(dimen_10_dp))
        .background(Color.Blue)
        .size(
            height = dimen_10_dp,
            width = progressBarWidth
        )
    )
}

@Preview
@Composable
fun ProgressBarOnboardingPreview() {
    ProgressBarOnboarding(100.dp)
}