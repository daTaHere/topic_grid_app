package com.example.topic_grid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon


import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.topic_grid.model.Topic
import com.example.topic_grid.ui.theme.Topic_GridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Topic_GridTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun TopicApp() {
    Surface {

    }

}

@Composable
fun TopicCard(topic: Topic ,modifier: Modifier = Modifier) {
    Card( modifier = modifier ) {
        Row (
            modifier = modifier
        ){
            Image(
                painter = painterResource(id = topic.imageId),
                contentDescription = stringResource(id = topic.nameId),
                modifier = modifier
            )
           Column(modifier = modifier) {
               Row (modifier = modifier.padding(top = 9.dp)){
                   Text(
                       text = stringResource(id = topic.nameId),
                       style = MaterialTheme.typography.bodyMedium,
                       modifier = modifier
                           .padding(horizontal = 16.dp)
                   )
               }
               Row (modifier = modifier.padding(start = 16.dp, top = 5.dp)){
                    Icon(
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = "menu",
                        modifier = modifier
                            .size(17.dp)
                    )

                   Text(
                       text = topic.id.toString(),
                       style = MaterialTheme.typography.labelMedium,
                       modifier = modifier
                           .align(alignment = Alignment.CenterVertically)
                           .padding(start = 8.dp)
                   )
               }

           }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun TopicCardPreview(){

    TopicCard(topic = Topic(R.string.photography, 321, R.drawable.photography))
}