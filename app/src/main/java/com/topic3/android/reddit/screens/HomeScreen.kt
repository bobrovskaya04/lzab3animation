package com.topic3.android.reddit.screens

import androidx.compose.runtime.Composable

@Composable
fun HomeScreen() {
    val posts: List<PostModel> by viewModel.allPosts.observeAsState(listOf())

    LazyColumn(modifier = Modifier.background(color= MaterialTheme.colors.secondary)){
        items(posts){
            if (it.type == PostType.TEXT){
                TextPost(it)
            } else{
                ImagePost(it)
            }
            Spacer(modifier = Modifier.height(6.dp))
        }
    }
    AnimatedVisibility(
        visible = visible,
        enter =  slideInVertically (initialOffsetY = { +40 }) + fadeIn(),
        exit =  slideOutVertically() + fadeOut()
    ){
        ToastContent()
    }

}