package com.airalpha.kalk.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var selectedIndex by remember { mutableStateOf(0) }

    val screens = listOf("Calculator", "Converter")

    Scaffold(
    ) {
        Surface(modifier = Modifier.padding(it), color = MaterialTheme.colorScheme.background) {
            Column {
                TabRow(
                    selectedTabIndex = selectedIndex,
                    containerColor = MaterialTheme.colorScheme.onBackground.copy(.1f),
                    modifier = Modifier
                        .padding(16.dp)
                        .clip(ShapeDefaults.ExtraSmall),
                    indicator = {},
                    divider = {}
                ) {
                    screens.forEachIndexed { index, s ->
                        val selected = selectedIndex == index
                        Tab(
                            modifier = if (selected) Modifier
                                .background(MaterialTheme.colorScheme.primaryContainer)
                            else Modifier,
                            selected = selected,
                            onClick = { selectedIndex = index },
                            text = {
                                Text(
                                    text = s,
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = if (selected) MaterialTheme.colorScheme.onPrimaryContainer
                                    else MaterialTheme.colorScheme.onBackground
                                )
                            }
                        )
                    }
                }

                if (selectedIndex == 0 ) CalculatorScreen() else ConverterScreen()
            }
        }
    }
}