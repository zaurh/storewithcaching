package com.example.store.presentation.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.store.R

@Composable
fun ProductView(
    productViewModel: ProductViewModel = hiltViewModel()
) {
    val state = productViewModel.state.value
    var bottomState by remember{ mutableStateOf("Home") }

    Box(modifier = Modifier.fillMaxSize()){
        Scaffold(
            topBar = {
                TopAppBar(title = { Text(text = "Store App", color = Color.White)}, backgroundColor = colorResource(
                    id = R.color.mavi
                ))
            },
            content = {
                if (state.isLoading){
                    Column(
                        Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        CircularProgressIndicator(color = Color.Blue)
                    }
                }
                Column(
                    Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(modifier = Modifier.height(300.dp)){
                        state.product?.let { product ->
                            Image(
                                painter = rememberImagePainter(data = product.image),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(300.dp)
                                    .padding(top = 20.dp, bottom = 50.dp)
                            )
                        }
                    }
                    Box(modifier = Modifier.padding(10.dp)) {
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                            state.product?.let { product ->
                                Text(
                                    text = "  ${product.price} ₼  ",
                                    Modifier
                                        .background(
                                            colorResource(id = R.color.mavi),
                                            shape = CircleShape
                                        )
                                    ,
                                    Color.White,
                                    fontSize = 25.sp
                                )
                                Button(
                                    onClick = { /*TODO*/ },
                                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(
                                        id = R.color.boz
                                    ))
                                ) {
                                    Text(text = "+ Add to cart")
                                }
                            }
                        }
                    }
                    Box(
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(15))
                            .background(
                                color = colorResource(id = R.color.boz)
                            )
                    ) {

                        state.product?.let { product ->
                            Column(
                                Modifier
                                    .fillMaxSize()
                                    .padding(top = 20.dp)) {
                                Text(
                                    text = product.title,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(start = 15.dp, end = 15.dp),
                                    fontSize = 25.sp
                                )
                                LazyColumn{
                                    item{

                                        Spacer(modifier = Modifier.size(20.dp))
                                        Text(
                                            text = product.description,
                                            modifier = Modifier.padding(start = 15.dp, end = 15.dp, bottom = 100.dp)
                                        )
                                    }

                                }
                            }


                        }
                    }
                }
            },
            bottomBar = {
                BottomAppBar(
                    backgroundColor = colorResource(id = R.color.mavi)
                ) {
                    BottomNavigationItem(
                        selected = bottomState == "Home",
                        onClick = { bottomState = "Home" },
                        icon = { 
                            Icon(imageVector = Icons.Default.Home,
                                contentDescription = "",
                                tint = Color.White
                                ) }
                    )

                    BottomNavigationItem(
                        selected = bottomState == "List",
                        onClick = { bottomState = "List" },
                        icon = { Icon(imageVector = Icons.Default.List, contentDescription = "", tint = Color.White) }
                    )

                    BottomNavigationItem(
                        selected = bottomState == "Account",
                        onClick = { bottomState = "Account" },
                        icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "", tint = Color.White) }
                    )
                }
            }

        )



        }
    }