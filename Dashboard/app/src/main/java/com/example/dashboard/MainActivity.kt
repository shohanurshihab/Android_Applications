package com.example.dashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dashboard.ui.theme.DashboardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DashboardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DashBoard()
                }
            }
        }
    }
}

@Composable
fun UpperPart(text1: String, text2: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 30.dp, top = 70.dp, bottom = 40.dp)
    ) {
        Text(
            text = text1,
            fontSize = 25.sp,
            fontWeight = FontWeight.Black,
            color = Color.White,
            modifier = modifier,
            fontFamily = FontFamily.Monospace
        )
        Text(
            text = text2,
            fontSize = 13.sp,
//            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = modifier
                .padding(start = 2.dp)
                .offset(y=-6.dp)
        )
    }
}

@Composable
fun IconPart(iconText : String , iconSrc : Int , modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(Color(0xFFFFFFFF), shape = RoundedCornerShape(20.dp))
            .fillMaxSize()
    ) {
        val image =  painterResource(iconSrc)
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
        )
        Text(
            text = iconText,
            fontWeight = FontWeight.Thin,
            modifier = Modifier

        )
    }
}

@Composable
fun DashBoard(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth().background(Color(0xFF2E0098))) {
        UpperPart(text1 = "Dashboard", text2 = "Last Update 25 Feb 2020", modifier = modifier.weight(1f))

        Column(
            modifier = modifier
                .background(Color(0xFFF0F4FE), shape = RoundedCornerShape(topStart=40.dp,topEnd = 40.dp))
                .weight(3f)
                .padding(top=10.dp,bottom = 40.dp)

        ) {
            Row(
                modifier = modifier
                    .weight(1f)
                    .padding(top=30.dp,start=30.dp)

            ) {
                IconPart(iconText = "My Account", iconSrc = R.drawable.my_account , modifier = Modifier.weight(3f).padding(end=30.dp,))
                IconPart(iconText = "Inverntory", iconSrc = R.drawable.inventory , modifier = Modifier.weight(3f).padding(end=30.dp))
            }
            Row(
                modifier = modifier
                    .weight(1f)
                    .padding(start=30.dp,top=30.dp)
            ) {
                IconPart(iconText = "Search Mechanic", iconSrc = R.drawable.search_mech , modifier = Modifier.weight(3f).padding(end=30.dp))
                IconPart(iconText = "Request", iconSrc = R.drawable.req , modifier = Modifier.weight(3f).padding(end=30.dp))
            }
            Row(
                modifier = modifier
                    .weight(1f)
                    .padding(start=30.dp,top=30.dp)
            ) {
                IconPart(iconText = "Analytics", iconSrc = R.drawable.analytics , modifier = Modifier.weight(3f).padding(end = 30.dp))
                IconPart(iconText = "Contact us", iconSrc = R.drawable.contact , modifier = Modifier.weight(3f).padding(end = 30.dp))
            }
        }

    }
}



@Preview(
    showBackground = true,
    showSystemUi = true
    )
@Composable
fun DashboardPreview() {
    DashboardTheme {
    DashBoard()
    }
}