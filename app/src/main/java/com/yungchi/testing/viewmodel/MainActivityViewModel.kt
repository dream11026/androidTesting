package com.yungchi.testing.viewmodel

import android.app.Application
import android.nfc.Tag
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yungchi.testing.model.EventTypeSpinModel
import com.yungchi.testing.utils.GsonUtil

class MainActivityViewModel constructor(
    application: Application
) : AndroidViewModel(application) {

    private val tag = this.javaClass.simpleName

    //事件類型清單
    var mEventTypeList = MutableLiveData<List<EventTypeSpinModel>>()
    var eventTypePosition = MutableLiveData<Int>()
    private var selectedClsCode: String? = null
        get() {
            //更新選擇的事件類型代碼
            return mEventTypeList.value?.get(eventTypePosition.value ?: 0)?.CLS_CODE
        }
    private var submitMap = hashMapOf<String, String?>()

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

    fun submit () {
        submitMap["MAIN_CLS_CODE"] = selectedClsCode //主類別代號(ex: B0000)
        Log.d(tag, "submit => $submitMap")
    }
}

class MainActivityViewModelFactory(
    private val application: Application
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(application) as T
    }
}