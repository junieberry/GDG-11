package com.example.gdg11_android

import com.example.gdg11_android.dto.GetFeedData
import com.example.gdg11_android.dto.TokenData
import io.reactivex.Single
import retrofit2.http.*

interface ApiService {
    @GET("post")
    fun feedList(
        @Query("page") page : String,
        @Query("size") size : String

    ):Single<List<GetFeedData>>

    @GET("auth/google")

    fun getToken(
        @Query("time") time : String
    ) : Single<TokenData>

}