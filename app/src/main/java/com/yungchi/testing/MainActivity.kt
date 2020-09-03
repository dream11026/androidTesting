package com.yungchi.testing

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.yungchi.testing.view.EventTypeSpinAdapter
import com.yungchi.testing.viewmodel.MainActivityViewModel
import com.yungchi.testing.viewmodel.MainActivityViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val context: Context by lazy { this }

    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Data binding start=================
        val factoryCalenderViewModelFactory = MainActivityViewModelFactory(application)
        viewModel = ViewModelProviders.of(this, factoryCalenderViewModelFactory)
            .get(MainActivityViewModel::class.java)

        viewModel.mEventTypeList.observe(this, Observer { data ->
            if (!data.isEmpty()) {
                event_type_spinner.adapter = EventTypeSpinAdapter(context, data)
            }
        })

        viewModel.initEventTypeList()

        btn_login.setOnClickListener {
            var pw = et_password.text.toString()
            if ("12345678".equals(pw)) {
                tv_hint.text = "login success"
            } else {
                tv_hint.text = "login failed"
            }
            viewModel.submit()
        }
    }
}
