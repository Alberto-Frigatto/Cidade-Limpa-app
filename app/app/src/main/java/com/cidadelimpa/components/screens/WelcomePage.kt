package com.cidadelimpa.components.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.cidadelimpa.R
import com.cidadelimpa.components.buttons.FillButton
import com.cidadelimpa.components.buttons.OutlineButton
import com.cidadelimpa.components.buttons.SocialMediaLogin
import com.cidadelimpa.components.images.LogoLG
import com.cidadelimpa.components.layout.ColumnCenter
import com.cidadelimpa.ui.theme.Aqua
import com.cidadelimpa.ui.theme.DarkBlue
import com.cidadelimpa.ui.theme.roboto_bold
import com.cidadelimpa.ui.theme.roboto_regular

@Composable
fun WelcomePage(navController: NavController)
{
    ColumnCenter {
        LogoLG()

        Spacer(modifier = Modifier.height(70.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            FillButton(
                onClickAction = { navController.navigate("login") },
                horizontalArrangement = Arrangement.SpaceBetween,
                background = DarkBlue,
                contentColor = Aqua
            ) {
                Text(
                    text = "Entrar",
                    fontSize = 22.sp,
                    fontFamily = roboto_bold
                )
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
                    contentDescription = "Seta para a direita",
                    modifier = Modifier.size(27.dp)
                )
            }

            OutlineButton(
                onClickAction = { navController.navigate("sign_up") },
                horizontalArrangement = Arrangement.SpaceBetween,
                borderColor = DarkBlue,
                contentColor = DarkBlue
            ) {
                Text(
                    text = "Criar conta",
                    fontSize = 22.sp,
                    fontFamily = roboto_bold
                )
                Icon(
                    painter = painterResource(id = R.drawable.person_fill),
                    contentDescription = "Seta para a direita",
                    modifier = Modifier.size(27.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(60.dp))

        Text(
            text = "Ou",
            fontSize = 18.sp,
            fontFamily = roboto_regular
        )

        Spacer(modifier = Modifier.height(60.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.width(250.dp)
        ) {
            SocialMediaLogin(
                image = painterResource(id = R.drawable.google),
                contentDescription = "Google",
                onClickAction = { navController.navigate("home") }
            )
            SocialMediaLogin(
                image = painterResource(id = R.drawable.facebook),
                contentDescription = "Facebook",
                onClickAction = { navController.navigate("home") }
            )
            SocialMediaLogin(
                image = painterResource(id = R.drawable.gov),
                contentDescription = "Gov.br",
                onClickAction = { navController.navigate("home") }
            )
        }
    }
}