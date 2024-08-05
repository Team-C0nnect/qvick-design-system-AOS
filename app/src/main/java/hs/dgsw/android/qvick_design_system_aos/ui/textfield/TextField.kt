package hs.dgsw.android.qvick_design_system_aos.ui.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hs.dgsw.android.qvick_design_system_aos.R

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

    OutlinedTextField(
        value = value,
        onValueChange = {
            value = it
        },
        modifier = modifier,
        textStyle = textStyle,
        isError = isError,
        enabled = true,
    )
}

@Composable
private fun DuckieTextField(
    text: String,
    onTextChanged: (String) -> Unit,
) {
    BasicTextField(
        value = text,
        onValueChange = onTextChanged,
        decorationBox = {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                text.forEachIndexed { index, char ->
                    DuckieTextFieldCharContainer(
                        text = char,
                        isFocused = index == text.lastIndex,
                    )
                }
                repeat(10 - text.length) {
                    DuckieTextFieldCharContainer(
                        text = ' ',
                        isFocused = false,
                    )
                }
            }
        },
    )
}

@Composable
private fun DuckieTextFieldCharContainer(
    modifier: Modifier = Modifier,
    text: Char,
    isFocused: Boolean,
) {
    val shape = remember { RoundedCornerShape(4.dp) }

    Box(
        modifier = modifier
            .size(
                width = 29.dp,
                height = 40.dp,
            )
            .background(
                color = Color(0xFFF6F6F6),
                shape = shape,
            )
            .run {
                if (isFocused) {
                    border(
                        width = 1.dp,
                        color = Color(0xFFFF8300),
                        shape = shape,
                    )
                } else {
                    this
                }
            },
        contentAlignment = Alignment.Center,
    ) {
        Text(text = text.toString())
    }
}

@Preview(showBackground = true)
@Composable
fun TextFieldTest(){

    var test = remember {
        "test"
    }
    Column {
        Text(text = test)
        DuckieTextField(
            text = test,
            onTextChanged = {
                test = it
            }
        )
        val a = Icon(painter = Painter(), contentDescription = "")
        TextField(endIcon = )

    }
}