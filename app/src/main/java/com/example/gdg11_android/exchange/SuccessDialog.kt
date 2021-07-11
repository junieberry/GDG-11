package com.example.gdg11_android.exchange

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Point
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import com.example.gdg11_android.R

class SuccessDialog(context: Context) : Dialog(context) {
    val dlg=Dialog(context)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dlg.setContentView(R.layout.exchange_success_dialog)
        dlg.setCancelable(false)
        dlg.show()
        dlg.findViewById<Button>(R.id.success_dialog_btn).setOnClickListener {
            dlg.dismiss()
        }
    }

}