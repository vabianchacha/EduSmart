package com.vabian.edusmart.ui.theme.screens.more

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.vabian.edusmart.R
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreScreen(navController: NavController){
    Column (modifier = Modifier.fillMaxSize()){
        val mContext = LocalContext.current

        //Top app bar
        TopAppBar(
            title = { Text(text = "More products") },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Magenta,
                titleContentColor = Color.White,
                navigationIconContentColor = Color.White,
                actionIconContentColor = Color.White

            ),
            //Display om the left
            navigationIcon = {
                IconButton(onClick = {
                    val simToolKitLaunchIntent =
                        mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                    simToolKitLaunchIntent?.let { mContext.startActivity(it) }
                }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                }
            },
            //Display on the right
            actions = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "")
                }
            },




            )
        //End of top app bar
        Spacer(modifier = Modifier.height( 10.dp))
        //SearchBar
        var search by remember { mutableStateOf("") }
        OutlinedTextField(
            value = search,
            onValueChange = {search=it},
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp),
            leadingIcon = {Icon(imageVector = Icons.Default.Search, contentDescription = "")},
            placeholder = {Text(text = "Search more products...")}
        )
        //End of searchBar
        Spacer(modifier = Modifier.height( 10.dp))

        //Box
        Box(modifier = Modifier.fillMaxWidth().height(250.dp), contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(R.drawable.uniform1),
                contentDescription = "home",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillWidth

            )
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "",
                //tint = Color.White,
                modifier = Modifier.align(alignment = Alignment.TopEnd).padding(all = 15.dp)
            )
            Text(
                text = "Find the best Products",
                fontSize = 30.sp,
                color = Color.White,
                fontWeight = FontWeight.ExtraBold
            )
        }

        Spacer(modifier = Modifier.height( 10.dp))

        Text(
            text = "Popular types of watches",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height( 10.dp))

        //Row
        Row(
            modifier = Modifier.padding(start = 20.dp).horizontalScroll(rememberScrollState())
        ) {
            //Column
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(R.drawable.img_1),
                    contentDescription = "home",
                    modifier = Modifier.width(150.dp).height(150.dp).clip(shape = RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.FillBounds
                )
                Text(
                    text = "Silver watches",
                    fontSize = 15.sp
                )
                Text(
                    text = "Ksh 10,000",
                    fontSize = 15.sp
                )
                Button(
                    onClick = {
                        val simToolKitLaunchIntent =
                            mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                        simToolKitLaunchIntent?.let { mContext.startActivity(it) }
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(Color.Magenta)
                ) {
                    Text(text = "Purchase")
                }
            }
            //End of column
            Spacer(modifier = Modifier.width( 10.dp))
            //Column
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(R.drawable.img_1),
                    contentDescription = "home",
                    modifier = Modifier.width(150.dp).height(150.dp).clip(shape = RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.FillBounds
                )
                Text(
                    text = "Smart watches",
                    fontSize = 15.sp
                )
                Text(
                    text = "Ksh 10,000",
                    fontSize = 15.sp
                )
                Button(
                    onClick = {
                        val simToolKitLaunchIntent =
                            mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                        simToolKitLaunchIntent?.let { mContext.startActivity(it) }
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(Color.Magenta)
                ) {
                    Text(text = "Purchase")
                }
            }
            //End of column
            Spacer(modifier = Modifier.width( 10.dp))
            //Column
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(R.drawable.img_1),
                    contentDescription = "home",
                    modifier = Modifier.width(150.dp).height(150.dp).clip(shape = RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.FillBounds
                )
                Text(
                    text = "Black watches",
                    fontSize = 15.sp
                )
                Text(
                    text = "Ksh 10,000",
                    fontSize = 15.sp
                )
                Button(
                    onClick = {
                        val simToolKitLaunchIntent =
                            mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                        simToolKitLaunchIntent?.let { mContext.startActivity(it) }
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(Color.Magenta)
                ) {
                    Text(text = "Purchase")
                }
            }
            //End of column
            Spacer(modifier = Modifier.width( 10.dp))
            //Column
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(R.drawable.img_1),
                    contentDescription = "home",
                    modifier = Modifier.width(150.dp).height(150.dp).clip(shape = RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.FillBounds
                )
                Text(
                    text = "Golden watches",
                    fontSize = 15.sp
                )
                Text(
                    text = "Ksh 10,000",
                    fontSize = 15.sp
                )
                Button(
                    onClick = {
                        val simToolKitLaunchIntent =
                            mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                        simToolKitLaunchIntent?.let { mContext.startActivity(it) }
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(Color.Magenta)
                ) {
                    Text(text = "Purchase")
                }
            }
            //End of column
            Spacer(modifier = Modifier.width( 10.dp))
            //Column
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(R.drawable.img_1),
                    contentDescription = "home",
                    modifier = Modifier.width(150.dp).height(150.dp).clip(shape = RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.FillBounds
                )
                Text(
                    text = "Bronze watches",
                    fontSize = 15.sp
                )
                Text(
                    text = "Ksh 10,000",
                    fontSize = 15.sp
                )
                Button(
                    onClick = {
                        val simToolKitLaunchIntent =
                            mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                        simToolKitLaunchIntent?.let { mContext.startActivity(it) }
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(Color.Magenta)
                ) {
                    Text(text = "Purchase")
                }
            }
            //End of column
            Spacer(modifier = Modifier.width( 10.dp))
            //Column
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(R.drawable.img_1),
                    contentDescription = "home",
                    modifier = Modifier.width(150.dp).height(150.dp).clip(shape = RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.FillBounds
                )
                Text(
                    text = "Analogue watches",
                    fontSize = 15.sp
                )
                Text(
                    text = "Ksh 10,000",
                    fontSize = 15.sp
                )
                Button(
                    onClick = {
                        val simToolKitLaunchIntent =
                            mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                        simToolKitLaunchIntent?.let { mContext.startActivity(it) }
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(Color.Magenta)
                ) {
                    Text(text = "Purchase")
                }
            }
            //End of column
            Spacer(modifier = Modifier.width( 10.dp))
            //Column
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(R.drawable.img_1),
                    contentDescription = "home",
                    modifier = Modifier.width(150.dp).height(150.dp).clip(shape = RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.FillBounds
                )
                Text(
                    text = "Alloyed watches",
                    fontSize = 15.sp
                )
                Text(
                    text = "Ksh 10,000",
                    fontSize = 15.sp
                )
                Button(
                    onClick = {
                        val simToolKitLaunchIntent =
                            mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                        simToolKitLaunchIntent?.let { mContext.startActivity(it) }
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(Color.Magenta)
                ) {
                    Text(text = "Purchase")
                }
            }
            //End of column
            Spacer(modifier = Modifier.width( 10.dp))

        }

        //End of Row

    }
}

@Preview(showBackground = true)
@Composable
fun MoreScreenPreview(){
    MoreScreen(navController= rememberNavController())
}