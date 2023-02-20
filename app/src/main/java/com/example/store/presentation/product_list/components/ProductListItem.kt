package com.example.store.presentation.product_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.store.domain.model.ProductList

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ProductListItem(
    productList: ProductList
) {
    Box(modifier = Modifier.fillMaxSize()){
        Column(
            Modifier
                .fillMaxSize()
                .clickable {  },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
             {
                Image(
                    painter = rememberImagePainter(data = productList.image),
                    contentDescription = "",
                    modifier = Modifier.size(150.dp).padding(10.dp)
                )
                Text(
                    text = productList.title,
                    Modifier.padding(start = 10.dp, end = 10.dp, bottom = 5.dp),
                    maxLines = 1
                )
            }

            
        }
    }