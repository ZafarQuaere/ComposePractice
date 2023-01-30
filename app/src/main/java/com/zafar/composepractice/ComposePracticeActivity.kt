package com.zafar.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


class ComposePracticeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //ConstraintLayout
//            ConstraintComposable()

            //SimpleAnimation
            var sizeState by remember{
                mutableStateOf(200.dp)
            }

            val size by animateDpAsState(targetValue = sizeState)
            
            Box(modifier = Modifier
                .size(size)
                .background(Color.Black),
                contentAlignment = Alignment.Center){
                Button(onClick = { sizeState += 30.dp }) {
                    Text("Increase size")
                }
            }
        }
    }
}