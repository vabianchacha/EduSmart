package com.vabian.edusmart.ui.theme.screens.item

import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.vabian.edusmart.R
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vabian.edusmart.navigation.ROUT_INTENT


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemScreen(navController: NavController){

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        //Top app bar
        TopAppBar(
            title = { Text(text = "Item") },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Magenta,
                titleContentColor = Color.White,
                navigationIconContentColor = Color.White,
                actionIconContentColor = Color.White

            ),
            //Display om the left
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                }
            },
            //Display on the right
            actions = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "")
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.Notifications, contentDescription = "")
                }
                IconButton(onClick = {
                    navController.navigate(ROUT_INTENT)

                }) {
                    Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "")
                }
            },




        )
        //End of top app bar


       Column (modifier = Modifier.verticalScroll(rememberScrollState())){
           Image(
               painter = painterResource(R.drawable.uniform1),
               contentDescription = "Home",
               modifier = Modifier.fillMaxWidth().height(400.dp),
               contentScale = ContentScale.FillWidth
           )

           Spacer(modifier = Modifier.height(20.dp))
           //SearchBar
           var search by remember { mutableStateOf("") }
           OutlinedTextField(
               value = search,
               onValueChange = {search=it},
               modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp),
               leadingIcon = {Icon(imageVector = Icons.Default.Search, contentDescription = "")},
               placeholder = {Text(text = "Search...")}
           )
           //End of searchBar

           //Row
           Row (modifier = Modifier.padding(start = 20.dp, top = 10.dp)){
               Image(
                   painter = painterResource(R.drawable.track),
                   contentDescription = "home",
                   modifier = Modifier.width(200.dp).height(200.dp).clip(shape = RoundedCornerShape(20.dp)),
                   contentScale = ContentScale.FillWidth
               )

               Spacer(modifier = Modifier.padding(start = 20.dp))
               Column (){
                   Text(
                       text = "Men's Coat",
                       fontWeight = FontWeight.ExtraBold,
                       fontSize = 15.sp
                   )
                   Text(
                       text = "Casual wear",
                       fontWeight = FontWeight.ExtraBold,
                       fontSize = 15.sp
                   )
                   Text(
                       text = "Ksh.1900",
                       textDecoration = TextDecoration.LineThrough,
                       fontSize = 15.sp
                   )
                   Text(
                       text = "Ksh.1500",
                       fontSize = 15.sp
                   )
                   Row {
                       Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Magenta)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Magenta)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Magenta)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Magenta)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Magenta)

                   }
               }

           }

           //End of Row
           //Row
           Row (modifier = Modifier.padding(start = 20.dp, top = 10.dp)){
               Image(
                   painter = painterResource(R.drawable.uniform),
                   contentDescription = "home",
                   modifier = Modifier.width(200.dp).height(200.dp).clip(shape = RoundedCornerShape(20.dp)),
                   contentScale = ContentScale.FillWidth
               )

               Spacer(modifier = Modifier.padding(start = 20.dp))
               Column (){
                   Text(
                       text = "Class Equipments",
                       fontWeight = FontWeight.ExtraBold,
                       fontSize = 15.sp
                   )
                   Text(
                       text = "Books",
                       fontWeight = FontWeight.ExtraBold,
                       fontSize = 15.sp
                   )
                   Text(
                       text = "Ksh.1900",
                       textDecoration = TextDecoration.LineThrough,
                       fontSize = 15.sp
                   )
                   Text(
                       text = "Ksh.1500",
                       fontSize = 15.sp
                   )
                   Row {
                       Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Magenta)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Magenta)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Magenta)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Magenta)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Magenta)

                   }
               }

           }

           //End of Row
           //Row
           Row (modifier = Modifier.padding(start = 20.dp, top = 10.dp)){
               Image(
                   painter = painterResource(R.drawable.img_1),
                   contentDescription = "home",
                   modifier = Modifier.width(200.dp).height(200.dp).clip(shape = RoundedCornerShape(20.dp)),
                   contentScale = ContentScale.FillWidth
               )

               Spacer(modifier = Modifier.padding(start = 20.dp))
               Column (){
                   Text(
                       text = "Basic Needs",
                       fontWeight = FontWeight.ExtraBold,
                       fontSize = 15.sp
                   )
                   Text(
                       text = "plate",
                       fontWeight = FontWeight.ExtraBold,
                       fontSize = 15.sp
                   )
                   Text(
                       text = "Ksh.1900",
                       textDecoration = TextDecoration.LineThrough,
                       fontSize = 15.sp
                   )
                   Text(
                       text = "Ksh.1500",
                       fontSize = 15.sp
                   )
                   Row {
                       Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Magenta)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Magenta)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Magenta)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Magenta)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Magenta)

                   }
               }

           }

           //End of Row
           //Row
           Row (modifier = Modifier.padding(start = 20.dp, top = 10.dp)){
               Image(
                   painter = painterResource(R.drawable.img_1),
                   contentDescription = "home",
                   modifier = Modifier.width(200.dp).height(200.dp).clip(shape = RoundedCornerShape(20.dp)),
                   contentScale = ContentScale.FillWidth
               )

               Spacer(modifier = Modifier.padding(start = 20.dp))
               Column (){
                   Text(
                       text = "Dormitory Needs",
                       fontWeight = FontWeight.ExtraBold,
                       fontSize = 15.sp
                   )
                   Text(
                       text = "matres",
                       fontWeight = FontWeight.ExtraBold,
                       fontSize = 15.sp
                   )
                   Text(
                       text = "Ksh.1900",
                       textDecoration = TextDecoration.LineThrough,
                       fontSize = 15.sp
                   )
                   Text(
                       text = "Ksh.1500",
                       fontSize = 15.sp
                   )
                   Row {
                       Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Magenta)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Magenta)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Magenta)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Magenta)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Magenta)

                   }
               }

           }

           //End of Row
           //Row
           Row (modifier = Modifier.padding(start = 20.dp, top = 10.dp)){
               Image(
                   painter = painterResource(R.drawable.img_1),
                   contentDescription = "home",
                   modifier = Modifier.width(200.dp).height(200.dp).clip(shape = RoundedCornerShape(20.dp)),
                   contentScale = ContentScale.FillWidth
               )

               Spacer(modifier = Modifier.padding(start = 20.dp))
               Column (){
                   Text(
                       text = "Men's Coat",
                       fontWeight = FontWeight.ExtraBold,
                       fontSize = 15.sp
                   )
                   Text(
                       text = "Casual wear",
                       fontWeight = FontWeight.ExtraBold,
                       fontSize = 15.sp
                   )
                   Text(
                       text = "Ksh.1900",
                       textDecoration = TextDecoration.LineThrough,
                       fontSize = 15.sp
                   )
                   Text(
                       text = "Ksh.1500",
                       fontSize = 15.sp
                   )
                   Row {
                       Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Magenta)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Magenta)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Magenta)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Magenta)
                       Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Magenta)

                   }
               }

           }

           //End of Row

       }
    }

}

@Preview(showBackground = true)
@Composable
fun ItemScreenPreview(){
    ItemScreen(navController= rememberNavController())
}