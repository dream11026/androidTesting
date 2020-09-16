package com.yungchi.testing.viewmodel

import com.yungchi.testing.model.DataModel
import com.yungchi.testing.model.ILoginResponse
import com.yungchi.testing.model.LoginRequest

class DemoViewModel(private var iDemoViewData: IDemoViewData) : IDemoViewModel {
    var data: DataModel = DataModel()
    //TODO for test Input/Output
    override fun doLogin() {
        LoginRequest(iLoginResponse, data).sendRequest()
    }

    private var iLoginResponse = object : ILoginResponse {
        var tempName = ""
        var tempID = ""
        override fun onSuccess() {
            tempName = data.userName
            tempID = data.userID
            if (tempID.length == 10) {
                tempID = tempID.replaceRange(3, 7, "*****")
            }
            updateUserInfo(tempName, tempID)
        }

        override fun onFail() {
            tempName = ""
            tempID = ""
            updateUserInfo(tempName, tempID)
        }
    }

    private fun updateUserInfo(tempName: String, tempID: String) {
            iDemoViewData.updateUserInfo(tempName, tempID)
    }
}

interface IDemoViewModel {
   fun doLogin()
}