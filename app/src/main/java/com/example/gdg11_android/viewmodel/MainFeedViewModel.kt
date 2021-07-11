package com.example.gdg11_android.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.gdg11_android.activity.MainActivity
import com.example.gdg11_android.adapter.MainFeedAdapter
import com.example.gdg11_android.base.BaseApi
import com.example.gdg11_android.base.BaseViewModel
import com.example.gdg11_android.base.SingleLiveEvent
import com.example.gdg11_android.dto.GetFeedData
import com.example.gdg11_android.fragment.MainFeedFragment
import com.example.gdg11_android.pref.LocalStorage
import com.example.gdg11_android.pref.SharedPrefStorage
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import java.time.LocalDateTime

class MainFeedViewModel(
    val sharedPrefStorage: LocalStorage,
    val api : BaseApi,
    val mainFeedFragment: MainFeedFragment
):BaseViewModel() {
    private val baseApi = api.getInstance()
    val successEvent = SingleLiveEvent<Unit>()
    val failEvent = SingleLiveEvent<String>()

    var feedList = MutableLiveData<List<GetFeedData>>()

    fun getFeed(){
        val apiResult = baseApi.feedList("1","1")
        val disposableSingleObserver = object : DisposableSingleObserver<ArrayList<GetFeedData>>(){
            override fun onSuccess(t: ArrayList<GetFeedData>) {
                println("성공")
                println(t[1])
                feedList.value = t
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
    fun onItemClick(){
        successEvent.setValue(Unit)
    }
}


