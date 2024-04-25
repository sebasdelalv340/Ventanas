import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState


@Composable
fun MainWindow(
    onCloseMainWindowRequest: () -> Unit,
   icon: BitmapPainter,
   mainWindowState: WindowState,
   onClickShow: () -> Unit)
{
    Window(
        onCloseRequest = onCloseMainWindowRequest,  // Cierra la aplicación cuando esta ventana se cierra
        title = "Ventana Principal",
        icon = icon,
        state = mainWindowState
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(100.dp, Alignment.CenterVertically)
        ) {
            Text("Ventana principal")
            Button(
                onClick = onClickShow
            ) {
                Text("Abrir Ventana Secundaria y cerrar esta")
            }
        }
    }
}

