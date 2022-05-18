package com.example.topappbarissue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.topappbarissue.ui.theme.TopAppBarIssueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopAppBarIssueTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    HomeScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(topBar = { HomeTopAppBar() }, modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text("Home Screen")

        }
    }
}

@Composable
private fun HomeTopAppBar() {
    //TODO Setting title tint color to Color.Unspecified causes title to appear on both rows of the top bar
    //TODO Not overriding the title tint color causes the icon to appear in black and white
    val colors = TopAppBarDefaults.largeTopAppBarColors(titleContentColor = Color.Unspecified)

    MediumTopAppBar(
        title = {
            Row {
                Icon(painter = painterResource(R.drawable.ic_google), contentDescription = null)
                Text("Home Top Bar", modifier = Modifier.padding(start = 8.dp))
            }
        },
        colors = colors
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TopAppBarIssueTheme {
        HomeScreen()
    }
}