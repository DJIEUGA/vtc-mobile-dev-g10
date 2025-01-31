package screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import components.BottomNavigationBar
import components.Car
import components.CarItem
import components.Driver
import components.DriverItem
import com.example.vtc_g10_project.R
import components.SearchBar

@Composable
fun MainScreen() {
    val cars = listOf(
        Car("FORD", "Sedan", "$50/day", R.drawable.car_1),
        Car("MAZDA", "SUV", "$70/day", R.drawable.car_2),
        Car("Tesla Model 3", "Electric", "$100/day", R.drawable.car_3)
    )

    val drivers = listOf(
        Driver("John Doe", "4.8/5", R.drawable.driver_1),
        Driver("Jane Smith", "4.9/5", R.drawable.driver_2),
        Driver("Mike Johnson", "4.7/5", R.drawable.driver_3)
    )

    // Use a Box to overlay the BottomNavigationBar at the bottom
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Heading above the Search Bar
            Text(
                text = "Welcome to VTC Rentals",
                style = MaterialTheme.typography.headlineMedium,
                color = Color(0xFF2E3A59),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Beautified Search Bar
            SearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            // Hot Deals Section
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Hot Deals",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color(0xFF2E3A59)
                )
                TextButton(onClick = { /* Handle View All */ }) {
                    Text(
                        text = "View All",
                        color = Color(0xFF4CAF50)
                    )
                }
            }

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(cars) { car ->
                    CarItem(car = car)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Top Drivers Section
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Top Drivers",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color(0xFF2E3A59)
                )
                TextButton(onClick = { /* Handle View All */ }) {
                    Text(
                        text = "View All",
                        color = Color(0xFF4CAF50)
                    )
                }
            }

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(drivers) { driver ->
                    DriverItem(driver = driver)
                }
            }
        }

        // Bottom Navigation Bar
        BottomNavigationBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}