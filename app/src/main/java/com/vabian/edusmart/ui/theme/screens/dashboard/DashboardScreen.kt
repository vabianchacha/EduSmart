package com.vabian.edusmart.ui.theme.screens.dashboard
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vabian.edusmart.R
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vabian.edusmart.navigation.ROUT_ABOUT
import com.vabian.edusmart.navigation.ROUT_CONTACT
import com.vabian.edusmart.navigation.ROUT_HOME
import com.vabian.edusmart.navigation.ROUT_INTENT
import com.vabian.edusmart.navigation.ROUT_ITEM
import com.vabian.edusmart.navigation.ROUT_MORE
import com.vabian.edusmart.navigation.ROUT_SERVICE
import com.vabian.edusmart.navigation.ROUT_START


@Composable
fun DashboardScreen(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
    ) {
        //Card
        Card(
            modifier = Modifier.fillMaxWidth().height(300.dp),
            shape = RoundedCornerShape(bottomEnd = 60.dp, bottomStart = 60.dp),
            colors = CardDefaults.cardColors(Color.Magenta)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.edulogo),
                    contentDescription = "home",
                    modifier = Modifier.width(150.dp).height(150.dp).clip(shape = RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.FillBounds
                )
                Text(
                    text = "EduSmart",
                    fontSize = 60.sp,
                    color = Color.Black,
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.ExtraBold
                )


            }

        }
        //End of card
        Spacer(modifier = Modifier.height( 40.dp))

        //Row
        Row(modifier = Modifier.padding(start = 27.dp)) {
            //Card
            Card(
                modifier = Modifier.width(150.dp).height(180.dp).clickable{
                    navController.navigate(ROUT_HOME)
                },
                elevation = CardDefaults.cardElevation(10.dp),
                colors = CardDefaults.cardColors(Color.Magenta)

            ) {
                Column(modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.img_10),
                        contentDescription = "home",
                        modifier = Modifier.width(100.dp).height(100.dp).clip(shape = RoundedCornerShape(20.dp)),
                        contentScale = ContentScale.FillBounds
                    )
                    Text(
                        text = "Home",
                        fontSize = 15.sp
                    )

                }

            }

            //End of card
            Spacer(modifier = Modifier.width( 40.dp))
            //Card
            Card(
                modifier = Modifier.width(150.dp).height(180.dp),
                elevation = CardDefaults.cardElevation(10.dp),
                colors = CardDefaults.cardColors(Color.Magenta)

            ) {
                Column(modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.img_16),
                        contentDescription = "About",
                        modifier = Modifier.width(100.dp).height(100.dp).clip(shape = RoundedCornerShape(20.dp)).clickable{
                            navController.navigate(ROUT_ABOUT)
                        },
                        contentScale = ContentScale.FillBounds
                    )
                    Text(
                        text = "About",
                        fontSize = 15.sp
                    )

                }

            }

            //End of card

        }
        //End of row
        Spacer(modifier = Modifier.height( 20.dp))
        //Row
        Row(modifier = Modifier.padding(start = 27.dp)) {
            //Card
            Card(
                modifier = Modifier.width(150.dp).height(180.dp),
                elevation = CardDefaults.cardElevation(10.dp),
                colors = CardDefaults.cardColors(Color.Magenta)

            ) {
                Column(modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.img_12),
                        contentDescription = "home",
                        modifier = Modifier.width(100.dp).height(100.dp).clip(shape = RoundedCornerShape(20.dp)).clickable{
                            navController.navigate(ROUT_START)
                        },
                        contentScale = ContentScale.FillBounds
                    )
                    Text(
                        text = "Start",
                        fontSize = 15.sp
                    )

                }

            }

            //End of card
            Spacer(modifier = Modifier.width( 40.dp))
            //Card
            Card(
                modifier = Modifier.width(150.dp).height(180.dp),
                elevation = CardDefaults.cardElevation(10.dp),
                colors = CardDefaults.cardColors(Color.Magenta)

            ) {
                Column(modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.img_11),
                        contentDescription = "home",
                        modifier = Modifier.width(100.dp).height(100.dp).clip(shape = RoundedCornerShape(20.dp)).clickable{
                            navController.navigate(ROUT_CONTACT)
                        },
                        contentScale = ContentScale.FillBounds
                    )
                    Text(
                        text = "Contact",
                        fontSize = 15.sp
                    )

                }

            }

            //End of card

        }
        //End of row
        Spacer(modifier = Modifier.height( 20.dp))
        //Row
        Row(modifier = Modifier.padding(start = 27.dp)) {
            //Card
            Card(
                modifier = Modifier.width(150.dp).height(180.dp),
                elevation = CardDefaults.cardElevation(10.dp),
                colors = CardDefaults.cardColors(Color.Magenta)

            ) {
                Column(modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.img_13),
                        contentDescription = "home",
                        modifier = Modifier.width(100.dp).height(100.dp).clip(shape = RoundedCornerShape(20.dp)).clickable{
                            navController.navigate(ROUT_MORE)
                        },
                        contentScale = ContentScale.FillBounds
                    )
                    Text(
                        text = "More",
                        fontSize = 15.sp
                    )

                }

            }

            //End of card
            Spacer(modifier = Modifier.width( 40.dp))
            //Card
            Card(
                modifier = Modifier.width(150.dp).height(180.dp),
                elevation = CardDefaults.cardElevation(10.dp),
                colors = CardDefaults.cardColors(Color.Magenta)

            ) {
                Column(modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.uniform),
                        contentDescription = "home",
                        modifier = Modifier.width(100.dp).height(100.dp).clip(shape = RoundedCornerShape(20.dp)).clickable{
                            navController.navigate(ROUT_INTENT)
                        },
                        contentScale = ContentScale.FillBounds
                    )
                    Text(
                        text = "Intents",
                        fontSize = 15.sp
                    )

                }

            }

            //End of card

        }
        //End of row
        Spacer(modifier = Modifier.height( 20.dp))
        //Row
        Row(modifier = Modifier.padding(start = 27.dp)) {
            //Card
            Card(
                modifier = Modifier.width(150.dp).height(180.dp),
                elevation = CardDefaults.cardElevation(10.dp),
                colors = CardDefaults.cardColors(Color.Magenta)

            ) {
                Column(modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.img_14),
                        contentDescription = "Item",
                        modifier = Modifier.width(100.dp).height(100.dp).clip(shape = RoundedCornerShape(20.dp)).clickable{
                            navController.navigate(ROUT_ITEM)
                        },
                        contentScale = ContentScale.FillBounds
                    )
                    Text(
                        text = "Item",
                        fontSize = 15.sp
                    )

                }

            }

            //End of card
            Spacer(modifier = Modifier.width( 40.dp))
            //Card
            Card(
                modifier = Modifier.width(150.dp).height(180.dp),
                elevation = CardDefaults.cardElevation(10.dp),
                colors = CardDefaults.cardColors(Color.Magenta)

            ) {
                Column(modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.img_17),
                        contentDescription = "home",
                        modifier = Modifier.width(100.dp).height(100.dp).clip(shape = RoundedCornerShape(20.dp)).clickable{
                            navController.navigate(ROUT_SERVICE)},
                        contentScale = ContentScale.FillBounds
                    )
                    Text(
                        text = "Services",
                        fontSize = 15.sp
                    )

                }

            }

            //End of card

        }
        //End of row
        Spacer(modifier = Modifier.height( 40.dp))

        IconButton(onClick = {
            navController.navigate(ROUT_START)

        }) {
            Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "")
        }
        Spacer(modifier = Modifier.height( 40.dp))


    }

}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview(){
    DashboardScreen(navController= rememberNavController())
}