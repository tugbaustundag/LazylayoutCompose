package com.smality.lazylayoutswithcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.smality.lazylayoutswithcompose.ui.theme.JetpackCompose_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackCompose_AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Conversation(SampleData.conversationSample)
                }
            }
        }
    }
}

data class Message(val author: String, val body: String)
//Mesajlar için örnek verilerin bulunduğu diziyi oluşturma
object SampleData {
    val conversationSample = listOf(
        Message(
            "Tuğba",
            "Android versiyonları:\n" +
                    "Android Lollipop (API 21)\n" +
                    "Android Marshmallow (API 23)\n" +
                    "Android Nougat (API 24)\n" +
                    "Android Oreo (API 26)\n" +
                    "Android Pie (API 28)\n" +
                    "Android 10 (API 29)\n" +
                    "Android 11 (API 30)\n" +
                    "Android 12 (API 31)\n"
        ),
        Message(
            "Tuğba",
            "Bence Kotlin piratik ve kullanımı kolay bir dil olduğu için eğlenceli bir yapısı bulunmaktadır"
        ),

        Message(
            "Tuğba",
            "Jetpack Compose, modern Android UI yapısı sunmaktadır.\n" +
                    "Android'de kullanıcı arayüzü geliştirmeyi basitleştirir ve hızlandırır." +
                    "Daha az kod ile güçlü araçlar sunmaktadır.."
        ),
        Message(
            "Tuğba",
            "Yakın zamanda bütün yazılımcılar UI yapısını Compose ile yazacak:)"
        ),

        Message(
            "Tuğba",
            "Artık emülatörü direkt Android Studio içinde çalıştırabilirsiniz...."
        ),

        Message(
            "Tuğba",
            "Kotlin ile Android Programlama özel dersi verdiğimi biliyor muydunuz?"
        ),
    )
}
//Mesaj balonu alanının tasarımı
@Composable
fun MessageCard(msg: Message) {
    val context = LocalContext.current
    Row(modifier = Modifier.padding(all = 8.dp)) {

        Image(
            painter = painterResource(id =  R.drawable.icon),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                 //Resime tıklayınca LazyGrid örneğine yönlendirme
                .clickable {
                    context.startActivity(Intent(context, LazyGrid::class.java))
                }

        )
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            //Yazar isiminin  alanını oluşturma
            Text(
                text = msg.author,
                color = MaterialTheme.colors.secondary,
                style = MaterialTheme.typography.subtitle1
            )

            Spacer(modifier = Modifier.height(4.dp))
            //Mesaj içeriğinin alanını oluşturma
            Surface(shape = MaterialTheme.shapes.medium, elevation = 30.dp) {
                Text(
                    text = msg.body,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier
                        .border(1.5.dp, MaterialTheme.colors.onPrimary)
                        .padding(all = 15.dp)
                )

            }
        }
    }
}
//LazyColumn tanımlama
@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }

}

//Örnek veriyi kullanarak tasarımı gösterme
@Preview
@Composable
fun preview_rec() {
    Conversation(SampleData.conversationSample)

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    MessageCard(
        msg = Message("Android", "Hey, take a look at Jetpack Compose, it's great!")
    )}