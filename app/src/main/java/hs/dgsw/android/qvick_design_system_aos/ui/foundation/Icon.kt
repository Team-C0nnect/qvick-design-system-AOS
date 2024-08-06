package hs.dgsw.android.qvick_design_system_aos.ui.foundation

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import hs.dgsw.android.qvick_design_system_aos.R
import hs.dgsw.android.qvick_design_system_aos.ui.theme.common0

@Composable
fun IcAccount(
    contentDescription: String?,
    tint: Color = common0,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_account),
        contentDescription = contentDescription,
        tint = tint
    )
}

@Composable
fun IcEdit(
    contentDescription: String?,
    tint: Color = common0,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_edit),
        contentDescription = contentDescription,
        tint = tint
    )
}

@Composable
fun IcHome(
    contentDescription: String?,
    tint: Color = common0,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_home),
        contentDescription = contentDescription,
        tint = tint
    )
}

@Composable
fun IcNavigate_before(
    contentDescription: String?,
    tint: Color = common0,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_navigate_before),
        contentDescription = contentDescription,
        tint = tint
    )
}

@Composable
fun IcNavigate_next(
    contentDescription: String?,
    tint: Color = common0,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_navigate_next),
        contentDescription = contentDescription,
        tint = tint
    )
}

@Composable
fun IcNone(
    contentDescription: String?,
    tint: Color = common0,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_none),
        contentDescription = contentDescription,
        tint = tint
    )
}

@Composable
fun IcNotifications(
    contentDescription: String?,
    tint: Color = common0,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_notifications),
        contentDescription = contentDescription,
        tint = tint
    )
}

@Composable
fun IcPerson(
    contentDescription: String?,
    tint: Color = common0,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_person),
        contentDescription = contentDescription,
        tint = tint
    )
}