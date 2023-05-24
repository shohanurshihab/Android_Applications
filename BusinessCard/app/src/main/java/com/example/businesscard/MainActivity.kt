package com.example.businesscard

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.node.modifierElementOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun MiddlePart(name: String, title: String , modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()

    ) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = "android logo",
            modifier = modifier
                .size(130.dp)
                .background(Color(0xFF073042))
        )
        Text(
            text = name,
            color = Color(0xFF000000),
            fontWeight = FontWeight.Light,
            fontSize = 50.sp,
            modifier = modifier
        )
        Text(
            text = title,
            color = Color(0xFF09713E),
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp,
            modifier = modifier
        )
    }
}

@Composable
fun BottomPart(text: String, image: Int, modifier: Modifier = Modifier){
    val image = painterResource(image)
    Row{
        Image(
            painter = image,
            contentDescription = "phone number",
            colorFilter = ColorFilter.tint(Color(0xFF006D3B)),
            modifier = modifier
                .size(25.dp)
        )
        Spacer(modifier = Modifier.width(25.dp))
        Text(
            text = text,
            color = Color(0xFF000000),
            fontSize = 17.sp
        )
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .background(Color(0xFFD1E7D3))
    ) {
        Box(
            modifier = modifier
                .weight(4f)

        ){
            MiddlePart(name = "Jennifer Doe", title = stringResource(R.string.title), modifier = modifier.padding(top=0.dp) )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .weight(1f)
                .fillMaxSize()
        ) {
            Column() {
                BottomPart(
                    text = "+11 (123) 444 555 666",
                    image = R.drawable.call_fill0_wght400_grad0_opsz48,
                )
                Spacer(modifier = Modifier.height(10.dp))
                BottomPart(
                    text = "@AndroidDev",
                    image = R.drawable.share_fill0_wght400_grad0_opsz48
                )
                Spacer(modifier = Modifier.height(10.dp))
                BottomPart(
                    text = "jen.doe@android.com",
                    image = R.drawable.chat_fill0_wght400_grad0_opsz48
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
    BusinessCard()
    }
}