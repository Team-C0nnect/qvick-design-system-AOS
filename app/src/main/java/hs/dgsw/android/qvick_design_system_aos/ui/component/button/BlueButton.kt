package hs.dgsw.android.qvick_design_system_aos.ui.component.button

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.traceEventEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hs.dgsw.android.qvick_design_system_aos.ui.theme.common100
import hs.dgsw.android.qvick_design_system_aos.ui.theme.opacity12
import hs.dgsw.android.qvick_design_system_aos.ui.theme.primaryColorBlue100
import hs.dgsw.android.qvick_design_system_aos.ui.theme.primaryColorBlue500



@Composable
fun Button24(
    tint: Color = Color.Unspecified,
    text: String,
    modifier: Modifier = Modifier,
    enabled : Boolean = true,
    action: () -> Unit,
) {
    val buttonColors = ButtonDefaults.buttonColors(
        containerColor = tint,
        contentColor = common100,
        disabledContainerColor = opacity12,
        disabledContentColor = common100
    )
    Button(
        modifier = modifier,
        onClick = { action() },
        colors = buttonColors,
        enabled = enabled,
        shape = RoundedCornerShape(24.dp)
    ) {
        Text(
            text = text,
            modifier = Modifier,
            color = common100)

    }
}

@Composable
fun Button16(
    tint: Color = Color.Unspecified,
    text: String,
    modifier: Modifier = Modifier,
    enabled : Boolean = true,
    action: () -> Unit,
) {

    val buttonColors = ButtonDefaults.buttonColors(
        containerColor = tint,
        contentColor = common100,
        disabledContainerColor = opacity12,
        disabledContentColor = common100
    )

    Button(
        modifier = modifier,
        colors = buttonColors,
        onClick = { action() },
        enabled = enabled,
        shape = RoundedCornerShape(24.dp)
    ) {
        Text(
            text = text,
            modifier = Modifier,
            color = common100)

    }
}

@Preview(showBackground = true)
@Composable
fun Test(){
    Column {
        Button16(tint = primaryColorBlue500, text = "로그인", Modifier.fillMaxWidth().height(70.dp)) {
            Log.d("taet","")
        }
        Button24(tint = primaryColorBlue500, text = "로그인", Modifier.fillMaxWidth().height(70.dp)) {

        }
    }
}

