package com.example.gdg11_android.exchange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.gdg11_android.R
import com.example.gdg11_android.databinding.ActivityExchangeBinding
import io.reactivex.Emitter
import io.socket.client.IO
import io.socket.client.Socket
import org.json.JSONObject
import java.net.URISyntaxException

class ExchangeActivity : AppCompatActivity() {
    lateinit var binding:ActivityExchangeBinding
    lateinit var mSocket:Socket

    var room_id="1231232"
    var post_id=1
    var status=0 //buyer, seller

    val TAG="로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityExchangeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()


        val setProfile:io.socket.emitter.Emitter.Listener=io.socket.emitter.Emitter.Listener {
                it->
            val data=it[0] as JSONObject
            binding.youName.text=data.getString("name")
        }
        val setmoreResponse:io.socket.emitter.Emitter.Listener=io.socket.emitter.Emitter.Listener {
                it->
            binding.youResponse.text="더주세요"

        }

        mSocket.on("joinComplete", setProfile)
        mSocket.on("requestMoreGift",setmoreResponse)
        
    }



    fun init(){
        try {
            //소켓 서버 연결
           mSocket=IO.socket("http://34.146.141.114:3000")
            mSocket.connect()

            mSocket.on(Socket.EVENT_CONNECT) {
                println("성공")
            }.on(Socket.EVENT_CONNECT_ERROR) {
                println("실패")
            }


            val data=JSONObject()
            data.put("room",room_id)
            data.put("post_id",post_id)
            if(status==1){
                mSocket.emit("joinRoomBuyer",data)
            }
            else{
                mSocket.emit("joinRoomSeller",data)
            }
            Log.d(TAG,"Socket connected")

        }catch (e:URISyntaxException){
            Log.d(TAG,"Socket connection failed")
        }
    }

    fun plusResponse(id:Int){
        if (id==-1){mSocket.emit("requestMoreGift")}
        else{
            val data=JSONObject()
            data.put("gift_id",id)
            mSocket.emit("addGift")}
    }


    fun plus_clicked(v:View){
        val plus_view= ExchangeBottomSheet()
        plus_view.show(supportFragmentManager,"plus_view")
    }

    fun o_clicked(v:View){
        mSocket.emit("requestAccept")
    }

    fun x_clicked(v:View){
        mSocket.emit("requestLeaveRoom")
    }


    fun success_dialog(){
        SuccessDialog(context = this).show()
    }

    fun fail_dialog(){
        FailDialog(context = this).start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mSocket.disconnect()
        Log.d(TAG,"Socket disconnected")
    }

}