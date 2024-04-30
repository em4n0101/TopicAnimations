package com.alexbar.demoanimations.screens.onboarding.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.alexbar.demoanimations.R
import com.alexbar.demoanimations.model.OnboardingData
import com.alexbar.demoanimations.ui.theme.Dimens.dimen_16_dp
import com.alexbar.demoanimations.utils.Constants

@Composable
fun OnboardingWidget(
    onboardingData: OnboardingData
) {
    Box(modifier = Modifier
        .fillMaxSize()
    ) {
        Column {
            Image(
                painter = painterResource(id = onboardingData.image),
                contentDescription = null
            )
            Text(
                text = onboardingData.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimen_16_dp),
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Black)
            )
            Text(
                text = onboardingData.message,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimen_16_dp),
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = 18.sp)
            )
        }
    }
}

@Preview
@Composable
fun ScreenOnboardingPreview() {
    OnboardingWidget(
        OnboardingData(
            title = Constants.onboarding_title_1,
            message = Constants.onboarding_message_1,
            image = R.drawable.image_three
        )
    )
}