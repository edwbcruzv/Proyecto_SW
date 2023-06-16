package com.example.proyecto_sw.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyecto_sw.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LobbyScreen() {
    val isMenuOpen = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Lobby") },
                navigationIcon = {
                    IconButton(onClick = { isMenuOpen.value = !isMenuOpen.value }) {
                        Icon(
                            imageVector = if (isMenuOpen.value) Icons.Filled.Close else Icons.Filled.Menu,
                            contentDescription = "Menú"
                        )
                    }
                }
            )
        },
        drawerContent = {
            DrawerContent()
        },


        content = {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                GridItems()
            }
        },


        floatingActionButton = { Emergencia()},
        floatingActionButtonPosition = androidx.compose.material.FabPosition.End

    )
}

@Composable
fun Emergencia(){
    val context = LocalContext.current
    FloatingActionButton(onClick = {
        Toast.makeText(context, "Emergencia", Toast.LENGTH_SHORT).show()
    }) {
        Text(text = "XX")
    }
}


@Composable
fun DrawerContent() {
    Column(modifier = Modifier.padding(start = 16.dp, top = 16.dp)) {
        Text(text = "Menú")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Configuración")
        Text(text = "Cerrar Sesión")
    }
}

@Composable
fun GridItems() {
    val items = listOf(
        "Citas Médicas",
        "Consejos",
        "Doctores",
        "Alimentación",
        "Medicamentos",
        "Actividad Física",
        "Salud Mental",
        "Centros de Salud",
        "Enfermedades"
    )

    val columns = 2

    val rows = items.size / columns + if (items.size % columns > 0) 1 else 0
    //Spacer(modifier = Modifier.height(35.dp))
    for (row in 0 until rows) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
            ) {
            for (column in 0 until columns) {
                val index = row * columns + column
                if (index < items.size) {
                    val item = items[index]
                    GridItem(text = item)
                } else {
                    Spacer(modifier = Modifier.weight(5f))
                }
            }
        }
    }
}

@Composable
fun GridItem(text: String) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .clickable { /* Acción al hacer clic en el item */ }
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Ícono",
            modifier = Modifier.size(150.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = text,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.align(Alignment.CenterHorizontally))
    }
}

@Preview(showBackground = true)
@Composable
fun LobbyScreenPreview(){
    LobbyScreen()
}