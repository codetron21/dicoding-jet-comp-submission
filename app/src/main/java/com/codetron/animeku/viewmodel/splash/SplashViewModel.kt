package com.codetron.animeku.viewmodel.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {
    
    private val _doNavigate = MutableStateFlow(false)
    val doNavigate: StateFlow<Boolean> get() = _doNavigate

    fun doDelayNavigation() {
        viewModelScope.launch {
            delay(2000L)
            _doNavigate.value = true
        }
    }
}