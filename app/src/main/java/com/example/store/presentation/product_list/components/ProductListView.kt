package com.example.store.presentation.product_list.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.store.R
import com.example.store.presentation.product_list.ProductListViewModel
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductListView(
    navController: NavController,
    productListViewModel: ProductListViewModel = hiltViewModel()
    ) {

    var bottomState by remember{ mutableStateOf("Home") }

    val error = productListViewModel.state.value.error
    val productListState = productListViewModel.state.value


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Store App", color = Color.White)},
                backgroundColor = colorResource(id = R.color.mavi))
        },
        content = {


            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ){


            if (productListState.isLoading){
                    CircularProgressIndicator(color = Color.Blue)
                }
            }


                var checkedStateAll by remember { mutableStateOf(true) }
                var checkedStateJewelery by remember { mutableStateOf(false) }
                var checkedStateElectronics by remember { mutableStateOf(false) }
                var checkedStateMensClothing by remember { mutableStateOf(false) }
                var checkedStateWomensClothing by remember { mutableStateOf(false) }

                Column() {

                    LazyRow(
                        Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        item{

                           Checkbox(checked = checkedStateAll, onCheckedChange = {checkedStateAll = it})
                            Text(text = "All")

                            Checkbox(checked = checkedStateJewelery, onCheckedChange = {checkedStateJewelery = it})
                            Text(text = "Jewelery")

                            Checkbox(checked = checkedStateElectronics, onCheckedChange = {checkedStateElectronics = it})
                            Text(text = "Electronics")

                            Checkbox(checked = checkedStateMensClothing, onCheckedChange = {checkedStateMensClothing = it})
                            Text(text = "Men's clothing")

                            Checkbox(checked = checkedStateWomensClothing, onCheckedChange = {checkedStateWomensClothing = it})
                            Text(text = "Women's clothing")


                        }
                    }


                    if (checkedStateAll){
                        LazyVerticalGrid(
                            modifier = Modifier.padding(bottom = 50.dp),
                            cells = GridCells.Fixed(2),
                            content = {
                                items(productListState.productList) { product ->
                                    ProductListItem(productList = product, navController = navController)
                                }
                            })
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
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "",
                            tint = Color.White
                        )},
                )

                BottomNavigationItem(
                    selected = bottomState == "List",
                    onClick = { bottomState = "List" },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.List,
                            contentDescription = "",
                            tint = Color.White
                        ) }
                )

                BottomNavigationItem(
                    selected = bottomState == "Account",
                    onClick = { bottomState = "Account" },
                    icon = { Icon(tint = Color.White, imageVector = Icons.Default.AccountCircle, contentDescription = "") }
                )
            }
        }


                )

            }


@Composable
fun RetryView(
    error: String,
    onRetry: () -> Unit
){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(error, color = Color.Red)
        Button(onClick = onRetry) {
            Text(text = "Retry")
        }

    }
}