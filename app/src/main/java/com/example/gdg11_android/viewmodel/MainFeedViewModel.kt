package com.example.gdg11_android.viewmodel

import com.example.gdg11_android.base.BaseApi
import com.example.gdg11_android.base.BaseViewModel
import com.example.gdg11_android.base.SingleLiveEvent
import com.example.gdg11_android.dto.GetFeedData
import com.example.gdg11_android.pref.LocalStorage
import com.example.gdg11_android.pref.SharedPrefStorage
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import java.time.LocalDateTime

class MainFeedViewModel(
    val sharedPrefStorage: LocalStorage,
    val api : BaseApi
):BaseViewModel() {
    private val baseApi = api.getInstance()
    val successEvent = SingleLiveEvent<Unit>()
    val failEvent = SingleLiveEvent<String>()
    val accessToken = sharedPrefStorage.getAccessToken()

    fun getFeed(){
        val time = System.currentTimeMillis().toString()
        val apiResult = baseApi.feedList("1","1")
        val disposableSingleObserver = object : DisposableSingleObserver<List<GetFeedData>>(){
            override fun onSuccess(t: List<GetFeedData>) {
                println("성공")
                println(t[1])
                successEvent.setValue(Unit)
            }

            override fun onError(e: Throwable) {
                println("실패")
                failEvent.setValue("실패메세지")
            }
        }
        val observer = apiResult
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(disposableSingleObserver)

        addDisposable(observer)
    }
}


