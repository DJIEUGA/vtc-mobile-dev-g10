package components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier) {
    val items = listOf(
        BottomNavItem("Home", Icons.Default.Home),
        BottomNavItem("Bookings", Icons.Default.Star),
        BottomNavItem("Profile", Icons.Default.Person)
    )

    NavigationBar(
        modifier = modifier.fillMaxWidth(),
        containerColor = Color(0xFFFFFFFF),
        contentColor = Color(0xFF2E3A59)
    ) {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                label = { Text(text = item.title) },
                selected = item.title == "Home",
                onClick = { /* Handle navigation */ }
            )
        }
    }
}

data class BottomNavItem(val title: String, val icon: ImageVector)