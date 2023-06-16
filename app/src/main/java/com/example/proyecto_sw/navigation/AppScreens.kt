package com.example.proyecto_sw.navigation

sealed class AppScreens(val route:String){
    object DoctorListScreen: AppScreens("doctor_list_screen")
    object HospitalesListScreen: AppScreens("hospitales_list_screen")
    object LobbyScreen: AppScreens("lobby_screen")
    object UserCardScreen: AppScreens("user_card_screen")
}