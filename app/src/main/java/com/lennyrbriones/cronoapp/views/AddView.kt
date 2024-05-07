package com.lennyrbriones.cronoapp.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.lennyrbriones.cronoapp.R
import com.lennyrbriones.cronoapp.components.FloatButton
import com.lennyrbriones.cronoapp.components.MainIconButton
import com.lennyrbriones.cronoapp.components.MainTitle
import com.lennyrbriones.cronoapp.components.circleButton
import com.lennyrbriones.cronoapp.components.formatTime
import com.lennyrbriones.cronoapp.viewModels.CronometerViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddView(navController: NavController, cronometerVM: CronometerViewModel) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { MainTitle(title = "CronoApp") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        navController.popBackStack()
                    }

                }
            )
        }
    ) {
        ContentAddView(it, navController, cronometerVM)
    }
}

@Composable
fun ContentAddView(
    it: PaddingValues,
    navController: NavController,
    cronometerVM: CronometerViewModel
) {

    val state = cronometerVM.state

    LaunchedEffect(state.cronometerActivate) {
        cronometerVM.crono()
    }

    Column(
        modifier = Modifier
            .padding(it)
            .padding(top = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = formatTime(cronometerVM.time),
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold
        )

        Row (horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(vertical = 16.dp)
        ){
            //Start Button
            circleButton(
                icon = painterResource(id = R.drawable.ic_play),
                enable  = !state.cronometerActivate
            ){
                cronometerVM.start()
            }
            // Pause Button
            circleButton(
                icon = painterResource(id = R.drawable.ic_pause),
                enable  = state.cronometerActivate
            ){
                cronometerVM.pause()
            }

            //Stop Button
            circleButton(
                icon = painterResource(id = R.drawable.ic_stop),
                enable  = !state.cronometerActivate
            ){
                cronometerVM.stop()
            }

            //Show Save
            circleButton(
                icon = painterResource(id = R.drawable.ic_save),
                enable  = state.showSavebutton
            ){
                cronometerVM.showTextField()
            }
        }

    }
}
