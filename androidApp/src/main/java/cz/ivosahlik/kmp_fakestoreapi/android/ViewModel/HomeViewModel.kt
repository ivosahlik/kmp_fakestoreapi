package cz.ivosahlik.kmp_fakestoreapi.android.ViewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.ivosahlik.kmp_fakestoreapi.Constants.LIMIT_COUNT
import cz.ivosahlik.kmp_fakestoreapi.Constants.SORT
import cz.ivosahlik.kmp_fakestoreapi.ProductsApi
import cz.ivosahlik.kmp_fakestoreapi.RequestState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    private var _requestState: MutableState<RequestState> = mutableStateOf(RequestState.Idle)
    val requestState: State<RequestState> = _requestState

    init {
        viewModelScope.launch(Dispatchers.Main) {
            ProductsApi().fetchProductsByLimitAndSort(limit = LIMIT_COUNT, sort = SORT).collectLatest {
                _requestState.value = it
            }
        }
    }
}