package com.example.store.presentation.product_list.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.store.presentation.product_list.ProductListViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductListView(
    viewModel: ProductListViewModel = hiltViewModel()
) {

    var bottomState by remember{ mutableStateOf("Home") }

    val state = viewModel.state.value
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Store App")})
        },
        content = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ){
            if (state.isLoading){
                    CircularProgressIndicator(color = Color.Blue)
                }
            }

            if(state.productList.isNotEmpty()){
                LazyVerticalGrid(modifier = Modifier.padding(bottom = 50.dp),cells = GridCells.Fixed(2), content = {
                    items(state.productList){ product ->
                        ProductListItem(productList = product)
                    }
                })
            }

        },

        bottomBar = {
            BottomAppBar {
                BottomNavigationItem(
                    selected = bottomState == "Home",
                    onClick = { bottomState = "Home" },
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "") }
                )

                BottomNavigationItem(
                    selected = bottomState == "List",
                    onClick = { bottomState = "List" },
                    icon = { Icon(imageVector = Icons.Default.List, contentDescription = "") }
                )

                BottomNavigationItem(
                    selected = bottomState == "Account",
                    onClick = { bottomState = "Account" },
                    icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "") }
                )
            }
        }










                )

            }
