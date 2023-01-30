package com.zafar.composepractice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

// How to use constraint layout in compose.
@Composable
fun ConstraintComposable() {
    val constraints = ConstraintSet {
        val greenBox = createRefFor("greenbox")
        val redBox = createRefFor("redbox")
        //create guideline for compose
        val guideline = createGuidelineFromTop(0.5f)
        constrain(greenBox) {
            top.linkTo(guideline)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }

        constrain(redBox) {
            top.linkTo(parent.top)
            start.linkTo(greenBox.end)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        createHorizontalChain(greenBox,redBox, chainStyle = ChainStyle.Spread) // to chain our constraint
    }
    ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .background(Color.Green)
                .layoutId("greenbox")
        )
        Box(
            modifier = Modifier
                .background(Color.Red)
                .layoutId("redbox")
        )
    }
}

// this composable will show the image with card view and title
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

//Customization of text and styling in text
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
