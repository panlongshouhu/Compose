package com.example.compose

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ui.theme.ComposeTheme
import io.flutter.embedding.android.FlutterActivity

class MainActivity : ComponentActivity() {
    var context : Context? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainPage()
                }
            }
        }
    }

@Composable
fun MainPage(){
//    Greeting("你好")
    var students = mutableListOf("顶部")
    for(i in 0..20){
        students.add("${i}")
    }
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .verticalScroll(rememberScrollState())
    ) {
        students.forEachIndexed {index, it ->
            studentItem(index,student = it)
        }
    }
}

@Composable
fun studentItem(index:Int,student:String){
    Button(modifier = Modifier.fillMaxWidth().height(40.dp), onClick = {
        when(index){
            0->zeroItem()
        }
    }) {
        Text(text = student,modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),fontSize = 14.sp,
            textAlign = TextAlign.Center)
    }
}

fun zeroItem(){
//    Toast.makeText(context,"nihao",Toast.LENGTH_SHORT).show()
    startActivity(FlutterActivity
        .withNewEngine()
        .initialRoute("/index")
        .build(context!!))
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTheme {
        MainPage()
    }
}

}