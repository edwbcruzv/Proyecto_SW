package com.example.proyecto_sw.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserCardScreen(user: User) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Carnet del Usuario") }
            )
        },
        content = {
            LazyColumn(
                modifier = Modifier.padding(16.dp)
            ) {
                item {
                    Spacer(modifier = Modifier.height(60.dp))
                }
                item {
                    Text(text = "Datos Personales:")
                    Text(text = "Nombre: ${user.name}")
                    Text(text = "Edad: ${user.age}")
                    Text(text = "Dirección: ${user.address}")
                    Text(text = "Teléfono: ${user.phone}")
                    Spacer(modifier = Modifier.height(16.dp))

                }

                item {
                    Text(text = "Datos de Salud:")
                    Text(text = "Tipo de Sangre: ${user.bloodType}")
                    Text(text = "Alergias: ${user.allergies.joinToString(", ")}")
                    Text(text = "Enfermedades Crónicas: ${user.chronicDiseases.joinToString(", ")}")
                    Spacer(modifier = Modifier.height(16.dp))
                }

                item {
                    Text(text = "Citas Médicas:")
                    if (user.appointments.isNotEmpty()) {
                        for (appointment in user.appointments) {
                            Text(text = "Fecha: ${appointment.date}")
                            Text(text = "Doctor: ${appointment.doctor}")
                            Text(text = "Especialidad: ${appointment.specialty}")
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    } else {
                        Text(text = "No hay citas médicas registradas.")
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }

                item {
                    Text(text = "Enfermedades:")
                    if (user.diseases.isNotEmpty()) {
                        for (disease in user.diseases) {
                            Text(text = "- ${disease.name}")
                            Text(text = "  Síntomas: ${disease.symptoms.joinToString(", ")}")
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    } else {
                        Text(text = "No hay enfermedades registradas.")
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
                item {
                    Button(onClick = { /* Acción al hacer clic en el botón */ }) {
                        Text(text = "Imprimir Carnet")
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    )
}

data class User(
    val name: String,
    val age: Int,
    val address: String,
    val phone: String,
    val bloodType: String,
    val allergies: List<String>,
    val chronicDiseases: List<String>,
    val appointments: List<Appointment>,
    val diseases: List<Disease>
)

data class Appointment(
    val date: String,
    val doctor: String,
    val specialty: String
)

data class Disease(
    val name: String,
    val symptoms: List<String>
)

val user = User(
    name = "Juan Pérez",
    age = 30,
    address = "Calle Principal 123",
    phone = "123-456-7890",
    bloodType = "A+",
    allergies = listOf("Polen", "Mariscos"),
    chronicDiseases = listOf("Diabetes", "Hipertensión"),
    appointments = listOf(
        Appointment(date = "2023-06-15", doctor = "Dr. García", specialty = "Cardiología"),
        Appointment(date = "2023-06-20", doctor = "Dra. López", specialty = "Dermatología")
    ),
    diseases = listOf(
        Disease(name = "Gripe", symptoms = listOf("Fiebre", "Congestión nasal")),
        Disease(name = "Dolor de cabeza", symptoms = listOf("Dolor intenso", "Mareos"))
    )
)

@Preview(showBackground = true)
@Composable
fun UserCardPreview(){
    UserCardScreen(user = user)
}