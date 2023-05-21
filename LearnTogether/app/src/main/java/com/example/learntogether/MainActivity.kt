package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.learntogether.ui.theme.LearnTogetherTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTogetherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   AppFun()
                }
            }
        }
    }
}

@Composable
fun TopImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
//        alpha = 0.5F
    )
}

@Composable
fun TextBody (title : String , heading : String , body : String ,modifier: Modifier = Modifier) {
    Text(
        text = title,
        fontSize = 24.sp,
        modifier = Modifier
            .padding(16.dp)
    )
    Text(
        text = heading,
        textAlign = TextAlign.Justify ,
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp
            )

    )
    Text(
        text = body,
        textAlign = TextAlign.Justify ,
        modifier = Modifier
            .padding(16.dp)

    )
}

@Composable
fun MainPage(title : String , heading : String ,  body : String ,modifier: Modifier = Modifier) {

    Column {
        TopImage()
        TextBody(title = title , heading = heading , body = body)
    }
}

@Composable
fun AppFun(){
    MainPage(
        title = stringResource(R.string.title) ,
        heading = stringResource(R.string.heading) ,
        body = stringResource(R.string.body),
    )
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    LearnTogetherTheme {
        AppFun()
    }
}