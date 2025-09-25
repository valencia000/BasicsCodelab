package com.example.basicscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicscodelab.ui.theme.BasicsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    // Estado reactivo: Compose redibuja si cambia
    var expanded1 by rememberSaveable { mutableStateOf(false) }
    var expanded2 by rememberSaveable { mutableStateOf(false) }

    Surface(modifier) {
        Column(modifier = Modifier.padding(8.dp)) {
            Greeting(
                name = "Juan",
                expanded = expanded1,
                onExpandChange = { expanded1 = it }
            )
            Greeting(
                name = "Valencia",
                expanded = expanded2,
                onExpandChange = { expanded2 = it }
            )
        }
    }
}

@Composable
fun Greeting(
    name: String,
    expanded: Boolean,
    onExpandChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(8.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Column(Modifier.weight(1f)) {
                Text(text = "Hello, ")
                Text(text = name)
            }
            ElevatedButton(onClick = { onExpandChange(!expanded) }) {
                Text(if (expanded) "Show less" else "Show more")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    BasicsCodelabTheme {
        MyApp(Modifier.fillMaxSize())
    }
}