package com.example.proyecto_sw.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoctorListScreen(navController: NavController, doctors: List<Doctor>) {
    val searchQuery = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Lista de Médicos") },
                actions = {
                    TextField(
                        value = searchQuery.value,
                        onValueChange = { searchQuery.value = it },
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .fillMaxWidth(0.5f),
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                        keyboardActions = KeyboardActions(onSearch = {}),
                        placeholder = { Text(text = "Buscar") },
                        colors = TextFieldDefaults.textFieldColors(MaterialTheme.colorScheme.surface)
                    )
                }
            )
        },
        content = {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Spacer(modifier = Modifier.height(60.dp))
                for (doctor in doctors) {
                    DoctorItem(doctor)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }

    )
}

@Composable
fun DoctorItem(doctor: Doctor) {
    Column {
        Text(text = "Nombre: ${doctor.name}")
        Text(text = "Centro de Salud: ${doctor.healthCenter}")
        Text(text = "Horario de Atención: ${doctor.schedule}")
        Text(text = "Contacto: ${doctor.contact}")
    }
}

data class Doctor(
    val name: String,
    val healthCenter: String,
    val schedule: String,
    val contact: String
)

val doctors = listOf(
    Doctor(
        name = "Dr. Juan Pérez",
        healthCenter = "Centro Médico ABC",
        schedule = "Lun - Vie: 9am - 5pm",
        contact = "Teléfono: 123-456-7890"
    ),
    Doctor(
        name = "Dra. María González",
        healthCenter = "Hospital XYZ",
        schedule = "Lun - Sab: 8am - 8pm",
        contact = "Teléfono: 987-654-3210"
    ),
    // Agrega más objetos Doctor según necesites
)

@Preview(showBackground = true)
@Composable
fun DoctorListScreenPreview(){
    DoctorListScreen(doctors = doctors)
}