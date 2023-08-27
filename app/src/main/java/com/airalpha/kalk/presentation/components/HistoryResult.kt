package com.airalpha.kalk.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airalpha.kalk.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryResult() {
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