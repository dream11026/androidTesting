package com.yungchi.testing.model

class LoginRequest(private var login: ILoginResponse, private var data: DataModel) : ILoginRequest {

    override fun sendRequest() {
        // TODO send API
//        Thread {
//            // TODO Delay 3000 millis to simulate response
//            Thread.sleep(2000)
//            data.returnCode = returnCode //success:0, fail:1
            // TODO 要 mark 起來 才會有 call back
            if (data.returnCode == 0) {
                data.userID = "A12345678A"
                data.userName = "我是誰?"
                login.onSuccess()
            } else {
                data.userID = "123"
                data.userName = "123"
                login.onFail()
            }
//        }.start()
    }
}

interface ILoginRequest {
    fun sendRequest()
}