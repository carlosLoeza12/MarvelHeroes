package com.example.marvelheroes.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelheroes.data.model.Results
import com.example.marvelheroes.repository.HeroesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroesViewModel @Inject constructor(private val heroesRepository: HeroesRepository): ViewModel() {

    val listHeroes = MutableLiveData<Results>()
    val isLoading = MutableLiveData<Boolean>()
    val positionRecycler = MutableLiveData<Int>()

    fun getListHeroes(){
        isLoading.postValue(true)
        viewModelScope.launch {
            try {
                val result = heroesRepository.getListHeroes()
                if (!result.data.results.isNullOrEmpty()) {
                    isLoading.postValue(false)
                    listHeroes.postValue(result.data)
                }
            } catch (e: Exception) {
                isLoading.postValue(false)
            }
        }
    }

}


