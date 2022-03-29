package com.example.marvelheroes.core

import android.app.Activity
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

fun Activity.toolbar(toolbar: Toolbar){
    (this as AppCompatActivity).setSupportActionBar(toolbar)
    this.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    toolbar.setNavigationOnClickListener {
        this.onBackPressed()
    }
    toolbar.navigationIcon?.setTint(Color.WHITE)
}
