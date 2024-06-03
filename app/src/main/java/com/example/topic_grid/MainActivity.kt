package com.example.topic_grid


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.topic_grid.data.DataSource
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
                        .fillMaxSize()
                        .statusBarsPadding(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopicGrid(
                        modifier = Modifier.padding(
                            start = 8.dp,
                            end = 8.dp,
                            top = 8.dp
                        )
                    )
                }
            }
        }
    }
}

// loops elements of a Topic class and displays data vertical in a fixed 2 Column grid
@Composable
fun TopicGrid(modifier: Modifier = Modifier){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(DataSource.topics) { topic -> 
            TopicCard(topic = topic)
        }
    }
}

// Card with image and text
@Composable
fun TopicCard(topic: Topic ,modifier: Modifier = Modifier) {
    Card {
        Row {
            Box{
                Image(
                    painter = painterResource(id = topic.imageId),
                    contentDescription = stringResource(id = topic.nameId),
                    modifier = modifier
                        .size(width = 68.dp, height = 68.dp)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
            }
           Column(modifier = modifier) {
               Text(
                   text = stringResource(id = topic.nameId),
                   style = MaterialTheme.typography.bodyMedium,
                   modifier = modifier
                       .padding(
                           top = 16.dp,
                           bottom = 8.dp,
                           start = 16.dp,
                           end = 16.dp
                       )
               )
               Row (verticalAlignment = Alignment.CenterVertically){
                 Icon(
                     painter = painterResource(id = R.drawable.ic_grain),
                      null,
                     modifier = modifier.padding(start = 16.dp)
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

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopicCard(topic = Topic(R.string.photography, 321, R.drawable.photography))
    }

}