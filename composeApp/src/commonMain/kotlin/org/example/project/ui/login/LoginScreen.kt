package org.example.project.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.example.project.ui.common.PresenceButton
import org.example.project.ui.common.CheckBoxRow
import org.example.project.ui.common.PresenceTextField
import org.example.project.ui.schedule.ScheduleScreen

class LoginScreen: Screen {

    @Composable
    override fun Content() {
        val navigator  = LocalNavigator.currentOrThrow
        val viewModel: LoginViewModel = koinScreenModel()
        val state = viewModel.state.collectAsState().value
        LaunchedEffect(state.success){
            if (state.groupId != 0)

                navigator.push(ScheduleScreen(state.groupId))
        }
        Login(viewModel)
    }

    @Composable
    fun Login(viewModel: LoginViewModel){
        val state = viewModel.state.collectAsState().value
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().background(Color.White).padding(horizontal = 32.dp)
        ) {
            state.error?.let {
                Dialog(
                    onDismissRequest = { viewModel.resetError() }
                ){
                    Column(
                        modifier = Modifier.fillMaxWidth().wrapContentHeight().background(Color.White, RoundedCornerShape(10.dp)).padding(10.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            it
                        )
                    }
                }
            }
            Column(
                modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(top = 142.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Добро пожаловать!",
                    color = Color(0xFF2c2c2c),
                    textAlign = TextAlign.Center
                )
                PresenceTextField(
                    value = state.login,
                    onValue = viewModel::onLogin,
                    placeholder = "xyz",
                    text = "Логин",
                    top = 145

                )
                PresenceTextField(
                    value = state.password,
                    onValue = viewModel::onPassword,
                    placeholder = "********",
                    text = "Пароль",
                    top = 18
                )
                CheckBoxRow(
                    check = state.check,
                    onCheck = { viewModel.onCheck() },
                    top = 24
                )
            }
            PresenceButton(
                text = "Войти",
                onClick = {
                    viewModel.login(state.login, state.password)
                },
                bottom = 80
            )
        }
    }
}