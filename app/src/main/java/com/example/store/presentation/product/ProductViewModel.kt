package com.example.store.presentation.product

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.store.common.Resource
import com.example.store.domain.use_case.GetProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val getProductUseCase: GetProductUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(ProductState())
        val state: State<ProductState> = _state

    init {
        savedStateHandle.get<String>("id")?.let { id ->
            getProduct(id)
        }
    }

    private fun getProduct(id: String){
        getProductUseCase(id).onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = ProductState(product = result.data)
                }
                is Resource.Error -> {
                    _state.value = ProductState(error = "Sehv")
                }
                is Resource.Loading -> {
                    _state.value = ProductState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}