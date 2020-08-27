package com.yungchi.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_login.setOnClickListener {
            var pw = et_password.text.toString()
            if ("12345678".equals(pw)) {
                tv_hint.text = "login success"
            } else {
                tv_hint.text = "login failed"
            }
        }
    }
}
