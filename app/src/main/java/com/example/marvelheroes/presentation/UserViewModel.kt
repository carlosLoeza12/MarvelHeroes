package com.example.marvelheroes.presentation
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelheroes.data.model.User
import com.example.marvelheroes.repository.DoLoginFacebook
import com.facebook.CallbackManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val doLoginFacebook: DoLoginFacebook): ViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User>
        get() = _user

    fun doLoginFacebook(callbackManager: CallbackManager, fragment: Fragment){
        viewModelScope.launch {
            when (val userData = doLoginFacebook.getDataFacebook(callbackManager, fragment)) {
                is User -> {
                    _user.postValue(userData)
                }
                else -> {
                    Log.e("error","error")
                }
            }
        }
    }

}