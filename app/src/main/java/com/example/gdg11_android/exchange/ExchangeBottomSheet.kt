package com.example.gdg11_android.exchange

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.gdg11_android.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import retrofit2.http.GET

data class shop(
    var name:String,
)
data class giftImage(
    var cover_url:String
)

data class Giftinfo(
    var id:Int,
    var name:String,
    var Shop:shop,
    var GiftImage:giftImage
)
//
//interface GiftAPI{
//    @GET("V1/gifts/my")
//    fun getgiftinfo(
//
//    ): Call<UserinfoResponse>
//}


class ExchangeBottomSheet : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v:View=inflater.inflate(R.layout.exchange_bottom_sheet,container,false)

        v.findViewById<Button>(R.id.button).setOnClickListener {
            val mActivity=activity as ExchangeActivity
            mActivity.plusResponse(-1)
        }
        return v
    }

}