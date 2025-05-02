package com.vabian.edusmart.ui.theme.screens.intent
//got from >>> https://github.com/GloryAkinyi/jet/blob/master/app/src/main/java/com/example/jetpackcomposecourseoutline/IntentsActivity.kt
import android.content.Intent
import android.provider.MediaStore
import android.provider.Settings
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.vabian.edusmart.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vabian.edusmart.navigation.ROUT_MORE


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IntentScreen(navController: NavController){
    Column(modifier = Modifier.fillMaxSize()) {

        val mContext = LocalContext.current
        //Top app bar
        TopAppBar(
            title = { Text(text = "Intents") },
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
                IconButton(onClick = {
                    val shareIntent=Intent(Intent.ACTION_SEND)
                    shareIntent.type="text/plain"
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this is a cool content")
                    mContext.startActivity(Intent.createChooser(shareIntent, "Share"))


                }) {
                    Icon(imageVector = Icons.Default.Share, contentDescription = "")
                }
                IconButton(onClick = {
                    val settingsIntent=Intent(Settings.ACTION_SETTINGS)
                    mContext.startActivity(settingsIntent)


                }) {
                    Icon(imageVector = Icons.Default.Settings, contentDescription = "")
                }
                IconButton(onClick = {
                    navController.navigate(ROUT_MORE)

                }) {
                    Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "")
                }
            },




            )
        //End of top app bar

        Spacer(modifier = Modifier.height(20.dp))
        //Mpesa
        Button(
            onClick = {
                val simToolKitLaunchIntent =
                    mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                simToolKitLaunchIntent?.let { mContext.startActivity(it) }


            },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)
        ) {
            Text(
                text = "MPESA",
                fontSize = 18.sp
            )
        }
        Button(
            onClick = {
                val smsIntent=Intent(Intent.ACTION_SENDTO)
                smsIntent.data="smsto:0758084405".toUri()
                smsIntent.putExtra("sms_body","Hello Vabian,how was your day?")
                mContext.startActivity(smsIntent)

            },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)
        ) {
            Text(
                text = "SMS",
                fontSize = 18.sp
            )
        }
        Button(
            onClick = {
                val callIntent=Intent(Intent.ACTION_DIAL)
                callIntent.data="tel:0758084405".toUri()
                mContext.startActivity(callIntent)

            },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)
        ) {
            Text(
                text = "CALL",
                fontSize = 18.sp
            )
        }
        Button(
            onClick = {
                val shareIntent=Intent(Intent.ACTION_SEND)
                shareIntent.type="text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this is a cool content")
                mContext.startActivity(Intent.createChooser(shareIntent, "Share"))

            },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)
        ) {
            Text(
                text = "SHARE",
                fontSize = 18.sp
            )
        }
        Button(
            onClick = {
                val cameraIntent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (cameraIntent.resolveActivity(mContext.packageManager)!=null){
                    mContext.startActivity(cameraIntent)
                }else{
                    println("Camera app is not available")
                }

            },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)
        ) {
            Text(
                text = "CAMERA",
                fontSize = 18.sp
            )
        }
        Button(
            onClick = {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("akinyiglory2@gmail.com"))
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                mContext.startActivity(shareIntent)

            },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)
        ) {
            Text(
                text = "EMAIL",
                fontSize = 18.sp
            )
        }
        Button(
            onClick = {
                val settingsIntent=Intent(Settings.ACTION_SETTINGS)
                mContext.startActivity(settingsIntent)


            },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)
        ) {
            Text(
                text = "SETTINGS",
                fontSize = 18.sp
            )
        }

    }


}

@Preview(showBackground = true)
@Composable
fun IntentScreenPreview(){
    IntentScreen(navController= rememberNavController())
}