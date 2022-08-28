package com.smality.lazylayoutswithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import com.smality.lazylayoutswithcompose.ui.theme.JetpackCompose_AppTheme

class LazyGrid : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackCompose_AppTheme {
                val state = rememberLazyListState(
                    initialFirstVisibleItemIndex = 80
                )
                val colorNamesList = listOf("Jetpack Compose ile OnBoarding Oluşturma","Android Wear Uygulama Geliştirme","TextView'e Reveal Animasyonu Ekleme","Jetpack Compose ile Adım Adım Tasarım","Apk Uygulama İçi Güncelleme", "Android View ile Compose Birlikte Kullanımı", "Jetpack Compose ile Paralaks Efekt Oluşturma", "Insecure Data Storage","Macrobenchmark ile Android App Performans Ölçümü")
                LazyVerticalGrid(
                    //Grid hücrelerinin kaplıyacağı alanı belirliyoruz
                    cells = GridCells.Adaptive(140.dp),
                    state = state,
                    content = {
                        //Her item'ın listelendiği bölüm
                        itemsIndexed(colorNamesList) { index, item ->
                            //Gri renkdekş kutuları oluşturuyoruz
                            Box(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .aspectRatio(1f)
                                    .clip(RoundedCornerShape(5.dp))
                                    .background(Color.LightGray),
                                contentAlignment = Alignment.Center
                            ) {
                                //Makale başlıklarını her item için Txt elementine aktarıyoruz
                                Text(text = "$item",fontSize = 24.sp,fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                )
            }
        }
    }
}