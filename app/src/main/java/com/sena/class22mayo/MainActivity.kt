package com.sena.class22mayo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sena.class22mayo.ui.theme.Class22mayoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Class22mayoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TutorialPantalla(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun TutorialPantalla(modifier: Modifier = Modifier) {
    // Scroll state para permitir desplazamiento
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState) // Activar scroll
    ) {
        // Imagen principal
        Image(
            painter = painterResource(id = R.drawable.ima_uno),
            contentDescription = "Imagen del tutorial",
            modifier = Modifier.fillMaxWidth()
        )

        // Título
        Text(
            text = "Jetpack Compose tutorial",
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )

        // Primer párrafo
        Text(
            text = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )

        // Segundo párrafo
        Text(
            text = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app’s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI’s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.",
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TutorialPantallaPreview() {
    Class22mayoTheme {
        TutorialPantalla()
    }
}
