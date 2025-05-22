package com.sena.class22mayo

// importa las clases necesarias para crear la interfaz y componer la pantalla
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
// importa el tema definido en el proyecto
import com.sena.class22mayo.ui.theme.Class22mayoTheme

// clase principal que se ejecuta cuando se inicia la aplicacion
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge() // habilita el diseño que usa toda la pantalla incluso debajo de la barra de estado

        // establece el contenido de la actividad usando jetpack compose
        setContent {
            Class22mayoTheme { // aplica el tema definido para la app
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding -> // crea una estructura de diseño con espacios seguros
                    TutorialPantalla(modifier = Modifier.padding(innerPadding)) // llama al composable que dibuja la pantalla principal
                }
            }
        }
    }
}

// funcion composable que muestra el contenido del tutorial
@Composable
fun TutorialPantalla(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState() // crea un estado de scroll para permitir desplazarse verticalmente

    Column(
        modifier = modifier
            .fillMaxSize() // ocupatodo el alto de la pantalla
            .verticalScroll(scrollState) // habilita el scroll vertical
    ) {
        // muestra una imagen desde los recursos
        Image(
            painter = painterResource(id = R.drawable.ima_uno), // carga la imagen llamada ima_uno desde drawable
            contentDescription = "imagen del tutorial", // descripcion para accesibilidad
            modifier = Modifier.fillMaxWidth() // ocupatodo el ancho de la pantalla
        )

        // muestra el titulo del tutorial
        Text(
            text = "jetpack compose tutorial", // texto del titulo
            fontSize = 24.sp, // tamaño de fuente de 24sp
            modifier = Modifier.padding(16.dp) // agrega espacio alrededor del texto (padding en todos los lados)
        )

        // muestra el primer parrafo del texto
        Text(
            text = "jetpack compose is a modern toolkit for building native android ui. compose simplifies and accelerates ui development on android with less code, powerful tools, and intuitive kotlin apis.", // contenido del parrafo
            textAlign = TextAlign.Justify, // alinea el texto de forma justificada
            modifier = Modifier.padding(start = 16.dp, end = 16.dp) // padding solo en los lados izquierdo y derecho
        )

        // muestra el segundo parrafo del texto
        Text(
            text = "in this tutorial, you build a simple ui component with declarative functions. you call compose functions to say what elements you want and the compose compiler does the rest. compose is built around composable functions. these functions let you define your app’s ui programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the ui’s construction, such as initializing an element and then attaching it to a parent. to create a composable function, you add the @composable annotation to the function name.", // texto largo justificado
            textAlign = TextAlign.Justify, // alinea el texto de forma justificada
            modifier = Modifier.padding(16.dp) // padding en todos los lados
        )
    }
}

// funcion para previsualizar la pantalla en el editor de android studio
@Preview(showBackground = true)
@Composable
fun TutorialPantallaPreview() {
    Class22mayoTheme { // aplica el tema de la app
        TutorialPantalla() // muestra el composable para previsualizar
    }
}
