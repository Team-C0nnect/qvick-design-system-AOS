package hs.dgsw.android.qvick_design_module.ui.component.button

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.traceEventEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hs.dgsw.android.qvick_design_system_aos.ui.theme.common100
import hs.dgsw.android.qvick_design_system_aos.ui.theme.opacity12
import hs.dgsw.android.qvick_design_system_aos.ui.theme.pretendard
import hs.dgsw.android.qvick_design_system_aos.ui.theme.primaryColorBlue100
import hs.dgsw.android.qvick_design_system_aos.ui.theme.primaryColorBlue500



@Composable
fun Button24(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
    text: String,
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
            color = common100,
            fontSize = 18.sp,
            fontFamily = pretendard,
            fontWeight = FontWeight.Bold
        )

    }
}

@Composable
fun Button16(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
    text: String,
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
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = text,
            modifier = Modifier,
            color = common100,
            fontSize = 18.sp,
            fontFamily = pretendard,
            fontWeight = FontWeight.Bold
        )

    }
}

@Composable
fun Button12(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
    enabled : Boolean = true,
    text: String,
    action: () -> Unit,
) {
    val buttonColors = ButtonDefaults.buttonColors(
        containerColor = tint,
        contentColor = tint,
        disabledContainerColor = tint,
        disabledContentColor = tint
    )
    Button(
        modifier = modifier,
        onClick = { action() },
        colors = buttonColors,
        enabled = enabled,
        shape = RoundedCornerShape(12.dp),
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 4.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp
        )
    ) {
        Text(
            modifier = Modifier,
            text = text,
            color = common100,
            fontSize = 20.sp,
            fontFamily = pretendard,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Test(){
    Column {
        Button16(tint = primaryColorBlue500, text = "로그인",
            modifier =  Modifier
                .fillMaxWidth()
                .height(70.dp)) {
            Log.d("taet","")
        }
        Box(modifier = Modifier.padding(5.dp))
        Button24(tint = primaryColorBlue500, text = "로그인",
            modifier =  Modifier
                .fillMaxWidth()
                .height(70.dp)) {

        }
        Box(modifier = Modifier.padding(5.dp))
        Button12(tint = primaryColorBlue500, text = "로그인",
            modifier =  Modifier
                .fillMaxWidth()
                .height(70.dp)) {

        }
    }
}

