package com.example.googlebuttoncompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.googlebuttoncompose.ui.theme.GoogleButtonComposeTheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoogleButtonComposeTheme {
                Column(
                    Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    GoogleButton(
                        text = "Registrate con Google",
                        loadingText = "Creando Cuenta...",
                        onClicked = {
                            Log.d("Google Button", "Clicked")
                        }
                    )
                }
            }
        }
    }
}


@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GoogleButtonComposeTheme {
        Column {
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                GoogleButton(
                    text = "Registrate con Google",
                    loadingText = "Creando Cuenta...",
                    onClicked = {
                        Log.d("Google Button", "Clicked")
                    }
                )  }

            }
        }
        }


//        Greeting("Android")



//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}

//GoogleButtonComposeTheme {
//
//    // A surface container using the 'background' color from the theme
//    Surface(color = MaterialTheme.colors.background) {
//        Greeting("Android")
//        GoogleButton()
//    }

//{
//    Column(
//        Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        //horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        GoogleButton(
//            text = "Registrate con Google",
//            loadingText = "Creando Cuenta...",
//            onClicked = {
//                Log.d("Google Button", "Clicked")
//            }
//        )
//    }
//}