package com.cidadelimpa.components.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.cidadelimpa.components.buttons.BackButton
import com.cidadelimpa.components.buttons.FillButton
import com.cidadelimpa.components.form.Form
import com.cidadelimpa.components.form.Input
import com.cidadelimpa.components.images.LogoSM
import com.cidadelimpa.components.layout.ColumnCenter
import com.cidadelimpa.ui.theme.Aqua
import com.cidadelimpa.ui.theme.DarkBlue
import com.cidadelimpa.ui.theme.roboto_bold
import com.cidadelimpa.ui.theme.roboto_regular

@Composable
fun SignUpPage(navController: NavController)
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
            LogoSM()

            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = "Criar conta",
                fontFamily = roboto_regular,
                fontSize = 22.sp,
                color = DarkBlue
            )

            Spacer(modifier = Modifier.height(35.dp))

            var nome = remember {
                mutableStateOf("")
            }
            var cpf = remember {
                mutableStateOf("")
            }
            var dataNascimento = remember {
                mutableStateOf("")
            }
            var cep = remember {
                mutableStateOf("")
            }
            var senha = remember {
                mutableStateOf("")
            }

            Form {
                Input(
                    name = "Nome",
                    keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words),
                    placeholder = "Digite seu nome",
                    state = nome
                )
                Input(
                    name = "CPF",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    placeholder = "Digite seu CPF",
                    state = cpf
                )
                Input(
                    name = "Data de Nascimento",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    placeholder = "Digite sua Data de Nascimento",
                    state = dataNascimento
                )
                Input(
                    name = "CEP",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    placeholder = "Digite seu CEP",
                    state = cep
                )
                Input(
                    name = "Senha",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                    placeholder = "Digite sua senha (8 números)",
                    state = senha
                )
            }
            val styledText = buildAnnotatedString {
                append("Ao se cadastrar, você concorda com os ")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Termos")
                }

                append(" e ")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Condições")
                }

                append(" do aplicativo")
            }


            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = styledText,
                fontFamily = roboto_regular,
                textAlign = TextAlign.Center,
                modifier = Modifier.width(300.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))

            FillButton(
                onClickAction = { /*TODO*/ },
                horizontalArrangement = Arrangement.Center,
                background = DarkBlue,
                contentColor = Aqua
            ) {
                Text(
                    text = "Cadastrar",
                    fontSize = 22.sp,
                    fontFamily = roboto_bold
                )
            }
        }
    }
}
