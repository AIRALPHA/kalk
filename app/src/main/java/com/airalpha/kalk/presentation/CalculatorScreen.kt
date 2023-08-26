package com.airalpha.kalk.presentation

import android.util.Log
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airalpha.kalk.R
import com.airalpha.kalk.domain.models.Position
import com.airalpha.kalk.presentation.components.FnButton
import com.airalpha.kalk.presentation.components.NbButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorScreen() {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onBackground.copy(.1f),
                    contentColor = MaterialTheme.colorScheme.onBackground
                ),
                contentPadding = PaddingValues(8.dp),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.outline_schedule),
                    contentDescription = "Localized description",
                    Modifier.size(AssistChipDefaults.IconSize)
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "1,234",
                    style = MaterialTheme.typography.labelSmall.copy(fontSize = 14.sp)
                )
            }
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onBackground.copy(.1f),
                    contentColor = MaterialTheme.colorScheme.onBackground
                ),
                contentPadding = PaddingValues(8.dp),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.outline_schedule),
                    contentDescription = "Localized description",
                    Modifier.size(AssistChipDefaults.IconSize)
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "1,234",
                    style = MaterialTheme.typography.labelSmall.copy(fontSize = 14.sp)
                )
            }
        }
    }
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(), horizontalArrangement = Arrangement.End
    ) {
        Text(
            "19,134",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.End
        )
    }
    Surface(color = MaterialTheme.colorScheme.onBackground.copy(.1f)) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(id = R.drawable.back_rounded_arrow),
                contentDescription = ""
            )
            Text(text = "12,345 + 6,789", style = MaterialTheme.typography.labelMedium)
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
            showPrimaryColor = false
        )
        FnButton(text = "+/-", showPrimaryColor = false)
        FnButton(text = "%", showPrimaryColor = false)
        FnButton(text = "÷", position = Position(top = true, last = true))
    }
    Spacer(modifier = Modifier.height(4.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        NbButton(text = "7", position = Position(first = true))
        NbButton(text = "8")
        NbButton(text = "9")
        FnButton(text = "×", position = Position(last = true))
    }
    Spacer(modifier = Modifier.height(4.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        NbButton(text = "4", position = Position(first = true))
        NbButton(text = "5")
        NbButton(text = "6")
        FnButton(text = "-", position = Position(last = true))
    }
    Spacer(modifier = Modifier.height(4.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        NbButton(text = "1", position = Position(first = true))
        NbButton(text = "2")
        NbButton(text = "3")
        FnButton(text = "+", position = Position(last = true))
    }
    Spacer(modifier = Modifier.height(4.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        NbButton(text = "0", position = Position(first = true, bottom = true), size = 2.0)
        NbButton(text = ".")
        FnButton(text = "=", position = Position(last = true, bottom = true))
    }
}