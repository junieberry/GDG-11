package com.example.gdg11_android.pref

interface LocalStorage {
    fun saveAccessToken(token: String)
    fun saveRefreshToken(token: String)
    fun getAccessToken(): String
    fun getRefreshToken() : String
    fun removeTokens()
}