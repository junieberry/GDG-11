package com.example.gdg11_android

import com.example.gdg11_android.dto.GetFeedData
import com.example.gdg11_android.dto.TokenData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {
    @GET("post")
    fun feedList(
        @Header("Authorization") access_token: String,
        @Query("page") page : String,
    ):Single<List<GetFeedData>>

    @GET("v1/auth/google")
    fun getToken(
        @Query("time") time : String
    ) : Single<TokenData>

}