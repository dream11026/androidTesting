package com.yungchi.testing.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yungchi.testing.common.ViewModelProtocol
import com.yungchi.testing.model.EventTypeSpinModel
import com.yungchi.testing.utils.GsonUtil

interface InputProtocol {
    fun doSomeTing()
}

interface OutputProtocol {
    val state: Boolean
}

interface LoginProtocol {
    fun backParentActivity()
    fun startNextActivity()
}

//class ViewModeInput : Input {
//    override fun doSomeTing() {
//        TODO("Not yet implemented")
//    }
//}
//
//class ViewModelOutput : Output {
//    override val state: Boolean
//        get() = TODO("Not yet implemented")
//}

class LoginActivityViewModel(private val loginProtocol: LoginProtocol? = null) : ViewModel(),
    ViewModelProtocol {

    private val tag = this.javaClass.simpleName

    //事件類型清單
    var mEventTypeList = MutableLiveData<List<EventTypeSpinModel>>() // todo  single event
    var eventTypePosition = MutableLiveData<Int>()
    private var selectedClsCode: String? = null
        get() {
            //更新選擇的事件類型代碼
            return mEventTypeList.value?.get(eventTypePosition.value ?: 0)?.CLS_CODE
        }

    private var submitMap = hashMapOf<String, String?>()

    init {
    }

    fun initEventTypeList() {
        var data: List<Map<String, String>> = listOf(
            mapOf(
                "CLS_CODE" to "11",
                "CLS_NM" to "11",
                "BRCOLOR" to "11",
                "BGCOLOR" to "11"
            ),
            mapOf(
                "CLS_CODE" to "22",
                "CLS_NM" to "22",
                "BRCOLOR" to "22",
                "BGCOLOR" to "22"
            )
        )
        mEventTypeList.value = GsonUtil.listToBean<List<EventTypeSpinModel>>(data)
    }

    fun submit() {
        submitMap["MAIN_CLS_CODE"] = selectedClsCode //主類別代號(ex: B0000)
        Log.d(tag, "submit => $submitMap")
        loginProtocol?.startNextActivity()
    }

    override fun onCreate() {
    }

    override fun onPause() {
    }

    override fun onResume() {
    }

    override fun onDestroy() {
    }
}

//class LoginActivityViewModelFactory() : ViewModelProvider.Factory {
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return LoginActivityViewModel() as T
//    }
//}