package com.example.composeplayground.networkObserver

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class NetworkObserverViewModel(private val connectivityObserver: ConnectivityObserver) :
    ViewModel() {

    val networkStatus: StateFlow<ConnectivityStatus> = connectivityObserver.observe()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = ConnectivityStatus.Unavailable
        )

}