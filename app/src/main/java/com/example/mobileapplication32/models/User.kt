package com.example.mobileapplication32.models

data class User(
    val userID : String,
    val profileAvatar : String ?= "",
    val userDescription : String ?= ""
) {
    constructor() : this("", "", "")
}
