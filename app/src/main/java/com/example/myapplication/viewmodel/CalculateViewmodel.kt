package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel

class CalculateViewmodel: ViewModel(){
    fun calculateDelta(a: Double, b: Double,c: Double): Double{
        var delta=b*b - 4*a*c
    return delta
    }
}