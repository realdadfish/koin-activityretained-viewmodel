package com.example.koin_vm_activityretained

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import com.example.koin_vm_activityretained.ui.theme.KoinvmactivityretainedTheme
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.compose.koinViewModel
import org.koin.androidx.scope.activityRetainedScope
import org.koin.compose.LocalKoinScope
import org.koin.core.scope.Scope

class MainActivity : ComponentActivity(), AndroidScopeComponent {
    override val scope: Scope by activityRetainedScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KoinvmactivityretainedTheme {
                CompositionLocalProvider(LocalKoinScope provides scope) {
                    Content()
                }
            }
        }
    }
}

@Composable
fun Content(
    mainViewModel: MainViewModel = koinViewModel<MainViewModel>()
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Greeting(
            text = mainViewModel.hello(),
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun Greeting(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier
    )
}
