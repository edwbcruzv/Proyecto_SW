package com.example.proyecto_sw.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyecto_sw.R
import com.example.proyecto_sw.screens.Appointment
import com.example.proyecto_sw.screens.Disease
import com.example.proyecto_sw.screens.DoctorListScreen
import com.example.proyecto_sw.screens.HospitalesListScreen
import com.example.proyecto_sw.screens.LobbyScreen
import com.example.proyecto_sw.screens.UserCardScreen


@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.LobbyScreen.route){
        composable(route = AppScreens.LobbyScreen.route){
            LobbyScreen(navController)
        }


        composable(route = AppScreens.DoctorListScreen.route){

            DoctorListScreen(navController)
        }


        composable(route = AppScreens.UserCardScreen.route){

            UserCardScreen(navController)
        }


        composable(route = AppScreens.HospitalesListScreen.route){

            HospitalesListScreen(navController)
        }

        /*
        composable(route = AppScreens.SecondScreen.route + "/{text}",
            arguments = listOf(navArgument(name = "text"){
                type= NavType.StringType
            })
        ){
            SecondScreen(navController, it.arguments?.getString("text"))
        }*/
    }

}
