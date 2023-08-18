import androidx.compose.foundation.border
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    val items = remember { mutableStateListOf<String>() }
    val lazyListState = rememberLazyListState()

    LaunchedEffect(items) {
        items.addAll(List(100) { "$it" })
    }

    LazyColumn(state = lazyListState) {
        itemsIndexed(items) { index, item ->
            BasicTextField(
                value = item,
                onValueChange = { items[index] = it },
                modifier = Modifier.border(Dp.Hairline, Color.Black)
            )
        }
    }
}

expect fun getPlatformName(): String