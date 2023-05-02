package com.example.jeepni.feature.initial_checkup

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jeepni.core.ui.DatePicker
import com.example.jeepni.core.ui.SolidButton
import com.example.jeepni.core.ui.theme.JeepNiTheme
import com.example.jeepni.util.UiEvent

@Composable
fun InitialCheckupScreen(
    viewModel: InitialCheckupViewModel = hiltViewModel(),
    onNavigate : (UiEvent.Navigate) -> Unit,
    onPopBackStack : () -> Unit
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                UiEvent.PopBackStack -> {
                    onPopBackStack()
                }

                is UiEvent.Navigate -> {
                    onNavigate(event)
                }

                is UiEvent.ShowSnackBar -> {

                }

                is UiEvent.ShowToast -> {
                    Toast.makeText(context, event.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    JeepNiTheme {
        Surface {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DatePicker(
                    label = "Date of last oil change",
                    pickedDate = viewModel.oilChangeDate,
                    onChange = {
                        viewModel.onEvent(
                            InitialCheckupEvent.OnOilChangeDateChange(it)
                        )
                    }
                )
                DatePicker(
                    label = "Date of last LTFRB inspection",
                    pickedDate = viewModel.ltfrbDate,
                    onChange = {
                        viewModel.onEvent(
                            InitialCheckupEvent.OnLtfrbDateChange(it)
                        )
                    }
                )
                DatePicker(
                    label = "Date of last LTO inspection",
                    pickedDate = viewModel.ltoDate,
                    onChange = {
                        viewModel.onEvent(
                            InitialCheckupEvent.OnLtoDateChange(it)
                        )
                    }
                )
                Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Checkbox(
                            checked = viewModel.isTireEnabled,
                            onCheckedChange = {
                                viewModel.onEvent(
                                    InitialCheckupEvent.OnTireClicked(it)
                                )
                            }
                        )
                        Text(
                            text = "Tire",
                            modifier = Modifier.padding(start = 50.dp)
                        )
                    }
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Checkbox(
                            checked = viewModel.isEngineEnabled,
                            onCheckedChange = {
                                viewModel.onEvent(
                                    InitialCheckupEvent.OnEngineClicked(it)
                                )
                            }
                        )
                        Text(
                            text = "Engine",
                            modifier = Modifier.padding(start = 50.dp)
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Checkbox(
                            checked = viewModel.isMirrorsEnabled,
                            onCheckedChange = {
                                viewModel.onEvent(
                                    InitialCheckupEvent.OnMirrorsClicked(it)
                                )
                            }
                        )
                        Text(
                            text = "Side Mirror",
                            modifier = Modifier.padding(start = 50.dp)
                        )
                    }
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Checkbox(
                            checked = viewModel.isSeatbeltEnabled,
                            onCheckedChange = {
                                viewModel.onEvent(
                                    InitialCheckupEvent.OnSeatbeltClicked(it)
                                )
                            }
                        )
                        Text(
                            text = "Seat Belt",
                            modifier = Modifier.padding(start = 50.dp)
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Checkbox(
                            checked = viewModel.isWipersEnabled,
                            onCheckedChange = {
                                viewModel.onEvent(
                                    InitialCheckupEvent.OnWipersClicked(it)
                                )
                            }
                        )
                        Text(
                            text = "Wipers",
                            modifier = Modifier.padding(start = 50.dp)
                        )
                    }
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Checkbox(
                            checked = viewModel.isBatteryEnabled,
                            onCheckedChange = {
                                viewModel.onEvent(
                                    InitialCheckupEvent.OnBatteryClicked(it)
                                )
                            }
                        )
                        Text(
                            text = "Battery",
                            modifier = Modifier.padding(start = 50.dp)
                        )
                    }
                }
                SolidButton(
                    onClick = { viewModel.onEvent(InitialCheckupEvent.OnSaveClicked) }
                ) {
                    Text("Save")
                }
            }
        }
    }
}
@Preview
@Composable
fun ICPreview(){
    InitialCheckupScreen(onNavigate = {}){
    }
}