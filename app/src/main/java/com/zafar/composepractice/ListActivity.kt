package com.zafar.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.overscroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ListActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Simple way to show vertical scroll with items.
           /* val scrollState = rememberScrollState()
            Column (modifier = Modifier.verticalScroll(scrollState)){
                for(i in 1..50){
                    Text(
                        text = "Item no : $i",
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 14.dp)

                    )
                }
            }*/

            // Lazy Column wihtout state.
            LazyColumn{
                items(1000){
                    Text(
                        text = "Item no : $it",
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 14.dp)
                    )
                }
            }
        }
    }
}

