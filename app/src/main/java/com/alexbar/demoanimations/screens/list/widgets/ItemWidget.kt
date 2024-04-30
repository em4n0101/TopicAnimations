package com.alexbar.demoanimations.screens.list.widgets

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.alexbar.demoanimations.model.ClothingItem
import com.alexbar.demoanimations.ui.theme.Dimens.dimen_24_dp
import com.alexbar.demoanimations.ui.theme.Dimens.dimen_2_dp
import com.alexbar.demoanimations.ui.theme.Dimens.dimen_48_dp
import com.alexbar.demoanimations.ui.theme.Dimens.dimen_88_dp
import com.alexbar.demoanimations.ui.theme.Dimens.dimen_8_dp
import com.alexbar.demoanimations.utils.Constants

@Composable
fun ItemWidget(
    item: ClothingItem,
    modifier: Modifier = Modifier
) {

    var expanded by rememberSaveable { mutableStateOf(false) }

    val extraPadding by animateDpAsState(
        if (expanded) dimen_88_dp else dimen_48_dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ), label = ""
    )
    Surface(
        color = Color.Transparent,
        modifier = modifier
            .padding(dimen_8_dp)
            .clip(RoundedCornerShape(dimen_8_dp))
            .border(dimen_2_dp, Color.DarkGray, RoundedCornerShape(dimen_8_dp))
    ) {
        Row(modifier = Modifier.padding(dimen_24_dp)) {
            Column(modifier = Modifier
                .weight(1f)
                .height(extraPadding)
            ) {
                Text(text = item.name,  style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Black))
                Text(text = "Price: $${item.price}")
                Text(text = item.description)
                Text(text = "Size: ${item.size}")
            }
            ElevatedButton(
                onClick = { expanded = !expanded }
            ) {
                Text(if (expanded) Constants.item_show_less else Constants.item_show_more)
            }
        }
    }
}
