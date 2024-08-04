package hs.dgsw.android.qvick_design_system_aos.ui.textfield

import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle

@Composable
fun TextField(
    modifier: Modifier = Modifier,
    hint: String = "",
    label : String = "",
    textStyle: TextStyle,
    startIcon: () -> Unit,
    endIcon: () -> Unit,
    customValue: String = "",
    isError : Boolean = false
){
    var value: String = rememberSaveable {
        customValue
    }

//    OutlinedTextField(
//        value = value,
//        onValueChange = {
//            value = it
//        },
//        modifier = modifier,
//        textStyle = textStyle,
//        isError = isError,
//        enabled = true,
//        label = label,
//        endIcon = {endIcon},
//        startIcon = { startIcon}
//    )
}