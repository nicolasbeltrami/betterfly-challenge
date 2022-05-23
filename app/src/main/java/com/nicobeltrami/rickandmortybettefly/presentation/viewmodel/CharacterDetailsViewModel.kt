package com.nicobeltrami.rickandmortybettefly.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicobeltrami.rickandmortybettefly.data.model.Character
import com.nicobeltrami.rickandmortybettefly.domain.usecase.GetCharacterByIdUseCase
import com.nicobeltrami.rickandmortybettefly.presentation.model.CharacterDetailsScreenEvent
import com.nicobeltrami.rickandmortybettefly.presentation.model.CharacterDetailsScreenState
import com.nicobeltrami.rickandmortybettefly.presentation.model.CharacterMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    private val useCase: GetCharacterByIdUseCase,
    private val mapper: CharacterMapper
) : ViewModel() {

    private val _screenState: MutableLiveData<CharacterDetailsScreenState> = MutableLiveData()
    val screenState: LiveData<CharacterDetailsScreenState>
        get() = _screenState

    fun postEvent(event: CharacterDetailsScreenEvent) {
        manageEvent(event)
    }

    fun setState(state: CharacterDetailsScreenState) {
        _screenState.value = state
    }

    private fun manageEvent(event: CharacterDetailsScreenEvent) {
        when (event) {
            is CharacterDetailsScreenEvent.OnInitEvent -> {
                getCharacterById(event.id)
            }
        }
    }

    private fun getCharacterById(id: Int) {
        viewModelScope.launch {
            val result = useCase.invoke(id)
            getCharacterDetail(result)
        }
    }

    private fun getCharacterDetail(character: Character) {
        setState(CharacterDetailsScreenState.OnDataLoadedState(
            mapper.fromDomainToViewCharacterViewState(character)
        ))
    }
}
