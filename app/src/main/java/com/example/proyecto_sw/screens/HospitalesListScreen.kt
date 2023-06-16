package com.example.proyecto_sw.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyecto_sw.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HospitalesListScreen( hospitals: List<Hospital>) {
    val searchQuery = remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Lista de Hospitales") },
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
                for (hospital in hospitals) {
                    HospitalItem(hospital)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    )
}

@Composable
fun HospitalItem(hospital: Hospital) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = hospital.image),
            contentDescription = "Logo del hospital",
            modifier = Modifier.size(80.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = "Nombre: ${hospital.name}")
            Text(text = "Tipo: ${hospital.type}")
            Text(text = "Horario: ${hospital.schedule}")
            Text(text = "Descripción: ${hospital.description}")
            Text(text = "Ubicación: ${hospital.location}")
        }
    }
}

data class Hospital(
    val name: String,
    val type: String,
    val schedule: String,
    val description: String,
    val location: String,
    val image: Int
)

val hospitals = listOf(
    Hospital(
        name = "Hospital ABC",
        type = "General",
        schedule = "Lun - Vie: 8am - 6pm",
        description = "Hospital de atención general",
        location = "Calle Principal 123",
        image = R.drawable.imagen_hospital1
    ),
    Hospital(
        name = "Hospital XYZ",
        type = "Pediatría",
        schedule = "Lun - Dom: 24 horas",
        description = "Hospital especializado en atención pediátrica",
        location = "Avenida Secundaria 456",
        image = R.drawable.imagen_hospital2
    )
    // Agrega más objetos Hospital según necesites
)

@Preview(showBackground = true)
@Composable
fun HospitalesListScreenPreview(){
    HospitalesListScreen(hospitals = hospitals)
}