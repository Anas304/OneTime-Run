package com.example.onetimecoderun

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.onetimecoderun.ui.theme.OneTimeCodeRunTheme

class MainActivity : ComponentActivity() {
    private var isInit = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            OneTimeCodeRunTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                    if (!isInit){
                        doSomeThingOnlyOnce(context)
                        isInit = true
                    }
                }
            }
        }
    }
}

private fun doSomeThingOnlyOnce(context: Context){
    Toast.makeText(context, "I will not say it again !!", Toast.LENGTH_SHORT).show()
}



@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OneTimeCodeRunTheme {
        Greeting("Android")
    }
}