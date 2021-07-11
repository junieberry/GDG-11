package com.example.gdg11_android.pref

import android.content.Context
import android.content.SharedPreferences

class SharedPrefStorage(val context: Context) : LocalStorage {

    private val accessTokenKey = "AccessToken"
    private val refreshTokenKey = "RefreshToken"

    override fun saveAccessToken(token: String) =
        getPref(context).edit().let {
            it.putString(accessTokenKey, token)
            it.apply()
        }

    override fun saveRefreshToken(token: String) =
        getPref(context).edit().let {
            it.putString(accessTokenKey, token)
            it.apply()
        }

    override fun getAccessToken(): String =
        "Bearer eyJlbWFpbCI6IjA0MDYwNmNtakBnbWFpbC5jb20iLCJ0eXBlIjoiYWNjZXNzIiwiaWF0IjoxNjI1OTU4NjY0LCJleHAiOjE2MjU5NjU4NjR9.hD5KCTFpd3ThomB4VLWxBkNuIDn7QPvlqALOgkHLZYU"

    override fun getRefreshToken(): String =
        "Bearer " + getPref(context).getString(refreshTokenKey, "")

    override fun removeTokens() =
        getPref(context).edit().let {
            it.remove(accessTokenKey)
            it.remove(refreshTokenKey)
            it.apply()
        }
    private fun getPref(context: Context): SharedPreferences =
        context.getSharedPreferences("pref", Context.MODE_PRIVATE)
}