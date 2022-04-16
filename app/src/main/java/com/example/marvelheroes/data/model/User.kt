package com.example.marvelheroes.data.model

data class User(val id : String = "",
                val name: String? ="",
                val lastName : String? = "",
                val email: String? = "",
                val urlProfile: String?="",
                val signInType: String = "")

