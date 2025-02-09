package screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import components.BottomNavigationBar
import components.Car
import components.CarItem
import components.Driver
import components.DriverItem
import com.example.vtc_g10_project.R
import components.SearchBar

@Preview
@Composable
fun MainScreen() {
    val cars = remember {
        listOf(
            Car("FORD", "F-150", "108000 CFA", R.drawable.car_5),
            Car("MAZDA", "Mazda6", "50000 CFA", R.drawable.car_3),
            Car("RANGE", "ROVER", "45000 CFA", R.drawable.car_4),
            Car("TOYOTA", "CAMRY", "35000 CFA", R.drawable.car_1)
        )
    }

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
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 4.dp),
                modifier = Modifier.fillMaxWidth().heightIn()
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