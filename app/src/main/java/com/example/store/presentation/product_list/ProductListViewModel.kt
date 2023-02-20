package com.example.store.presentation.product_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.store.common.Resource
import com.example.store.domain.use_case.GetProductListUseCase
import com.example.store.presentation.product_list.components.ProductListView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val useCase: GetProductListUseCase
): ViewModel() {

    private val _state = mutableStateOf(ProductListState())
        val state: State<ProductListState> = _state

    init {
        getProductList()

    }

    private fun getProductList(){
        ProductListState(isLoading = true)
        useCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = ProductListState(productList = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _state.value = ProductListState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = ProductListState(error = "Xeta oldu")
                }
            }

        }.launchIn(viewModelScope)
    }
}