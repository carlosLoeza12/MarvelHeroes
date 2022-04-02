package com.example.marvelheroes.core

import android.content.Context
import javax.inject.Inject

class InternetCheck @Inject constructor(private val context: Context) {
    val isConnected get() = context.networkInfo?.isConnectedOrConnecting == true
}