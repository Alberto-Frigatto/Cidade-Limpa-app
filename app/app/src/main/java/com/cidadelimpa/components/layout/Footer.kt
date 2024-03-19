package com.cidadelimpa.components.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.cidadelimpa.R
import com.cidadelimpa.components.buttons.FooterButton

@Composable
fun Footer(modifier: Modifier, navController: NavController, activeBtnId: Int)
{
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 19.dp)
        )
        {
            FooterButton(
                icon = painterResource(id = R.drawable.map),
                contentDescription = "Mapa",
                text = "Mapa",
                active = activeBtnId == 1,
                onClickAction = { navController.navigate("home") }
            )
            FooterButton(
                icon = painterResource(id = R.drawable.clock),
                contentDescription = "Histórico",
                text = "Histórico",
                active = activeBtnId == 2,
                onClickAction = { navController.navigate("history") }
            )
            FooterButton(
                icon = painterResource(id = R.drawable.person),
                contentDescription = "Perfil",
                text = "Perfil",
                active = activeBtnId == 3,
                onClickAction = {}
            )
        }
    }
}