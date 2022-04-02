package com.example.marvelheroes.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelheroes.data.model.Heroe
import com.example.marvelheroes.data.model.HeroesSeries
import com.example.marvelheroes.repository.HeroesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroesViewModel @Inject constructor(private val heroesRepository: HeroesRepository): ViewModel() {

    val listHeroes = MutableLiveData<List<Heroe>>()
    val listHeroesSeries = MutableLiveData<List<HeroesSeries>>()
    val isLoading = MutableLiveData<Boolean>()
    val isLoadingSeries = MutableLiveData<Boolean>()
    val positionRecycler = MutableLiveData<Int>()

    fun getListHeroes(){
        isLoading.postValue(true)
        viewModelScope.launch {
            try {
                val result = heroesRepository.getListHeroes()
                if (!result.isNullOrEmpty()) {
                    isLoading.postValue(false)
                    listHeroes.postValue(result)
                }
            } catch (e: Exception) {
                isLoading.postValue(false)
            }
        }
    }

    fun getListSeriesByHeroe(idHeroe: Int){
        isLoadingSeries.postValue(true)
        viewModelScope.launch {
            try {
                val result = heroesRepository.getListSeriesByHeroe(idHeroe)
                if (!result.isNullOrEmpty()) {
                    listHeroesSeries.postValue(result)
                    isLoadingSeries.postValue(false)
                }
            } catch (e: Exception) {
                isLoadingSeries.postValue(false)
            }
        }
    }

}


