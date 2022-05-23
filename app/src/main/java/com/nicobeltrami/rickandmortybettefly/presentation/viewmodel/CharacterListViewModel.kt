package com.nicobeltrami.rickandmortybettefly.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicobeltrami.rickandmortybettefly.data.model.Character
import com.nicobeltrami.rickandmortybettefly.domain.usecase.FetchCharactersUseCase
import com.nicobeltrami.rickandmortybettefly.presentation.model.CharacterMapper
import com.nicobeltrami.rickandmortybettefly.presentation.model.ScreenEvent
import com.nicobeltrami.rickandmortybettefly.presentation.model.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val useCase: FetchCharactersUseCase,
    private val mapper: CharacterMapper
) : ViewModel() {

    private val _screenState: MutableLiveData<ScreenState> = MutableLiveData()
    val screenState: LiveData<ScreenState>
        get() = _screenState

    fun postEvent(event: ScreenEvent) {
        manageEvent(event)
    }

    fun setState(state: ScreenState) {
        _screenState.value = state
    }

    private fun manageEvent(event: ScreenEvent) {
        when (event) {
            is ScreenEvent.OnInitEvent -> {
                getList()
            }
        }
    }

    private fun getList() {
        viewModelScope.launch {
            setState(ScreenState.OnLoadingState)
            val result = useCase.invoke().results
            getCharacters(result)
        }
    }

    private fun getCharacters(characters: List<Character>) {
        setState(ScreenState.OnLoadingState)
        setState(
            ScreenState.OnLoadedState(
                mapper.fromDomainToViewState(characters)
            )
        )
    }
}
