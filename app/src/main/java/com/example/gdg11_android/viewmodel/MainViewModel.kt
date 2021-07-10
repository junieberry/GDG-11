package com.example.gdg11_android.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.gdg11_android.base.BaseApi
import com.example.gdg11_android.base.BaseViewModel
import com.example.gdg11_android.base.SingleLiveEvent
import com.example.gdg11_android.dto.GetFeedData
import com.example.gdg11_android.dto.TokenData
import com.example.gdg11_android.pref.LocalStorage
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import java.time.LocalDateTime

class MainViewModel(private val sharedPreferences: LocalStorage,
                    api: BaseApi ):BaseViewModel() {

    private val baseApi = api.getInstance()
    val successEvent = SingleLiveEvent<Unit>()
    val failEvent = SingleLiveEvent<String>()

    @RequiresApi(Build.VERSION_CODES.O)
    fun getToken(){
        val time = LocalDateTime.now()

        val apiResult = baseApi.getToken("$time")
        val disposableSingleObserver = object : DisposableSingleObserver<TokenData>(){
            override fun onSuccess(t: TokenData) {
                println("성공")
                sharedPreferences.saveAccessToken(t.access_token)
                sharedPreferences.saveRefreshToken(t.refresh_token)
                successEvent.setValue(Unit)
            }

            override fun onError(e: Throwable) {
                println("실패")
                failEvent.setValue("실패메세")
            }
        }
        val observer = apiResult
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(disposableSingleObserver)

        addDisposable(observer)
    }
}