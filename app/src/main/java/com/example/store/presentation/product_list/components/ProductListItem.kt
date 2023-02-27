package com.example.store.presentation.product_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.example.store.domain.model.ProductList
import com.example.store.presentation.product_list.ProductListViewModel

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ProductListItem(
    productList: ProductList,
    navController: NavController
) {

    Box(modifier = Modifier.fillMaxSize()){
        Column(
            Modifier
                .fillMaxSize()
                .clickable {
                    navController.navigate("product/${productList.id}")
                }
                .shadow(1.dp, RectangleShape),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
             {
                     val painter = rememberImagePainter(productList.image)
                     if (painter.state is ImagePainter.State.Loading){
                         Box(modifier = Modifier.size(150.dp)){
                             CircularProgressIndicator(
                                 color = Color.Blue,
                                 modifier = Modifier.align(Alignment.Center)
                             )
                         }

                     }
                     else {
                         Image(
                             painter = painter,
                             contentDescription = "",
                             modifier = Modifier
                                 .size(150.dp)
                                 .padding(10.dp)
                         )
                     }





                Text(
                    text = productList.title,
                    Modifier.padding(start = 10.dp, end = 10.dp, bottom = 5.dp),
                    maxLines = 1,
                    fontWeight = FontWeight.Bold
                )
                 Text(
                     text = "  ${productList.price} ₼  ",
                     Modifier
                         .padding(start = 10.dp, end = 10.dp, bottom = 15.dp)
                         .background(colorResource(id = com.example.store.R.color.mavi), shape = CircleShape)
                     ,
                     Color.White,
                     fontSize = 20.sp
                 )
            }

            
        }
    }