package com.example.task_manager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.task_manager.ui.theme.Task_ManagerTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Task_ManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppPage()
                }
            }
        }
    }
}

@Composable
fun DoneLogo(modifier: Modifier = Modifier) {
    val logo = painterResource(R.drawable.ic_task_completed)
    Image(
        painter = logo,
        contentDescription = null,
        contentScale = ContentScale.None
   )
}
@Composable
fun ContentText(title: String, data : String , modifier: Modifier = Modifier) {
    Text(
        text = title,
        fontWeight = FontWeight.Bold,
//        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(
                top = 24.dp,
                bottom = 8.dp
            )
    )
    Text(
        text = data,
//        textAlign = TextAlign.Center,
        fontSize = 16.sp

    )
}

@Composable
fun AppPage(modifier: Modifier = Modifier) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DoneLogo()
        ContentText(title = stringResource(R.string.title), data = stringResource(R.string.data))
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    Task_ManagerTheme {
        AppPage()
    }
}