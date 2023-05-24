package com.example.people

//import androidx.compose.foundation.layout.RowScopeInstance.weight
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.people.ui.theme.PeopleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PeopleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PeopleList()
                }
            }
        }
    }
}

@Composable
fun PeopleName(name: String, body : String ,modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFF242526))
            .padding(16.dp),
    ) {
        Text(
            text = name,
            fontWeight = FontWeight.W900,

            color = Color.White,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()

        )
        Text(
            text = body,
            color = Color.White,
            fontWeight = FontWeight.Light,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
@Composable
fun PeopleText(name: String, body : String , active : String , modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier

        )
        Text(
            text = active,
            color = Color.White,
            fontSize = 12.sp,
            modifier = Modifier
        )
        Text(
            text = body,
            color = Color.White,
            modifier = Modifier
                .offset(x = -24 .dp, y = 12.dp)

        )
    }
}

@Composable
fun PeopleImage(modifier: Modifier = Modifier){

    Image(
        painter = painterResource(R.drawable.shishir),
        contentDescription = null,
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)

    )
}

@Composable
fun PeopleList(modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .background(Color(0xFF242526))) {
            PeopleName(
                name = stringResource(R.string.arafat_name),
                body = stringResource(R.string.arafat_mssg),
                modifier = modifier.background(Color(0xFFBEBEC9))
            )
            PeopleName(
                name = stringResource(R.string.mohahammad_sheakh),
                body = stringResource(R.string.ethics_er_grade)
            )
            PeopleName(
                name = stringResource(R.string.md_takib_udding_sarker),
                body = stringResource(R.string.good_job)
            )
            PeopleName(
                name = stringResource(R.string.sk_linkon),
                body = stringResource(R.string.taka_paisis)
            )
            PeopleName(
                name = stringResource(R.string.ammu),
                body = stringResource(R.string.kokhn_asbi)
            )
            PeopleName(
                name = stringResource(R.string.roni),
                body = stringResource(R.string.lo_ajka_jai)
            )
        }
        Row(modifier = Modifier.weight(1f).background(Color(0xFF2A2A2B)).padding(16.dp)) {

            PeopleImage(modifier = Modifier
                .weight(1f)
                .offset(x = (-16).dp, y = 0.dp))
            PeopleText(
                name = stringResource(R.string.arafat_name),
                body = stringResource(R.string.ki_koro),
                active = stringResource(R.string.active_an_hour_ago),
                modifier = Modifier
//                    .padding(top=20.dp)
                    .weight(1f)
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    PeopleTheme {
        PeopleList()
    }
}