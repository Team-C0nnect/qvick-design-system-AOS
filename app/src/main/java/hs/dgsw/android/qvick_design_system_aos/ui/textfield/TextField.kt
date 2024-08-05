package hs.dgsw.android.qvick_design_system_aos.ui.textfield

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.substring
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hs.dgsw.android.qvick_design_system_aos.R
import hs.dgsw.android.qvick_design_system_aos.ui.theme.colorNull
import hs.dgsw.android.qvick_design_system_aos.ui.theme.opacity74
import hs.dgsw.android.qvick_design_system_aos.ui.theme.primaryColorBlue500
import hs.dgsw.android.qvick_design_system_aos.ui.theme.primaryColorBlue600
import kotlin.math.abs

@Composable
fun TextField(
    modifier: Modifier = Modifier,
    hint: @Composable (() -> Unit)? = null,
    label: String = "",
    textStyle: TextStyle,
    startIcon: @Composable () -> Unit,
    endIcon: @Composable () -> Unit,
    customValue: String = "",
    isError: Boolean = false,
) {
    var value: String = rememberSaveable {
        customValue
    }

    OutlinedTextField(
        value = value,
        onValueChange = {
            value = it
        },
        modifier = modifier,
        enabled = true,
        textStyle = textStyle,
        label = { A() },

        )
}

@Composable
fun DuckieTextField(
    text: String,
    length: Int = 4,
    charTextField: @Composable (Char, Boolean) -> Unit = {char, isFocused -> DuckieTextFieldCharContainer(Modifier, char, isFocused) },
    onValueChange: (String, String, Int) -> String = { _, new, _ -> new },
    keyboardOptions : KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
) {
    BasicTextField(
        value = text,
        onValueChange = {
            onValueChange(text, it, length)
            Log.d("tag", "text = $it")
            Log.d("tag", "length = ${text.length}")
            Log.d("tag", "sub length = ${length - text.length}")
        },
        decorationBox = {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                text.forEachIndexed { index, char ->
                    charTextField(
                        char,
                        index == text.lastIndex,
                    )
                }
                repeat(abs(length - text.length)) {
                    charTextField(
                         ' ',
                         false
                    )
                }
            }
        },
        keyboardOptions = keyboardOptions,
    )
}

@Composable
private fun DuckieTextFieldCharContainer(
    modifier: Modifier = Modifier,
    text: Char,
    isFocused: Boolean

) {
    val shape = remember { RoundedCornerShape(4.dp) }

    Box(
        modifier = modifier
            .size(
                width = 29.dp,
                height = 40.dp,
            )
            .background(
                color = colorNull,
                shape = shape,
            )
            .run {
                if (isFocused) {
                    border(
                        width = 1.dp,
                        color = primaryColorBlue600,
                        shape = shape,
                    )
                } else {
                    border(
                        width = 1.dp,
                        color = opacity74,
                        shape = shape,
                    )
                }
            },
        contentAlignment = Alignment.Center,
    ) {
        Text(text = text.toString())
    }
}

@Preview(showBackground = true)
@Composable
fun TextFieldTest() {

    var test = remember {
        "test"
    }
    Column {
        Text(text = test)
        DuckieTextField(
            text = test,
            onValueChange = {old , new, length ->
                if (new.length > length || new.any { !it.isDigit() }) old else new
            }
        )
        TextField(endIcon = { A() }, startIcon = { A() }, textStyle = TextStyle())

    }
}

@Composable
fun A() {
    Icon(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = ""
    )
}