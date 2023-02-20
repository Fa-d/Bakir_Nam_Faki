package com.kolpolok.nord.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kolpolok.nord.core.DispatcherProvider
import com.kolpolok.nord.core.sealed.GenericState
import com.kolpolok.nord.data.database.model.ServerEntity
import com.kolpolok.nord.data.repository.FirebaseManager
import com.kolpolok.nord.data.repository.SessionManager
import com.kolpolok.nord.data.repository.UrlSessionManager
import com.kolpolok.nord.helpers.ViewState
import com.kolpolok.nord.helpers.toServerEntity
import com.kolpolok.nord.model.login.LoginRequest
import com.kolpolok.nord.model.login.suc.LoginSuccessResponse
import com.kolpolok.nord.model.usecase.GetLoginDetailsUseCase
import com.kolpolok.nord.model.usecase.InsertIntoDatabaseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    // private val apiRepository: APIRepository,
    private val getLoginDetailsUseCase: GetLoginDetailsUseCase,
    private val insertIntoDatabaseUseCase: InsertIntoDatabaseUseCase,
    val urlSessionManager: UrlSessionManager,
    val sessionManager: SessionManager,
    val firebaseManager: FirebaseManager,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {
    val viewState = MutableLiveData<ViewState>(ViewState.NONE)

    val _uiState = MutableStateFlow<GenericState<LoginSuccessResponse>>(GenericState.None)
    val uiState: StateFlow<GenericState<LoginSuccessResponse>> = _uiState

    val _insertedIntoDB = MutableStateFlow<GenericState<Boolean>>(GenericState.None)
    val insertedIntoDB: StateFlow<GenericState<Boolean>> = _insertedIntoDB

    fun getLoginDetails(loginRequest: LoginRequest) {
        _uiState.value = GenericState.Loading
        viewModelScope.launch(dispatcherProvider.main) {
            getLoginDetailsUseCase(loginRequest).flowOn(dispatcherProvider.io).catch {
                _uiState.value = GenericState.Error(it.message.orEmpty())
            }.collect {
                _uiState.value = GenericState.Success(it)

                val serverList = mutableListOf<ServerEntity>()
                it.ipBundle.forEach { bundle ->
                    serverList.add(bundle.toServerEntity())
                }
                insertServerListIntoDatabase(serverList)
            }
        }
    }

    private fun insertServerListIntoDatabase(response: List<ServerEntity>) {
        viewModelScope.launch(dispatcherProvider.main) {
            insertIntoDatabaseUseCase(response).flowOn(dispatcherProvider.io).catch {
                _insertedIntoDB.value = GenericState.Error(it.message.orEmpty())
            }.collect {
                _insertedIntoDB.value = GenericState.Success(it)
            }
        }
    }
}