package com.example.gdg11_android.exchange

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Point
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import com.example.gdg11_android.R

class SuccessDialog (context: Context){
    val dlg=Dialog(context)

    fun start(){

        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dlg.setContentView(R.layout.exchange_success_dialog)
        dlg.setCancelable(false)

        dlg.findViewById<Button>(R.id.success_dialog_btn).setOnClickListener {
            //어쩌구
            dlg.dismiss()
        }

        dlg.show()
    }
}