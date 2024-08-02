package hs.dgsw.android.qvick_design_system_aos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import hs.dgsw.android.qvick_design_system_aos.ui.component.toggle.Notification
import hs.dgsw.android.qvick_design_system_aos.ui.theme.IcNotifications
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
                    val test = arrayOf<String>("", "", "")
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(1f),
                        content = {
                            itemsIndexed(
                                items = test,
                                key = null
                            ) {index, item ->
                                Notification(title ="$index", date ="2020-2-20", writer ="이건의", description ="ㄱㅓㄴㅣㄱㅏㅆㅡㄴ ㄱㅗㅇㅈㅣ") {
                                    IcNotifications(contentDescription = "")
                                }
                            }
                        }
                    )

                }
            }
        }
    }
}
