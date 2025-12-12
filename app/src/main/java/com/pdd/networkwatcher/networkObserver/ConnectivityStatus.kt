package com.example.composeplayground.networkObserver

sealed interface ConnectivityStatus {
    object Available : ConnectivityStatus
    object Unavailable : ConnectivityStatus
    object Losing : ConnectivityStatus
    object Lost : ConnectivityStatus
}