package cz.ivosahlik.kmp_fakestoreapi.android.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen () {

    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.surface), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }

}