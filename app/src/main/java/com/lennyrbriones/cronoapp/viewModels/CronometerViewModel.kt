package com.lennyrbriones.cronoapp.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lennyrbriones.cronoapp.state.CronoState
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CronometerViewModel: ViewModel(){

    var state by mutableStateOf(CronoState())
        private set

    var cronoJob by mutableStateOf<Job?>(null)
        private set

    var time by mutableStateOf(0L) //long value
        private set

    fun onValue(value:String){
        state = state.copy(title = value)
    }

    fun start(){
        state = state.copy(
            cronometerActivate = true
        )
    }

    fun pause(){
        state = state.copy(
            cronometerActivate = false,
            showSavebutton = true
        )
    }

    fun stop(){
        cronoJob?.cancel()
        time = 0
        state = state.copy(
            cronometerActivate = false,
            showSavebutton = false,
            showTextField = false
        )
    }

    fun showTextField(){
        state = state.copy(
            showTextField = true
        )
    }

    fun crono(){
        if(state.cronometerActivate){
            cronoJob?.cancel()
            cronoJob = viewModelScope.launch {
                while (true){
                    delay(1000)
                    time += 1000
                }
            }

        }else{
            cronoJob?.cancel()
        }
    }
    
}