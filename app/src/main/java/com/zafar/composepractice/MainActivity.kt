package com.zafar.composepractice

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SnapshotMutationPolicy
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            TextStyles() // text Styling
            // State in Compose
            Column(Modifier.fillMaxSize()) {
                val color = remember {
                    mutableStateOf(Color.Yellow)
                }
                ColorBox(modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()) {
                    color.value = it
                }
                Box(modifier = Modifier
                    .background(color.value)
                    .weight(1f)
                    .fillMaxSize())
                Box(modifier = Modifier
                    .background(Color.Magenta)
                    .weight(0.5f)
                    .fillMaxSize()
                    .clickable {
//                        startActivity(Intent(this@MainActivity, LoginActivity::class.java))
                        startActivity(Intent(this@MainActivity, ListActivity::class.java))
                    },){
                    Text(text = "Move to Next Screen",style = TextStyle(Color.White, fontSize = 16.sp))
                }

            }

            // Image Card with title and gradient
           /* Box(modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(16.dp)) {// Card Image
                val painter = painterResource(id = R.drawable.my_image)
                val desc = "Jetpack Compose Practice"
                val title = "Jetpack Compose Practice"
                ImageCard(painter = painter, contentDescription = desc, title = title)
            }*/
        }
    }
}

@Composable
fun ColorBox(modifier: Modifier = Modifier, updateColor: (Color) -> Unit) {
    Box(modifier = modifier
        .background(Color.Red)
        .clickable {
            updateColor(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            )
        }){
        Text(
            text = "Click here to change color of middle space", style = TextStyle(Color.White, fontSize = 16.sp)
        )
    }
}

@Composable
fun ImageCard(painter: Painter, contentDescription: String, title: String, modifier: Modifier = Modifier) {
    Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(15.dp), elevation = 6.dp) {
        Box(modifier = Modifier.height(200.dp)) { // This box is for Image, text and gradient
            Image(painter = painter, contentDescription = contentDescription, contentScale = ContentScale.Crop)
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black),
                        startY = 300f
                    )
                ))
            Box( // this box is for text
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = title, style = TextStyle(Color.White, fontSize = 16.sp)
                )
            }

        }
    }
}

@Composable
fun TextStyles() {
    val fontFamily = FontFamily(
        Font(R.font.lexend_thin, FontWeight.Thin),
        Font(R.font.lexend_light, FontWeight.Light),
        Font(R.font.lexend_regular, FontWeight.Normal),
        Font(R.font.lexend_medium, FontWeight.Medium),
        Font(R.font.lexend_semi_bold, FontWeight.SemiBold),
        Font(R.font.lexend_bold, FontWeight.Bold),
        Font(R.font.lexend_extra_bold, FontWeight.ExtraBold)
    )
    // Styling
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF101010))
    ) {
        Text(
//          text = "Jetpack Compose", // General Text
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Green, fontSize = 50.sp

                    )
                ) {
                    append("J")
                }
                append("etpack ")

                withStyle(
                    style = SpanStyle(
                        color = Color.Green, fontSize = 50.sp

                    )
                ) {
                    append("C")
                }
                append("ompose ")
            },
            color = Color.White,
            fontSize = 30.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline
        )
    }

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name! \nCompose Inceptions")
    TextButton(onClick = {
        navigate()
    }) {

    }
}

fun navigate() {
//    this.startActivity(Intent(this,LoginActivity::class.java))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
//    Greeting("Zafar")
}

@Preview(showBackground = true)
@Composable
fun ImageCardPreview() {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .padding(16.dp)
    ) {
        val painter = painterResource(id = R.drawable.my_image)
        val desc = "Jetpack Compose Practice"
        val title = "Jetpack Compose Practice"
        ImageCard(painter = painter, contentDescription = desc, title = title)
    }
}
