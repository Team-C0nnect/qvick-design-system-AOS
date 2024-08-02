package hs.dgsw.android.qvick_design_system_aos.ui.component.toggle

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hs.dgsw.android.qvick_design_system_aos.ui.theme.IcNotifications
import hs.dgsw.android.qvick_design_system_aos.ui.theme.common0
import hs.dgsw.android.qvick_design_system_aos.ui.theme.opacity0
import hs.dgsw.android.qvick_design_system_aos.ui.theme.opacity74


@Composable
fun Notification(
    title: String,
    date: String,
    writer: String,
    description: String,
    modifier: Modifier = Modifier,
    icon: @Composable () -> Unit,
) {
    val isVisibility = remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .padding(start = 30.dp, end = 30.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(opacity0)
    ) {
        Column(
            modifier
        ) {
            Box(
                modifier = modifier
                    .clickable {
                        isVisibility.value = !isVisibility.value
                        Log.d("TAG", "clicked Box | isVisibility : $isVisibility")
                    }
                    .wrapContentWidth()
                    .fillMaxWidth(1F),

                ) {
                Row(
                    modifier = modifier
                        .fillMaxWidth(1f)
                        .padding(
                            top = 12.dp,
                            bottom = 12.dp,
                            start = 16.dp,
                            end = 16.dp
                        ),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = modifier,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        icon()
                        Column(
                            modifier = modifier.padding(
                                start = 12.dp
                            )
                        ) {
                            Text(
                                text = title,
                                modifier = modifier,
                                style = TextStyle.Default
                            )
                            Box(modifier = modifier.padding(top = 4.dp))
                            Text(
                                text = date,
                                modifier = modifier,
                                style = TextStyle.Default,
                                color = opacity74
                            )
                        }
                    }
                    Text(
                        text = "작성자 : $writer",
                        modifier = modifier
                            .align(alignment = Alignment.Bottom),
                        color = opacity74
                    )
                }

            }
            if (isVisibility.value) {
                DrawLine()
                DescriptionText(description = description)
            }
        }
    }
}

@Composable
fun DescriptionText(description: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(20.dp)
            .wrapContentWidth()
            .fillMaxWidth(1F)
    ) {
        Text(text = description)
    }
}

@Preview(showBackground = true, backgroundColor = 500)
@Composable
fun GreetingPreview() {
    Notification(
        "test",
        "0000-00-00",
        "이진식",
        "대충 디스크립션입니다잉."
    ) { IcNotifications(contentDescription = "") }
}

@Composable
fun DrawLine(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier
            .wrapContentWidth()
            .fillMaxWidth(1f)
            .background(Color.White),
    ) {
        drawLine(
            color = common0,
            start = Offset(0f, 0f),
            end = Offset(size.maxDimension, 0f),
            strokeWidth = 0.8.dp.toPx(),
        )
    }
}