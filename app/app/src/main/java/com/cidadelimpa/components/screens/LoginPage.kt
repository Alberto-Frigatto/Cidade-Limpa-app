package com.cidadelimpa.components.screens

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.cidadelimpa.components.buttons.BackButton
import com.cidadelimpa.components.buttons.FillButton
import com.cidadelimpa.components.form.Form
import com.cidadelimpa.components.form.Input
import com.cidadelimpa.components.images.LogoLG
import com.cidadelimpa.components.layout.ColumnCenter
import com.cidadelimpa.ui.theme.Aqua
import com.cidadelimpa.ui.theme.DarkBlue
import com.cidadelimpa.ui.theme.roboto_bold
import com.cidadelimpa.ui.theme.roboto_regular
import com.cidadelimpa.view_model.LoginViewModel

@Composable
fun LoginPage(navController: NavController, loginViewModel: LoginViewModel)
{
    Box(modifier = Modifier.fillMaxSize())
    {
        BackButton(
            onClickAction = { navController.navigate("welcome") },
            modifier = Modifier
                .padding(0.dp)
                .align(Alignment.TopStart)
        )

        ColumnCenter {
            LogoLG()

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Preencha os dados",
                fontFamily = roboto_regular,
                fontSize = 22.sp,
                color = DarkBlue
            )

            Spacer(modifier = Modifier.height(25.dp))

            val cpf by loginViewModel.cpf.observeAsState(initial = "")
            val pwd by loginViewModel.pwd.observeAsState(initial = "")

            Form{
                Input(
                    name = "CPF",
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    placeholder = "Digite seu CPF",
                    value = cpf,
                    onValueChange = {
                        loginViewModel.onCpfChange(it)
                    }
                )
                Input(
                    name = "Senha",
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.NumberPassword
                    ),
                    placeholder = "Digite sua senha (8 números)",
                    value = pwd,
                    onValueChange = {
                        loginViewModel.onPwdChange(it)
                    },
                    visualTransformation = PasswordVisualTransformation()
                )
                Text(
                    text = "Esqueceu sua senha?"
                )
                
                Spacer(modifier = Modifier.height(30.dp))
                
                FillButton(
                    onClickAction = { /*TODO*/ },
                    horizontalArrangement = Arrangement.Center,
                    background = DarkBlue,
                    contentColor = Aqua
                ) {
                    Text(
                        text = "Entrar",
                        fontSize = 22.sp,
                        fontFamily = roboto_bold
                    )
                }
            }
        }
    }
}