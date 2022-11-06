package com.example.gymeventcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gymeventcompose.ui.Gym
import com.example.gymeventcompose.ui.ListOfGyms
import com.example.gymeventcompose.ui.theme.GymEventComposeTheme
import com.example.gymeventcompose.ui.theme.Purple200

@Composable
fun GymScreen() {
 // hna ana 3ayz azhr kol el screens
    val vm : GymsVIewModel = viewModel()
    LazyColumn(){

       items(vm.getGyms()){
           GymItem(it)
       }
    }

  /*  Column(Modifier.verticalScroll(rememberScrollState())) {
        ListOfGyms.forEach{// lhly 3la kol el lists ele 3ndk
            GymItem(it)
        }
    }*/

}

@Composable
fun GymItem(gym: Gym) {
    Card(elevation = 4.dp, modifier = Modifier.padding(8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
            GymIcon(
                Icons.Filled.Place,
                Modifier,
                Modifier.weight(0.15f)
            ) // hna da m3nah anha hta5od 15% mn el screen
            GymDetails(
                gym, Modifier.weight(0.85f)
            )

        }
    }
}

@Composable
fun GymDetails(gym: Gym, weight: Modifier) {
    Column(modifier = weight) { // dah 3l4an a2olo anta hta5od 7agm 2ad eh mn el 4a4a
        Text(
            text = gym.name, style = MaterialTheme.typography.h2, color = Purple200,
            fontSize = 20.sp,
        )
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = gym.place,
                style = MaterialTheme.typography.body2
            )
        }
    }


}


@Composable
fun GymIcon(vector: ImageVector, modifier: Modifier, weight: Modifier) {
    Image(
        imageVector = vector,
        contentDescription = "Image Icon",
        modifier = modifier,
        colorFilter = ColorFilter.tint(
            Color.DarkGray
        )
    )
}

@Preview(showBackground = true)
@Composable
fun _GymScreeenPreviw() {
    GymEventComposeTheme {
        GymScreen()
    }
}
