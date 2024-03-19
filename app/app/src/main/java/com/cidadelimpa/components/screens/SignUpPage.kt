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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
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
import com.cidadelimpa.model.Address
import com.cidadelimpa.ui.theme.Aqua
import com.cidadelimpa.ui.theme.DarkBlue
import com.cidadelimpa.ui.theme.roboto_bold
import com.cidadelimpa.ui.theme.roboto_regular
import com.cidadelimpa.view_model.SignUpViewModel

@Composable
fun SignUpPage(navController: NavController, signUpViewModel: SignUpViewModel)
{
    Box(modifier = Modifier.fillMaxSize())
    {
        BackButton(
            onClickAction = { navController.navigate("welcome") },
            modifier = Modifier
                .padding(top = 15.dp)
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

            val nome by signUpViewModel.name.observeAsState(initial = "")
            val cpf by signUpViewModel.cpf.observeAsState(initial = "")
            val birthDate by signUpViewModel.birthDate.observeAsState(initial = "")
            val cep by signUpViewModel.cep.observeAsState(initial = "")
            val pwd by signUpViewModel.pwd.observeAsState(initial = "")
            val address by signUpViewModel.address.observeAsState(initial = Address())

            val addressText = if (address.logradouro == "") ""
             else "${address.logradouro}, ${address.bairro}, ${address.cidade} - ${address.uf}"

            Form {
                Input(
                    name = "Nome",
                    keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words),
                    placeholder = "Digite seu nome",
                    value = nome,
                    onValueChange = {
                        signUpViewModel.onNameChange(it)
                    }
                )
                Input(
                    name = "CPF",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    placeholder = "Digite seu CPF",
                    value = cpf,
                    onValueChange = {
                        signUpViewModel.onCpfChange(it)
                    }
                )
                Input(
                    name = "CEP",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    placeholder = "Digite seu CEP",
                    value = cep,
                    onValueChange = {
                        signUpViewModel.onCepChange(it)
                        signUpViewModel.getAddressByCep(it)
                    }
                )
                Input(
                    name = "Endereço",
                    enabled = false,
                    required = false,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    placeholder = "Digite o CEP no campo acima",
                    value = addressText,
                    onValueChange = {
                        signUpViewModel.getAddressByCep(it)
                    }
                )
                Input(
                    name = "Senha",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                    placeholder = "Digite sua senha (8 números)",
                    value = pwd,
                    onValueChange = {
                        signUpViewModel.onPwdChange(it)
                    },
                    visualTransformation = PasswordVisualTransformation()
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
