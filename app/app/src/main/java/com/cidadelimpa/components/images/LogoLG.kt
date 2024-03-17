package com.cidadelimpa.components.images

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.cidadelimpa.R

@Composable
fun LogoLG()
{
    Image(
        painter = painterResource(id = R.drawable.logo_lg),
        contentDescription = "logo",
        modifier = Modifier.size(220.dp)
    )
}