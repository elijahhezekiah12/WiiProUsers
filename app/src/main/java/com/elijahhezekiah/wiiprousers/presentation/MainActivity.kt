package com.elijahhezekiah.wiiprousers.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.elijahhezekiah.wiiprousers.Screen
import com.elijahhezekiah.wiiprousers.Screen.Home
import com.elijahhezekiah.wiiprousers.UserListRoute
import com.elijahhezekiah.wiiprousers.UserRoute
import com.elijahhezekiah.wiiprousers.presentation.job_details.JobDetailsScreen
import com.elijahhezekiah.wiiprousers.presentation.ui.theme.WiiProUsersTheme
import com.elijahhezekiah.wiiprousers.presentation.user_list.UserListScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.Serializable

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(color = MaterialTheme .colorScheme.background)
            {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = UserListRoute,
                    modifier = Modifier.fillMaxSize()
                ) {
                    composable<UserListRoute> {
                        UserListScreen(
                            onUserClick = { userid ->
                                navController.navigate(UserRoute(userid))
                            }
                        )
                    }

                    composable<UserRoute>{
                        val args = it.toRoute<UserRoute>()

                        JobDetailsScreen(
                            id = args.id.toInt()
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WiiProUsersTheme {
        Greeting("Android")
    }
}

