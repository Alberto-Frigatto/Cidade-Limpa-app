package com.cidadelimpa.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.cidadelimpa.ui.theme.DarkBlue

@Composable
fun OutlineButton(
    onClickAction: () -> Unit,
    horizontalArrangement: Arrangement.Horizontal,
    borderColor: Color,
    contentColor: Color,
    content: @Composable () -> Unit
) {
    Button(
        onClick = { onClickAction() },
        shape = RoundedCornerShape(7.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp),
        contentPadding = PaddingValues(18.dp, 13.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent, contentColor = contentColor),
        border = BorderStroke(2.dp, borderColor)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = horizontalArrangement,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp)
        ) {
            content()
        }
    }
}