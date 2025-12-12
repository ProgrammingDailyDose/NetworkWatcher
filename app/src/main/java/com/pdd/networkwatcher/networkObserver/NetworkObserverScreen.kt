package com.example.composeplayground.networkObserver

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun NetworkObserverScreen(
    modifier: Modifier = Modifier,
) {

    val context = LocalContext.current
    val viewModel = viewModel<NetworkObserverViewModel>(
        factory = object : androidx.lifecycle.ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return NetworkObserverViewModel(
                    NetworkConnectivityObserver(context.applicationContext)
                ) as T
            }
        }
    )

    val networkState by viewModel.networkStatus.collectAsStateWithLifecycle()


    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        val isConnected = if ( networkState == ConnectivityStatus.Available) "Yes" else "No"
        Text(
            text = "Is network available:  $isConnected",
            style = MaterialTheme.typography.headlineMedium
        )
    }

}