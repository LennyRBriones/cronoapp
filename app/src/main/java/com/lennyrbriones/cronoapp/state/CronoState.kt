package com.lennyrbriones.cronoapp.state

data class CronoState(
    val cronometerActivate: Boolean = false,
    val showSavebutton: Boolean = false,
    val showTextField : Boolean = false,
    val title : String = ""
)
