package com.example.marvelheroes.presentation
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelheroes.application.AppConstants
import com.example.marvelheroes.application.Prefs
import com.example.marvelheroes.data.model.User
import com.example.marvelheroes.repository.DoLoginFacebook
import com.facebook.CallbackManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val doLoginFacebook: DoLoginFacebook, private val prefs: Prefs): ViewModel() {

    private val _is_saved_user = MutableLiveData<Boolean>()
    val is_saved_user: LiveData<Boolean>
        get() = _is_saved_user

    fun doLoginFacebook(callbackManager: CallbackManager, fragment: Fragment){
        viewModelScope.launch {
            when (val userData = doLoginFacebook.getDataFacebook(callbackManager, fragment)) {
                is User -> {
                    saveUser(userData)
                }
                else -> {
                    Log.e("error","error")
                }
            }
        }
    }

    fun doLoginGoogle(fragment: Fragment){
        viewModelScope.launch {
            try {
                val googleConf = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestId()
                    .requestEmail()
                    .requestProfile()
                    .build()

                val googleClient  = GoogleSignIn.getClient(fragment.requireActivity(), googleConf)
                googleClient.signOut()
                fragment.startActivityForResult(googleClient.signInIntent, AppConstants.RC_GOOGLE_SIGNING)
            }catch (e: Exception){
                Log.e("error","error")
            }
        }
    }

    fun saveUser(user: User){
        prefs.saveName(user.name.toString())
        prefs.saveEmail(user.email.toString())
        prefs.saveLastName(user.lastName.toString())
        prefs.saveSignInType(user.signInType)
        prefs.saveUrlProfile(user.urlProfile.toString())
        prefs.saveUserId(user.id)
        prefs.saveSession(true)
        //navigate
        _is_saved_user.postValue(true)
        Log.e("aa", "${prefs.getName()}, ${prefs.getLastName()}, ${prefs.getEmail()}")
    }

}