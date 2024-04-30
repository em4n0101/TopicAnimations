package com.alexbar.demoanimations.screens.onboarding

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.alexbar.demoanimations.R
import com.alexbar.demoanimations.model.OnboardingData
import com.alexbar.demoanimations.screens.onboarding.widgets.OnboardingWidget
import com.alexbar.demoanimations.screens.onboarding.widgets.ProgressBarOnboarding
import com.alexbar.demoanimations.ui.theme.Dimens.dimen_16_dp
import com.alexbar.demoanimations.ui.theme.Dimens.dimen_190_dp
import com.alexbar.demoanimations.ui.theme.Dimens.dimen_350_dp
import com.alexbar.demoanimations.ui.theme.Dimens.dimen_70_dp
import com.alexbar.demoanimations.ui.theme.Dimens.dimen_8_dp
import com.alexbar.demoanimations.utils.Constants
import com.alexbar.demoanimations.utils.Constants.onboarding_button_skip


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun OnboardingScreen(
    onCompleteOnboardingPressed: () -> Unit
) {
    var page by remember { mutableIntStateOf(0) }
    var isFinished by remember { mutableStateOf(false) }
    val progressBarWidth by animateDpAsState(targetValue = when (page) {
        0 -> dimen_70_dp
        1 -> dimen_190_dp
        else -> dimen_350_dp
    }, label = "")


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(dimen_16_dp)
    ) {
        ProgressBarOnboarding(progressBarWidth)

        AnimatedVisibility(
            visible = !isFinished,
            enter = fadeIn(),
            exit = fadeOut(animationSpec = tween(durationMillis = 500))
        ) {
            TextButton(onClick = {
                onCompleteOnboardingPressed()
            }) {
                Text(
                    text = onboarding_button_skip,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End
                )
            }
        }

        AnimatedContent(
            targetState = page,
            modifier = Modifier.fillMaxWidth().weight(1f),
            label = "",
            transitionSpec = {
                slideInHorizontally (initialOffsetX = { it }) with slideOutHorizontally(targetOffsetX = { -it })
            }
        ) {
            when (it) {
                0 -> OnboardingWidget(OnboardingData(title = Constants.onboarding_title_1, message = Constants.onboarding_message_1, image = R.drawable.image_one))
                1 -> OnboardingWidget(OnboardingData(title = Constants.onboarding_title_2, message = Constants.onboarding_message_2, image = R.drawable.image_two))
                2 -> OnboardingWidget(OnboardingData(title = Constants.onboarding_title_3, message = Constants.onboarding_message_3, image = R.drawable.image_three))
            }
        }
        Row(modifier = Modifier.fillMaxWidth().padding(dimen_8_dp), Arrangement.Absolute.SpaceBetween) {
            Button(
                onClick = {
                    page -= 1
                    if (page < 2) isFinished = false
                },
                enabled = page != 0
            ) {
                Text(text = Constants.onboarding_button_previous)
            }
            Button(
                onClick = {
                    if (page == 2) onCompleteOnboardingPressed()
                    page += 1
                    if (page == 2) isFinished = true
                }
            ) {
                Text(text = if(page != 2) Constants.onboarding_button_next else Constants.onboarding_button_finish)
            }
        }
    }
}