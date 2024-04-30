package com.alexbar.demoanimations.screens.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alexbar.demoanimations.screens.list.widgets.AnimatedBackground
import com.alexbar.demoanimations.screens.list.widgets.ItemWidget
import com.alexbar.demoanimations.utils.clothingItems

@Composable
fun ListScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        AnimatedBackground()
        LazyColumn {
            items(clothingItems) { item ->
                ItemWidget(item)
            }
        }
    }
}

