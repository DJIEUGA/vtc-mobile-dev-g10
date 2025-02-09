package com.example.vtc_g10_project

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment


data class Car(
    val brand: String,
    val model: String,
    val pricePerDay: Int,
    val imageRes: Int
)

@Preview
@Composable
fun CarBrowseScreen() {
    var searchQuery by remember { mutableStateOf("") }

    val cars = remember {
        listOf(
            Car("FORD", "F-150", 390, R.drawable.car_5),
            Car("MAZDA", "Mazda6", 400, R.drawable.car_3),
            Car("RANGE", "ROVER", 450, R.drawable.car_4),
            Car("TOYOTA", "CAMRY", 350, R.drawable.car_1)
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(16.dp)
    ) {
        Text(
            text = "Browse cars",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        SearchBar(
            searchQuery = searchQuery,
            onSearchQueryChange = { searchQuery = it },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(cars) { car ->
                CarCard(car = car)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = searchQuery,
        onValueChange = onSearchQueryChange,
        modifier = modifier
            .clip(RoundedCornerShape(8.dp)),
        placeholder = { Text("Search") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search"
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.White,
            unfocusedBorderColor = Color.LightGray
        ),
        singleLine = true
    )
}

@Composable
fun CarCard(car: Car) {
    Card(
        modifier = Modifier
            .wrapContentSize(),
        shape = RoundedCornerShape(25.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF2196F3))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 0.dp, top = 16.dp, end = 0.dp, bottom = 0.dp)
        ) {
            Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, top = 15.dp, end = 10.dp, bottom = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = car.brand,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = car.model,
                    color = Color.White
                )
            }
            Text(
                text = "${car.pricePerDay}/day",
                color = Color.White
            )
        }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically){
                Column {
                    Image(
                        painter = painterResource(id = car.imageRes),
                        contentDescription = "${car.brand} ${car.model}",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp),
                        contentScale = ContentScale.Fit
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.displayCutoutPadding()
            ) {
                TextButton(
                    onClick = { },
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = Color.White
                    )
                ) {
                    Text("Details", color = Color.White,fontSize = 10.sp, fontWeight = FontWeight.Bold)
                }

                Button(
                    onClick = {  },
                    shape = RoundedCornerShape(
                        topStart = 16.dp,  // Top-left corner
                        topEnd = 0.dp,     // Top-right corner
                        bottomEnd = 16.dp, // Bottom-right corner
                        bottomStart = 0.dp  // Bottom-left corner
                    ),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF33333A)),
                    modifier = Modifier
                        .clip(RoundedCornerShape(
                            topStart = 16.dp,  // Top-left corner
                            topEnd = 0.dp,     // Top-right corner
                            bottomEnd = 16.dp, // Bottom-right corner
                            bottomStart = 0.dp  // Bottom-left corner
                        ))
                        .padding(2.dp)
                        .align(Alignment.Top)

                ) {
                        Text("Rent\nNow", color = Color.White, fontSize = 12.sp)
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = "Arrow",
                            tint = Color.White,
                            modifier = Modifier.width(102.dp)

                        )
                }
            }
        }
    }
}