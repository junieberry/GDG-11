package com.example.gdg11_android.exchange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.gdg11_android.databinding.ActivityExchangeBinding
import io.socket.client.IO
import io.socket.client.Socket
import org.json.JSONObject
import java.net.URISyntaxException

class ExchangeActivity : AppCompatActivity() {
    lateinit var binding:ActivityExchangeBinding
    lateinit var mSocket:Socket

    var roo
    val TAG="로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityExchangeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

    }



    fun init(){
        try {
            //소켓 서버 연결결
           mSocket=IO.socket("http://34.146.141.114:3000")
            mSocket.connect()
            val data=JSONObject()
            data.put("room",room_id)
            mSocket.emit("joinRoomBuyer")

            Log.d(TAG,"Socket connected")
        }catch (e:URISyntaxException){
            Log.d(TAG,"Socket connection failed")
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        mSocket.disconnect()
        Log.d(TAG,"Socket disconnected")
    }

    fun plus_clicked(v:View){
        val plus_view= ExchangeBottomSheet()
        plus_view.show(supportFragmentManager,"plus_view")
    }
    fun o_clicked(v:View){
        mSocket.emit("requestAccept")
    }
    fun x_clicked(v:View){
        fail_dialog()

    }

    fun success_dialog(){
        SuccessDialog(context = this).show()
    }

    fun fail_dialog(){
        FailDialog(context = this).start()
    }
}