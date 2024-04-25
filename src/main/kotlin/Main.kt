
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState


fun main() = application {
    val icon = BitmapPainter(useResource("sample.png", ::loadImageBitmap))
    val mainWindowState = rememberWindowState()
    val secondaryWindowState = rememberWindowState()
    var showMainWindow by remember { mutableStateOf(true) }
    var showSecondWindow by remember { mutableStateOf(false) }

    if (showMainWindow) {
        MainWindow(
            { showMainWindow = false },
            icon,
            mainWindowState,
            {
                showMainWindow = false
                showSecondWindow = true
            }
        )
    }

    if (showSecondWindow) {
        SecondaryWindow(
            { showSecondWindow = false },
            icon,
            secondaryWindowState,
            {
                showMainWindow = true
                showSecondWindow = false
            }
        )
    }

    if (!showMainWindow && !showSecondWindow) {
        exitApplication()
    }
}
