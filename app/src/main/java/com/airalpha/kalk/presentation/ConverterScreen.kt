package com.airalpha.kalk.presentation

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airalpha.kalk.R
import com.airalpha.kalk.domain.models.Position
import com.airalpha.kalk.presentation.components.FnButton
import com.airalpha.kalk.presentation.components.NbButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConverterScreen() {
    var selectedIndex by remember { mutableStateOf(0) }

    val list = listOf("Calculator", "Converter")

    val context = LocalContext.current
    val meters = arrayOf("Length", "Other")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(meters[0]) }

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
                    list.forEachIndexed { index, s ->
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
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = {
                            expanded = !expanded
                        }
                    ) {
                        Row(modifier = Modifier.menuAnchor()) {
                            Text(selectedText, style = MaterialTheme.typography.labelSmall)
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                        }

                        ExposedDropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            meters.forEach { item ->
                                DropdownMenuItem(
                                    text = { Text(text = item) },
                                    onClick = {
                                        selectedText = item
                                        expanded = false
                                        Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                                    }
                                )
                            }
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .padding(18.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextField(
                        value = "SDS",
                        onValueChange = {},
                        colors = TextFieldDefaults.textFieldColors(
                            unfocusedLabelColor = MaterialTheme.colorScheme.background,
                            focusedLabelColor = MaterialTheme.colorScheme.background,
                            containerColor = MaterialTheme.colorScheme.background,
                            focusedIndicatorColor = MaterialTheme.colorScheme.onBackground,
                            unfocusedIndicatorColor = MaterialTheme.colorScheme.onBackground,
                            cursorColor = MaterialTheme.colorScheme.onBackground,
                            textColor = MaterialTheme.colorScheme.onBackground,
                        )
                    )
                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = {
                            expanded = !expanded
                        }
                    ) {
                        Row(modifier = Modifier.menuAnchor()) {
                            Text("ft", style = MaterialTheme.typography.labelSmall)
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                        }

                        ExposedDropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            meters.forEach { item ->
                                DropdownMenuItem(
                                    text = { Text(text = item) },
                                    onClick = {
                                        selectedText = item
                                        expanded = false
                                        Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                                    }
                                )
                            }
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .padding(18.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextField(
                        value = "SDS",
                        onValueChange = {},
                        colors = TextFieldDefaults.textFieldColors(
                            unfocusedLabelColor = MaterialTheme.colorScheme.background,
                            focusedLabelColor = MaterialTheme.colorScheme.background,
                            containerColor = MaterialTheme.colorScheme.background,
                            focusedIndicatorColor = MaterialTheme.colorScheme.onBackground,
                            unfocusedIndicatorColor = MaterialTheme.colorScheme.onBackground,
                            cursorColor = MaterialTheme.colorScheme.onBackground,
                            textColor = MaterialTheme.colorScheme.onBackground,
                        )
                    )
                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = {
                            expanded = !expanded
                        }
                    ) {
                        Row(modifier = Modifier.menuAnchor()) {
                            Text("ft", style = MaterialTheme.typography.labelSmall)
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                        }

                        ExposedDropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            meters.forEach { item ->
                                DropdownMenuItem(
                                    text = { Text(text = item) },
                                    onClick = {
                                        selectedText = item
                                        expanded = false
                                        Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                                    }
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    FnButton(
                        text = "AC",
                        position = Position(top = true, first = true),
                        showPrimaryColor = false,
                        size = 2.0
                    )
                    FnButton(
                        text = "switch",
                        showPrimaryColor = false,
                        position = Position(top = true, last = true),
                        size = 2.0
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    NbButton(text = "7", position = Position(first = true), size = (4.0).div(3))
                    NbButton(text = "8", size = (4.0).div(3))
                    NbButton(text = "9", size = (4.0).div(3), position = Position(last = true))
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    NbButton(text = "4", position = Position(first = true), size = (4.0).div(3))
                    NbButton(text = "5", size = (4.0).div(3))
                    NbButton(text = "6", size = (4.0).div(3), position = Position(last = true))
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    NbButton(text = "1", position = Position(first = true), size = (4.0).div(3))
                    NbButton(text = "2", size = (4.0).div(3))
                    NbButton(text = "3", size = (4.0).div(3), position = Position(last = true))
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    NbButton(text = ".", position = Position(first = true, bottom = true), size = (4.0).div(3))
                    NbButton(text = "0", size = (4.0).div(3))
                    FnButton(
                        text = "clear",
                        size = (4.0).div(3),
                        position = Position(last = true, bottom = true),
                        showPrimaryColor = false
                    )
                }
            }
        }
    }
}