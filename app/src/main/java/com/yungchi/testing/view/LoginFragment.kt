package com.yungchi.testing.view

import android.app.ProgressDialog
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.yungchi.testing.R
import com.yungchi.testing.viewmodel.DemoViewModel
import com.yungchi.testing.viewmodel.IDemoViewData
import com.yungchi.testing.viewmodel.LoginActivityViewModel
import com.yungchi.testing.viewmodel.LoginProtocol
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * Created by i9400514 on 2020/09/04.
 */
class LoginFragment : Fragment(), LoginProtocol {
    lateinit var viewModel: LoginActivityViewModel
    lateinit var mDemoViewModel: DemoViewModel
    lateinit var mProgressDialog: ProgressDialog
    lateinit var mFragmentActivity: FragmentActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Data binding start=================
//        val factoryCalenderViewModelFactory = LoginActivityViewModelFactory()
//        viewModel = ViewModelProviders.of(this, factoryCalenderViewModelFactory)
//            .get(LoginActivityViewModel::class.java)

        viewModel = LoginActivityViewModel()

        // TODO for demoTest
        mFragmentActivity = this.requireActivity()
        mDemoViewModel = DemoViewModel(iDemoViewData);
        mProgressDialog = ProgressDialog(mFragmentActivity)
        mProgressDialog.setTitle("登入中")
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
            val account = et_account.text.toString()
            val password = et_password.text.toString()
            if ("" == account || "" == password) {
                tv_hint.text = ""
                val toast = Toast.makeText(mFragmentActivity, "帳號或密碼不可為空!!!", Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
                toast.show()
            } else {
                viewModel.submit()
                mDemoViewModel.doLogin()
                mProgressDialog.show()
            }
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

    // TODO for demoTest
    private var iDemoViewData = object : IDemoViewData {
        override fun updateUserInfo(userName: String, userID: String) {
            mFragmentActivity.runOnUiThread {
                mProgressDialog.dismiss()
                var msg: String
                if ("" == userID) {
                    msg = "登入失敗"
                } else {
                    msg = "登入成功"
                    tv_hint.text = "Name: $userName, ID: $userID"
                }
                val toast = Toast.makeText(mFragmentActivity, msg, Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
                toast.show()
            }
        }
    }
}