package hs.dgsw.android.qvick_design_system_aos.ui.textfield

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
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hs.dgsw.android.qvick_design_system_aos.R

@Composable
fun TextField(
    modifier: Modifier = Modifier,
    hint: String = "",
    label: String = "",
    textStyle: TextStyle,
    startIcon: () -> Unit,
    endIcon: () -> Unit,
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
        readOnly = false,
        textStyle = textStyle,
        label = null,
        placeholder = null,
        leadingIcon = null,
        trailingIcon= null,
        prefix = null,
        suffix = null,
        supportingText = null,
        isError = isError,
        visualTransformation = VisualTransformation.None,
        keyboardOptions = KeyboardOptions.Default,
        keyboardActions = KeyboardActions.Default,
        singleLine = false,
        maxLines =  1 ,
        minLines = 1,
        interactionSource = remember { MutableInteractionSource() },
        shape = OutlinedTextFieldDefaults.shape,
        colors = OutlinedTextFieldDefaults.colors()
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
fun TextFieldTest() {

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
        val a = Icon(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = ""
        )
        TextField(endIcon = { a }, startIcon = { a }, textStyle = TextStyle())

    }
}