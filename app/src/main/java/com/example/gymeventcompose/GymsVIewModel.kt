package com.example.gymeventcompose

import androidx.lifecycle.ViewModel
import com.example.gymeventcompose.ui.ListOfGyms

class GymsVIewModel() : ViewModel() {
    fun getGyms() = ListOfGyms
}