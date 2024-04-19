package com.example.finalproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalproject.ui.theme.FINALPROJECTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FINALPROJECTTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BucketListScreen("Your Name")
                }
            }
        }
    }
}

@Composable
fun BucketListScreen(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF4F5F7)) // Sand color background
            .padding(16.dp)
    ) {
        Text(
            text = name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Bucket List",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF41C2D1), // Water color for title
            modifier = Modifier.padding(bottom = 16.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FINALPROJECTTheme {
        BucketListScreen("Your Name")
    }
}
if (task.isSuccessful) {
    val intent = Intent(this, MainActivity::class.java)
    startActivity(intent)
    finish()
}
