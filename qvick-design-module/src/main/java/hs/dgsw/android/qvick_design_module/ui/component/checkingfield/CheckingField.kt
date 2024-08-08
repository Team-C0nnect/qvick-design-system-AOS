package hs.dgsw.android.qvick_design_module.ui.component.checkingfield

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hs.dgsw.android.qvick_design_module.ui.component.button.Button12
import hs.dgsw.android.qvick_design_module.ui.foundation.IcNavigate_next
import hs.dgsw.android.qvick_design_module.ui.theme.common100
import hs.dgsw.android.qvick_design_module.ui.theme.opacity0
import hs.dgsw.android.qvick_design_module.ui.theme.pretendard
import hs.dgsw.android.qvick_design_module.ui.theme.statusDestructive
import hs.dgsw.android.qvick_design_module.ui.theme.statusPositive

// 만약 출석체크가 안 됬있다면, 빈 스트링 넣으시면 됨니다.
@Composable
fun CheckingField(
    modifier: Modifier = Modifier,
    isChecked: Boolean = false,
    toDayDate: String = "2024.05.24",
    checkingTime: MutableState<String> = mutableStateOf<String>(""),
    checking: () -> Unit = {},
) {
    val buttonText: MutableState<String> = remember { mutableStateOf<String>("출석체크 미완료") }
    Surface(
        modifier = modifier
            .padding(horizontal = 30.dp)

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = opacity0)
                .padding(vertical = 20.dp, horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Box() {
                if (isChecked) {
                    Button12(
                        modifier = Modifier
                            .height(height = 48.dp)
                            .fillMaxWidth(),
                        text = buttonText.value,
                        enabled = true,
                        tint = statusPositive
                    ) {

                    }
                } else {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Button12(
                            modifier = Modifier
                                .height(height = 48.dp)
                                .width(207.dp),
                            text = buttonText.value,
                            enabled = true,
                            tint = statusDestructive
                        ) {
                            checking()
                        }

                        Box(
                            modifier = modifier
                                .padding(all = 4.dp),

                            ) {
                            IcNavigate_next(
                                contentDescription = "", modifier = Modifier
                                    .size(48.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(color = common100)
                            )
                        }

                    }
                }

            }
            Box(modifier = Modifier.padding(top = 16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp, horizontal = 11.5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = toDayDate,
                    fontSize = 16.sp,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Medium
                    )
                Text(
                    text = checkingTime.value,
                    color = statusPositive,
                    fontSize = 24.sp,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.SemiBold
                )

            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun Test() {
    CheckingField()
}