package com.yungchi.testing.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.yungchi.testing.R
import com.yungchi.testing.viewmodel.LoginActivityViewModel
import com.yungchi.testing.viewmodel.LoginProtocol
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * Created by i9400514 on 2020/09/04.
 */
class LoginFragment : Fragment(), LoginProtocol {
    lateinit var viewModel: LoginActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Data binding start=================
//        val factoryCalenderViewModelFactory = LoginActivityViewModelFactory()
//        viewModel = ViewModelProviders.of(this, factoryCalenderViewModelFactory)
//            .get(LoginActivityViewModel::class.java)

        viewModel = LoginActivityViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //        var adapter = EventTypeSpinAdapter(context)
//        event_type_spinner.adapter = adapter
        viewModel.mEventTypeList.observe(viewLifecycleOwner, Observer { data ->
            if (data.isNotEmpty()) {
//                adapter.updateData(data)
                event_type_spinner.adapter = EventTypeSpinAdapter(requireContext(), data)
            }
        })

        viewModel.initEventTypeList()

        btn_login.setOnClickListener() {
            var pw = et_password.text.toString()
            if ("12345678".equals(pw)) {
                tv_hint.text = "login success"
            } else {
                tv_hint.text = "login failed"
            }
            viewModel.submit()
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }

    override fun onPause() {
        super.onPause()
        viewModel.onPause()
    }

    override fun onDestroy() {
        viewModel.onDestroy()
        super.onDestroy()
    }

    override fun backParentActivity() {
        TODO("Not yet implemented")
    }

    override fun startNextActivity() {
        TODO("Not yet implemented")
    }
}