package com.akbarovdev.appchallanges.febrary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.akbarovdev.appchallanges.utils.FormatType
import com.akbarovdev.appchallanges.utils.ThousandFormatter

@Composable
fun ThousandSeparator(modifier: Modifier = Modifier) {
    var currentValue by remember { mutableStateOf(1000) }
    fun changeValue(value: Int) {
        currentValue = value
    }




    Scaffold(
        containerColor = Color(0xFFFEF7FF)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Thousand Separator",
                style = MaterialTheme.typography.headlineLarge
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFFF4E8FF), shape = RoundedCornerShape(
                            15.dp
                        )
                    )
                    .height(60.dp)
                    .padding(5.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                NumberCard(
                    1000, modifier = Modifier.weight(1.5f),
                    isSelected = currentValue == 1000, formatType = FormatType.Dot,
                ) {
                    changeValue(it)
                }
                NumberCard(
                    3000, modifier = Modifier.weight(1.5f),
                    isSelected = currentValue == 3000, formatType = FormatType.Comma,
                ) {
                    changeValue(it)
                }
                NumberCard(
                    2000, modifier = Modifier.weight(1.5f),
                    isSelected = currentValue == 2000, formatType = FormatType.Space,
                ) {
                    changeValue(it)
                }

            }
        }
    }
}

@Composable
fun NumberCard(
    value: Int,
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    formatType: FormatType = FormatType.Dot,
    onChangeValue: (Int) -> Unit
) {
    val backgroundColor = if (isSelected) Color.White else Color.Transparent
    val contentColor =
        if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onBackground

    Button(
        modifier = modifier.fillMaxHeight(),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        ),
        contentPadding = PaddingValues(5.dp),
        onClick = { onChangeValue(value) },
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            text = ThousandFormatter.thousandFormat(value, formatType),
            style = MaterialTheme.typography.headlineMedium,
            color = if (isSelected) Color.Black else Color(0xFF62468C)
        )
    }
}


@Preview
@Composable
private fun Separator() {
    ThousandSeparator()
}