package Screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun menu() {

    var context = LocalContext.current

    var banda1 by remember { mutableStateOf<String?>(null) }
    var isExpanded by remember { mutableStateOf(false) }



    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = !isExpanded } // Alterna el estado expandido
        ) {
            TextField(
                value = banda1 ?: "Valor banda 1", // Valor por defecto o el valor de banda1
                onValueChange = {},
                readOnly = true, // Solo lectura
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(isExpanded) }, // Ícono desplegable
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }
            ) {
                // Opción 1: Negro - 0
                DropdownMenuItem(
                    text = {
                        Row {
                            Box(
                                modifier = Modifier
                                    .size(24.dp)
                                    .background(Color.Black)
                            )
                            Text("  Negro - 0") // Texto de la opción
                        }
                    },
                    onClick = {
                        banda1 = "0" // Valor para banda1
                        isExpanded = false // Cierra el menú
                        Toast.makeText(context, "SELECCIONO OPCION 1", Toast.LENGTH_SHORT).show()
                    }
                )
                // Opción 1: Negro - 0
                DropdownMenuItem(
                    text = {
                        Row {
                            Box(
                                modifier = Modifier
                                    .size(24.dp)
                                    .background(Color.Blue)
                            )
                            Text("  Azul - 2") // Texto de la opción
                        }
                    },
                    onClick = {
                        banda1 = "2" // Valor para banda1
                        isExpanded = false // Cierra el menú
                    }
                )


            }
        }
    }
}