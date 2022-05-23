package com.nicobeltrami.rickandmortybettefly.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import coil.load
import coil.size.Precision
import coil.size.Scale
import com.nicobeltrami.rickandmortybettefly.databinding.ActivityDetailsBinding
import com.nicobeltrami.rickandmortybettefly.presentation.model.CharacterDetailsScreenEvent
import com.nicobeltrami.rickandmortybettefly.presentation.model.CharacterDetailsScreenState
import com.nicobeltrami.rickandmortybettefly.presentation.model.CharacterState
import com.nicobeltrami.rickandmortybettefly.presentation.viewmodel.CharacterDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    private val binding by lazy { ActivityDetailsBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<CharacterDetailsViewModel>()
    private var id: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getIdFromExtras()
        observeViewModelChanges()
        viewModel.postEvent(CharacterDetailsScreenEvent.OnInitEvent(id))

    }

    private fun observeViewModelChanges() {
        viewModel.screenState.observe(this) { state ->
            when (state) {
                is CharacterDetailsScreenState.OnDataLoadingState -> {
                    hideUi()
                }
                is CharacterDetailsScreenState.OnDataLoadedState -> {
                    showUi()
                    getCharacter(state.character)
                }
            }
        }
    }

    private fun getCharacter(character: CharacterState) {
        with(binding) {
            ivDetailImage.load(character.image) {
                scale(Scale.FIT)
                precision(Precision.EXACT)
            }
            tvNameDetail.text = character.name
            tvGenderDetail.text = character.gender
            tvSpecieDetail.text = character.species
            tvStatusDetail.text = character.status
            tvOriginDetail.text = character.origin.name
            tvLocationDetail.text = character.location.name
        }
    }

    private fun getIdFromExtras() {
        val characterId = intent.getIntExtra("ID", 0)
        id = characterId
    }

    private fun hideUi() {
        binding.clDetails.isVisible = false
        binding.pbDetails.isVisible = true
    }

    private fun showUi() {
        binding.clDetails.isVisible = true
        binding.pbDetails.isVisible = false
    }
}