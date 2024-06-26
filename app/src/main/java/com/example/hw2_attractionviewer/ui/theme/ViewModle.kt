package com.example.hw2_attractionviewer.ui.theme

import androidx.lifecycle.ViewModel
import com.example.hw2_attractionviewer.data.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ViewerViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState : StateFlow<UiState> =_uiState.asStateFlow()

    fun setDataNumber(inputNum: Int){
        _uiState.update {currentState ->
            currentState.copy(
                dataNumber = inputNum
            )
        }
    }

    fun getDataNumber(): Int {
        return uiState.value.dataNumber
    }

}