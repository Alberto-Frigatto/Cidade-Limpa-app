package com.cidadelimpa.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.cidadelimpa.ui.theme.DarkBlue
import com.cidadelimpa.ui.theme.ExtraLightGrey
import com.cidadelimpa.ui.theme.MediumGrey
import com.cidadelimpa.ui.theme.roboto_bold

@Composable
fun FooterButton(icon: Painter, contentDescription: String, text: String, active: Boolean = false, onClickAction: () -> Unit)
{
    val colors = if (active) ButtonDefaults.buttonColors(containerColor = ExtraLightGrey, contentColor = DarkBlue)
        else ButtonDefaults.buttonColors(containerColor = Color.Transparent, contentColor = MediumGrey)

    Button(
        onClick = { onClickAction() },
        colors = colors,
        shape = RoundedCornerShape(9.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = icon,
                contentDescription = contentDescription,
                modifier = Modifier.size(32.dp)
            )
            Text(text = text, fontFamily = roboto_bold)
        }
    }
}