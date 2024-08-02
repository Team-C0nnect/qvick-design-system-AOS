package hs.dgsw.android.qvick_design_system_aos.ui.theme

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import hs.dgsw.android.qvick_design_system_aos.R

@Composable
fun IcNotifications(
    contentDescription : String?,
    tint : Color = common0
){
    Icon(
        painter = painterResource(id = R.drawable.ic_notifications),
        contentDescription = contentDescription,
        tint = tint
    )
}