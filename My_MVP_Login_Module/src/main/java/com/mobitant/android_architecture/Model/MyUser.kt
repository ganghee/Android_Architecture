package com.mobitant.android_architecture.Model

interface MyUser {
    val email:String
    val password:String
    fun isDataValid():Int
}

