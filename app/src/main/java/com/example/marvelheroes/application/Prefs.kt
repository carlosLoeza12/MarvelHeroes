package com.example.marvelheroes.application

import android.content.Context
import javax.inject.Inject

class Prefs @Inject constructor(val context: Context) {

    private val SHARED_NAME= "userDB"
    private val storage = context.getSharedPreferences(SHARED_NAME  , 0)

    fun saveName(name: String){
        storage.edit().putString("name", name).apply()
    }
    fun getName() = storage.getString("name","")

    fun saveEmail(email: String){
        storage.edit().putString("email", email).apply()
    }
    fun getEmail() = storage.getString("email","")

    fun saveSession(session: Boolean){
        storage.edit().putBoolean("session", session).apply()
    }
    fun getSession() = storage.getBoolean("session",false)

    fun saveLastName(lastName: String){
        storage.edit().putString("lastName", lastName).apply()
    }
    fun getLastName() = storage.getString("lastName","")

    fun saveUrlProfile(urlProfile: String){
        storage.edit().putString("urlProfile", urlProfile).apply()
    }
    fun getUrlProfile() = storage.getString("urlProfile","")

    fun saveSignInType(type: String){
        storage.edit().putString("type", type).apply()
    }
    fun getSignInType() = storage.getString("type","")

    fun saveUserId(id: String){
        storage.edit().putString("id", id).apply()
    }
    fun getUserId() = storage.getString("id","")

    fun wipe(){
        storage.edit().clear().apply()
    }

}