package hs.dgsw.android.qvick_design_system_aos

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.SaverScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import hs.dgsw.android.qvick_design_system_aos.ui.textfield.A
import hs.dgsw.android.qvick_design_system_aos.ui.textfield.DuckieTextField
import hs.dgsw.android.qvick_design_system_aos.ui.textfield.TextField
import hs.dgsw.android.qvick_design_system_aos.ui.theme.QvickdesignsystemAOSTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QvickdesignsystemAOSTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val test : MutableState<String> = rememberSaveable {
                        mutableStateOf("")
                    }
                    DuckieTextField(
                        text = test.value,
                        onValueChange = {old , new, length ->
                            test.value =  if (new.length > length || new.any { !it.isDigit() }) old else new
                            test.value
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QvickdesignsystemAOSTheme {
        Greeting("Android")
    }
}