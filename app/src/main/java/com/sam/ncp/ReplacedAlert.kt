package com.sam.ncp

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.widget.TextView

class ReplacedAlert : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE) //hide activity title
        setContentView(R.layout.dialog)

        val intent = intent
        val AN = intent.getStringExtra("extra")

        val Dlg = AlertDialog.Builder(this, AlertDialog.BUTTON_NEUTRAL)

        val title = TextView(this)
        title.text = "replaced"
        title.setBackgroundColor(Color.BLACK)
        title.setTextColor(Color.WHITE)
        title.setPadding(10, 10, 10, 10)
        title.gravity = Gravity.CENTER // this is required to bring it to center.
        title.textSize = 18f
        Dlg.setCustomTitle(title)
        Dlg.setMessage("info : $AN")

        Dlg.setCancelable(false)
        Dlg.setPositiveButton("ok") { dialog, arg1 ->
            dialog.cancel()

            finish()
        }

        val alert = Dlg.create()
        alert.show()

    }
}
